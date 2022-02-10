
package javaapplicationgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ShowMessage extends JFrame{

    public ShowMessage() throws HeadlessException {
        setBounds(500, 300, 485, 100);
        setTitle("Happy Message..");
    
        setBackground(Color.WHITE);
        JTextArea textArea=new JTextArea("Firebase Connected,Now you can able to control \n your appliances from where ever in the World!😊.. ");
        textArea.setBounds(0, 0, 500, 25);
        Font font=new Font("",Font.PLAIN,20);
        textArea.setFont(font);
        textArea.setForeground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(textArea);
        
        try {
            Thread.sleep(2000);
            this.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(ShowMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     public static void main(String args[]){
            new ShowMessage();
        }
    
}
