package javaapplicationgui;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.swing.JOptionPane;

public class HC05 {

    static boolean scanFinished = false;
    static RemoteDevice hc05device = null;
    static String hc05Url;
    private static Socket s = null;
    public static boolean isSocketConnected = false;
    Vector<Device> devices = new Vector<>();

    public void scan() throws Exception {
        LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
            @Override
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                try {
                    String name = btDevice.getFriendlyName(false);
                    RemoteDevice dev = btDevice;
                    Device d = new Device(name, dev);
                    devices.add(d);
                    System.out.println(name + " added");

                } catch (IOException ex) {
                    Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void servicesDiscovered(int i, ServiceRecord[] srs) {
                scanFinished = true;
            }

            @Override
            public void serviceSearchCompleted(int i, int i1) {

            }

            @Override
            public void inquiryCompleted(int i) {

            }

        });
    }

    public void conect(String s) throws Exception {
        System.out.println(s);
        if ("HC-05".equals(s)) {
            System.out.println("connecting");
            for (int i = 0; i < devices.size(); i++) {
                if ("HC-05".equals(devices.elementAt(i).name)) {
                    hc05device = devices.elementAt(i).hc05device;
                }

            }
            UUID uuid = new UUID(0x1101); //scan for btspp://... services (as HC-05 offers it)
            UUID[] searchUuidSet = new UUID[]{uuid};
            int[] attrIDs = new int[]{
                0x0100 // service name
            };
            scanFinished = false;
            LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet,
                    hc05device, new DiscoveryListener() {
                @Override
                public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                }

                @Override
                public void inquiryCompleted(int discType) {
                }

                @Override
                public void serviceSearchCompleted(int transID, int respCode) {
                    scanFinished = true;
                }

                @Override
                public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                    for (int i = 0; i < servRecord.length; i++) {
                        hc05Url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                        if (hc05Url != null) {
                            break; //take the first one
                        }
                    }
                }
            });

            while (!scanFinished) {
                Thread.sleep(500);
            }

            System.out.println("got it");
            JOptionPane.showMessageDialog(null, "Connected");
            makeServer();

        } else {
            JOptionPane.showMessageDialog(null, "cannot conect");
            System.out.println("cannot conect");

        }

    }

    private static void makeServer() {
        Thread A = new Thread(() -> {
            try {
                ServerSocket ss = null;
                try {
                    ss = new ServerSocket(1000);
                } catch (Exception j) {
                    System.out.println("Already binded ..");

                    return;
                }

                System.out.println("Waiting for client..");
                s = ss.accept();
                System.out.println("Client Connected....");
                isSocketConnected = true;
                new ShowMessage();
                //JOptionPane.showMessageDialog(null, "Firebase Connected,Now you can able to control your appliances from where ever in the World!😊.. ");
                DataInputStream in = new DataInputStream(s.getInputStream());

                String str = "";
                while (!str.equals("Over")) {
                    try {
                        str = in.readUTF();
                        System.out.println("Data from client-->" + str);
                        sendDataToBlutooth(str);
                    } catch (Exception h) {
                        System.out.println(h);
                        System.out.println("Not able to sent data to bluetooth");
                        int input = JOptionPane.showConfirmDialog(null, "Not able to sent data to bluetooth ,please restart the app");
                        if (input == 0) {
                            System.exit(1);
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        A.start();
      

    }

    public static synchronized void sendDataToBlutooth(String str) {

        if (hc05device != null && hc05Url != null) {
            StreamConnection streamConnection = null;
            try {
                streamConnection = (StreamConnection) Connector.open(hc05Url);
            } catch (Exception r) {
                System.out.println("stream  " + r.toString());
                return;
            }
            {

                try {
                    OutputStream os = streamConnection.openOutputStream();
                    InputStream is = streamConnection.openInputStream();

                    if (str.equals("1")) {
                        os.write("Z".getBytes()); //just send '1' to the device
                        if (s != null) {
                            updateToClient("ON");
                        }
                    } else if (str.equals("0")) {
                        os.write("z".getBytes()); //just send '0' to the device   
                        if (s != null) {
                            updateToClient("OFF");
                        }
                    }
                    os.close();
                    is.close();
                    streamConnection.close();
                    Thread.sleep(500);
                } catch (IOException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("connect first");
        }
    }

    public static String updateToClient(String str) {
        try {
            System.out.println("Data is send to fire Base -> " + str);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(str);
            out.flush();
            return "OK";

        } catch (IOException ex) {
            System.out.println("Can not send Data to clint    " + ex);
        }
        return "Problem";
    }

    public void action1() throws Exception {
        if (hc05device != null) {
            //Bluetooth
            sendDataToBlutooth("1");
        } else {
            System.out.println("connect first");
        }
    }

    public void action2() throws Exception {
        if (hc05device != null) {
            //Bluetooth
            sendDataToBlutooth("0");
        } else {
            System.out.println("connect first");
        }
    }

}
