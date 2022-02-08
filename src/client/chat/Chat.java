/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package client.chat;

/**
 *
 * @author Javier Palacios Botejara
 */
import packager.Package;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Chat extends JFrame implements ActionListener, KeyListener{
        
    Container content = getContentPane();
    Container sideBar = getContentPane();
        
    JPanel users = new JPanel();
    JPanel win = new JPanel();
    JPanel input = new JPanel();
    JPanel text = new JPanel();
    JFrame frame = new JFrame();
         
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    ImageIcon send = new ImageIcon("send.png");
    ImageIcon erase = new ImageIcon("erase.png");
    ImageIcon exit = new ImageIcon("exit.png");        
        
    JButton sendbtn = new JButton("Send", send);
    JButton exitbtn = new JButton("Exit", exit);
    JButton erasebtn = new JButton("Clean", erase);
        
    JTextField field = new JTextField(38);
    JTextArea txtArea = new JTextArea(40,115);
    
    JScrollPane userPane = new JScrollPane();
    JPanel allusers = new JPanel();

    String serverIP;
    JList userOnline;
    DefaultListModel model = new DefaultListModel();;
     
    public Chat() {
        super("Chatty");               
        
    // SHITTY SWING COMPONENTS WITH NO STYLE WHATSOEVER ========================
            txtArea.setEditable(false);
            text.add(txtArea); 
            
            input.add(sendbtn);
            input.add(exitbtn);
            input.add(erasebtn);
            input.add(field);
                    
            allusers.setLayout(new BorderLayout(10,10));
            
            userOnline = new JList<String>();
            userOnline.setModel(model);
            userPane = new JScrollPane(userOnline);
            users.add(userPane);            

            content.add("Center", text);
            content.add("South", input);
            content.add("East", users);
                    
            //LISTENERS ____________________________________________________
            sendbtn.addActionListener(this);
            exitbtn.addActionListener(this);
            erasebtn.addActionListener(this);
                    
            field.addKeyListener(this);
            
            //FRAME _________________________________________________________
            setSize(screenSize.width, screenSize.height-60);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
        //=====================================================================
            
            getServerIP();
//        serverIP = (String) JOptionPane.showInputDialog(this, "Introduce ip del servidor");
            new RecieveMsg();
    }  
    
    private void getServerIP() {
        txtArea.append("Starting connection...");
        for(int i = 0; i<=255; i++){
            try {
                try (Socket socket = new Socket("192.168.1."+i,9999)) {
                    Package p = new Package();
                    p.setStatus("online");
                    
                    ObjectOutputStream objp = new ObjectOutputStream(socket.getOutputStream());
                    objp.writeObject(p);
                    socket.close();
                }
                
            } catch (IOException ex) {System.out.println("Server tested: 192.168.1."+i);}
        }
        txtArea.append("Waiting response....");
    }
        
//    public void serverConnect(){
//        try {
//            Socket mySocket = new Socket(serverIP,9999);
//            Package p = new Package();
//            p.setStatus("online");
//            
//            ObjectOutputStream objp = new ObjectOutputStream(mySocket.getOutputStream());
//            objp.writeObject(p);
//            mySocket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void sendMsg() {
            
            try {
                try (Socket socket = new Socket(serverIP,9999)) {
                    Package p = new Package();
                    p.setNick("");
                    try{p.setIp(userOnline.getSelectedValue().toString());}catch(Exception e){} //***
                    p.setMove("");
                    p.setStatus("messaging");
                    p.setMsg(field.getText());
                    
                    ObjectOutputStream objp = new ObjectOutputStream(socket.getOutputStream());
                    objp.writeObject(p);
                    socket.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
    class RecieveMsg implements Runnable{
       
        RecieveMsg(){
            Thread lintening = new Thread(this);
            lintening.start();
        }
        
        @Override
        public void run() {
            try {
                ServerSocket port = new ServerSocket(9090);
                String nick, ip, move, msg;
                Package p;

                while(true){
                    try (Socket mysocket = port.accept()) {
                        ObjectInputStream entrada = new ObjectInputStream(mysocket.getInputStream());
                        p = (Package) entrada.readObject();
                        
                        txtArea.append("Server response: "+ p.getStatus());
                        
                        if(p.getStatus().equals("imserver")){setServerIP(mysocket, p);}
                        if(p.getStatus().equals("messaging")){sendMessage(p);} 
                        
                    } catch(Exception e){}                    
                }
            } catch (Exception e){}
        }      
        
        private void setServerIP(Socket mysocket, Package p) {
            txtArea.append("server response: "+p.getStatus());
            
            InetAddress locateip = mysocket.getInetAddress();
            serverIP = locateip.getHostAddress();            
            
            for(String user : p.getIps()){
                boolean own = GetIP.getPublicIP().contains(user) || GetIP.getLocalIp().contains(user);
                if(!model.contains(user) && !own){model.addElement(user);}
            }
        }

        private void sendMessage(Package p){
            txtArea.append(p.getMsg()+"\n");

        }      
    }
    

        
// ======================================================================
// MAIN
// ======================================================================
  /**
    * @param args the command line arguments
    */
    public static void main(String[] args){
	new Chat();
    }
        
// ======================================================================
// EVENTS
// ======================================================================
    public void actionPerformed(ActionEvent event) {
        try {                
            if(event.getSource() == sendbtn){
                sendMsg();
                
                txtArea.append(field.getText() + "\n");
                field.setText("");
            } else if (event.getSource() == erasebtn){
                txtArea.setText("");
            }else if (event.getSource() == exitbtn){
                System.exit(0);
            }
        } catch (Exception e){e.printStackTrace();}
    }
    
    public void keyPressed(KeyEvent pressed) {
         try {
            if(pressed.getKeyCode() == KeyEvent.VK_ENTER){
                sendMsg();
                
                txtArea.append(field.getText() + "\n");
                field.setText("");
            }  
        } catch (Exception e){e.printStackTrace();}
    }
    
    public void keyTyped (KeyEvent typing){}
    public void keyReleased(KeyEvent released){}
}