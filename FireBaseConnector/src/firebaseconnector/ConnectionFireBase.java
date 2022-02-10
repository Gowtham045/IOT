package firebaseconnector;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.awt.HeadlessException;
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConnectionFireBase extends JFrame {

    static Firestore bd;
    static int i = Integer.MAX_VALUE;
    static Socket s;
    static DataOutputStream out;
    static DataInputStream in;

    public ConnectionFireBase() throws HeadlessException {
        setBounds(400, 500, 400, 200);
        setVisible(true);
    }

    public static void connect() {

        FirebaseOptions options = null;
        try {
            FileInputStream refreshToken = new FileInputStream("C:\\Users\\new\\Documents\\NetBeansProjects\\MavenFire\\src\\main\\java\\fireBase\\KEY.json");
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://iot-project-ee3d4-default-rtdb.asia-southeast1.firebasedatabase.app")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException ex) {
            Logger.getLogger(ConnectionFireBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static Socket getSocket(){
        if(s==null){
            try {
                s = new Socket("localhost", 1000);
            } catch (IOException ex) {
               System.out.println("Server is not available..");
              JOptionPane.showMessageDialog(null, "First run The Blutooth Application!");
              System.exit(1);
            }
        }
        return s;
          
    }

    public static void setValue(String value) throws InterruptedException {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(value, new DatabaseReference.CompletionListener() {

            @Override
            public void onComplete(DatabaseError de, DatabaseReference dr) {
                System.out.println("Inserted SuccesFully");

            }
        });

        Thread.sleep(5000);
        System.out.println("Second  " + Thread.currentThread().getName());
        // 
    }

    public static void readValue(String key) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(key);
        try {
            
            out = new DataOutputStream(getSocket().getOutputStream());
        } catch (IOException ex) {
            System.out.println("Server is not available..");
            JOptionPane.showMessageDialog(null, "First run The Blutooth Application!");
            return;
        }

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                sentToServer(ds.getValue(String.class));
                System.out.println("Value Changed --->" + ds.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError de) {
            }
        });
        while (true) {
        }

    }

    private static void sentToServer(String str) {
        System.out.println("Sending to Server....");
        try {

            out.writeUTF(str);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Exception Handled...");
            try {
                System.out.println("Reconnecting server....");
                s = new Socket("localhost", 1000);
                out = new DataOutputStream(s.getOutputStream());
                out.writeUTF(str);
                out.flush();
            } catch (IOException ex1) {
                System.out.println("Server not Available");

            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        File f=new File("CheckFileBlue");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
               System.out.println(ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "App already running "+f.exists()+f.getAbsolutePath());
            return;
        }
        f.deleteOnExit();
        int input = JOptionPane.showConfirmDialog(null, "Click yes to Communicate with Fire Database!", "FireBase Connector", WIDTH);
        
        if (input == 0) {
          
            try {
                URL url=new URL("http://www.google.com");
                URLConnection connection = url.openConnection();
                connection.connect();
                
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "please turn on your internet connection!");
                return;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "please turn on your internet connection!");
                return;
            }
           
            //Firbase connection....
            connect();

            Thread A = new Thread(() -> {
                try {
                    setValue("Welcome..");
                    in=new DataInputStream(getSocket().getInputStream());
                    String str="";
                  while(true){
                       str=in.readUTF();
                       if(str.equals("Close")){
                           setValue("Server in your Home is not running!");
                           JOptionPane.showMessageDialog(null, "Closing Firebase");
                           System.exit(0);
                       }
                       setValue(str);
                       
                  }                
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConnectionFireBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ConnectionFireBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            A.start();
           
            Thread B = new Thread(() -> {
                readValue("Light");

            });
            B.start();
            A.join();
            B.join();
        }

    }
}
