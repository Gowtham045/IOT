package javaapplicationgui;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainScreen extends javax.swing.JFrame {

    public HC05 hc05 = new HC05();
    public static MainScreen mainScreen = null;

    public MainScreen() {
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing.........");
                if (HC05.isSocketConnected && "OK".equals(HC05.updateToClient("Close"))) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        aboutButton = new javax.swing.JButton();
        connectionButton = new javax.swing.JButton();
        controlButton = new javax.swing.JButton();
        ParentScreen = new javax.swing.JLayeredPane();
        ConnectionScreen = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deviceTable = new javax.swing.JTable();
        ledon = new javax.swing.JButton();
        ledoff4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AboutScreen = new javax.swing.JPanel();
        ControlScreen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setBackground(new java.awt.Color(0, 153, 255));
        sidePanel.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        aboutButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aboutButton.setForeground(new java.awt.Color(0, 153, 255));
        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        connectionButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        connectionButton.setForeground(new java.awt.Color(0, 153, 255));
        connectionButton.setText("Connection");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        controlButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        controlButton.setForeground(new java.awt.Color(0, 153, 255));
        controlButton.setText("Control");
        controlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(connectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(controlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ParentScreen.setLayout(new java.awt.CardLayout());

        ConnectionScreen.setBackground(new java.awt.Color(0, 153, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Connection");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Scan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 255));
        jButton2.setText("Connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));

        deviceTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deviceTable.setForeground(new java.awt.Color(0, 153, 255));
        deviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device name", "Device id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deviceTable.setRowHeight(45);
        jScrollPane1.setViewportView(deviceTable);

        ledon.setText("LED on");
        ledon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledonActionPerformed(evt);
            }
        });

        ledoff4.setText("LED off");
        ledoff4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledoff4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(148, 148, 148)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(ledon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(ledoff4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ledon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ledoff4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout ConnectionScreenLayout = new javax.swing.GroupLayout(ConnectionScreen);
        ConnectionScreen.setLayout(ConnectionScreenLayout);
        ConnectionScreenLayout.setHorizontalGroup(
            ConnectionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConnectionScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConnectionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ConnectionScreenLayout.setVerticalGroup(
            ConnectionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectionScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ParentScreen.add(ConnectionScreen, "card3");

        AboutScreen.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout AboutScreenLayout = new javax.swing.GroupLayout(AboutScreen);
        AboutScreen.setLayout(AboutScreenLayout);
        AboutScreenLayout.setHorizontalGroup(
            AboutScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        AboutScreenLayout.setVerticalGroup(
            AboutScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );

        ParentScreen.add(AboutScreen, "card4");

        ControlScreen.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout ControlScreenLayout = new javax.swing.GroupLayout(ControlScreen);
        ControlScreen.setLayout(ControlScreenLayout);
        ControlScreenLayout.setHorizontalGroup(
            ControlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        ControlScreenLayout.setVerticalGroup(
            ControlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );

        ParentScreen.add(ControlScreen, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParentScreen))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParentScreen)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private static final Logger LOG = Logger.getLogger(MainScreen.class.getName());

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        aboutButton();
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        // TODO add your handling code here:
        connectionButton();
    }//GEN-LAST:event_connectionButtonActionPerformed

    private void controlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlButtonActionPerformed
        // TODO add your handling code here:
        controlScreen();
    }//GEN-LAST:event_controlButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        scan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            connect();
        } catch (Exception ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ledonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledonActionPerformed
        try {
            hc05.action1();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ledonActionPerformed

    private void ledoff4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledoff4ActionPerformed
        try {
            hc05.action2();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ledoff4ActionPerformed

    public static void main(String args[]) {

        File f = new File("CheckFile");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "App already running");
            return;
        }
        f.deleteOnExit();
        Thread B = new Thread(() -> {
            Configuration config = new Configuration();

            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("src\\Speech Command\\7849.dic");
            config.setLanguageModelPath("src\\Speech Command\\7849.lm");

            try {
                LiveSpeechRecognizer speech = null;
                speech = new LiveSpeechRecognizer(config);

                speech.startRecognition(true);

                SpeechResult speechResult = null;

                while ((speechResult = speech.getResult()) != null) {//http://www.speech.cs.cmu.edu/tools/lmtool-new.html
                    String voiceCommand = speechResult.getHypothesis();
                    System.out.println("Voice Command is " + voiceCommand);
                    Runtime.getRuntime().exec("cmd.exe /c start chrome www.infybuzz.com");

                    if (voiceCommand.equalsIgnoreCase("Lights On")) {
                        HC05.sendDataToBlutooth("1");
                    } else if (voiceCommand.equalsIgnoreCase("Lights Off")) {
                        HC05.sendDataToBlutooth("0");
                    } else if (voiceCommand.equalsIgnoreCase("Connect Firebase")) {
                        Runtime.getRuntime().exec("cmd.exe /c C:\\Users\\new\\Documents\\NetBeansProjects\\FireBaseConnector\\dist\\FireBaseConnector.jar");
                    } else if (voiceCommand.equalsIgnoreCase("Shutdown My Computer")) {
                        Runtime.getRuntime().exec("cmd.exe /c shutdown /s");
                    } else if (voiceCommand.equalsIgnoreCase("Open WhatsApp")) {
                        Runtime.getRuntime().exec("cmd.exe /c C:\\Users\\new\\AppData\\Local\\WhatsApp\\WhatsApp.exe");
                    } else if (voiceCommand.equalsIgnoreCase("Close WhatsApp")) {
                        Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM WhatsApp.exe /F");
                    } else if (voiceCommand.equalsIgnoreCase("Delete CheckFile")) {
                        Runtime.getRuntime().exec("cmd.exe /c del G:\\BootCamp-Projects\\Desktop_Arduino_Bluetooth_connector_Programm\\JavaApplicationGUI\\CheckFile");
                        Runtime.getRuntime().exec("cmd.exe /c del C:\\Users\\new\\Documents\\NetBeansProjects\\FireBaseConnector\\CheckFile");

                    }//
                    else if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
                        Runtime.getRuntime().exec("cmd.exe /c start chrome www.infybuzz.com");
                    } else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
                        Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                    } else if (voiceCommand.equalsIgnoreCase("Open Android Studio")) {
                        Runtime.getRuntime().exec("cmd.exe /c  \"G:\\Android Studio\\bin\\studio64.exe\"");
                    } else if (voiceCommand.equalsIgnoreCase("Close Android Studio")) {
                        Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM studio64.exe /F");
                    } else if (voiceCommand.equalsIgnoreCase("Open Control Panel")) {
                        Runtime.getRuntime().exec("cmd.exe /c control panel");
                    } else if (voiceCommand.equalsIgnoreCase("Open NetBeans")) {
                        Runtime.getRuntime().exec("cmd.exe /c \"C:\\Program Files\\NetBeans 8.1\\bin\\netbeans64.exe\"");
                    } else if (voiceCommand.equalsIgnoreCase("Close NetBeans")) {
                        Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM netbeans64.exe /F");
                    } else if (voiceCommand.equalsIgnoreCase("Open My Computer")) {
                        Runtime.getRuntime().exec("cmd.exe /c start .");
                    }/*else if (voiceCommand.equalsIgnoreCase("Close")) {
                        System.exit(0);
                    } */

                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);

            }

        });
        B.start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainScreen = new MainScreen();
                mainScreen.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AboutScreen;
    private javax.swing.JPanel ConnectionScreen;
    private javax.swing.JPanel ControlScreen;
    private javax.swing.JLayeredPane ParentScreen;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton connectionButton;
    private javax.swing.JButton controlButton;
    private javax.swing.JTable deviceTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ledoff4;
    private javax.swing.JButton ledon;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables

    private void aboutButton() {
        ParentScreen.removeAll();
        ParentScreen.add(AboutScreen);
        ParentScreen.repaint();
        ParentScreen.revalidate();
    }

    private void connectionButton() {
        ParentScreen.removeAll();
        ParentScreen.add(ConnectionScreen);
        ParentScreen.repaint();
        ParentScreen.revalidate();
    }

    private void controlScreen() {
        ParentScreen.removeAll();
        ParentScreen.add(ControlScreen);
        ParentScreen.repaint();
        ParentScreen.revalidate();
    }

    private void scan() {
        startProgressbar();
        try {
            hc05.scan();
            System.out.println("finished scaning");
        } catch (Exception e) {
            System.out.println("could not finish scan " + e.getMessage());
        }
    }

    private void startProgressbar() {
        ScanProgress s = new ScanProgress();
        s.updateVisibility(true, s);
        s.startProgressbar(s);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                // your code here
                showDeviceTable();
            }
        },
                12000
        );

    }

    private void connect() throws Exception {
        int i = deviceTable.getSelectedRow();
        if (i >= 0) {
            String ma = (String) deviceTable.getModel().getValueAt(i, 0);
            hc05.conect(ma);
        }

    }

    private void showDeviceTable() {
        System.out.println("showDeviceTable() got triggered ");
        DefaultTableModel dtm = (DefaultTableModel) deviceTable.getModel();
        for (int k = 0; k < hc05.devices.size(); k++) {
            String[] lv = new String[2];
            lv[0] = hc05.devices.get(k).name;
            lv[1] = hc05.devices.get(k).hc05device.toString();
            dtm.addRow(lv);
        }
    }

}
