
package client.login;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.border.Border; 
import javax.swing.BorderFactory;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Chat;
import javax.swing.JFrame;

/**
 *
 * @author Academia
 */
public class Login extends javax.swing.JFrame {
    DefaultTableModel model = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ccw?autoReconnect=true&useSSL=false";
    String user = "root";
    String pass = "";
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    int islogin;
    String loginuser;
    String password;
    String registerlogin;
    /**
     * Creates new form Login
     */
    public Login() {
        super("Chatty");
        setIconImage(Chat.LOGO);
        
        initComponents();
//        centramos el form
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
//        setLogin(registerlogin);
//        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/login.png"));
//setIcon(new ImageIcon(img.getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH)));
//        setIconImage(img);

//        creamos un borde amarillo para el titulo del panel
//         con el 0, en la parte superior del titulo del panel no ponemos borde
        Border jpanel_titulo_borde = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.YELLOW);
//        fijamos el borde al jpanel del título
       jPanel_titulo.setBorder(jpanel_titulo_borde);
//        Creamos un borde para las casillas de minimizar y cerrar
        Border jlabel_borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimizar.setBorder(jlabel_borde);
        jLabel_cerrar.setBorder(jlabel_borde);
        txtPassword.setTransferHandler(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_minimizar = new javax.swing.JLabel();
        jLabel_cerrar = new javax.swing.JLabel();
        jPanel_titulo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel_user = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        login = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel_minimizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_minimizar.setText("-");
        jLabel_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizarMouseExited(evt);
            }
        });

        jLabel_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_cerrar.setText("x");
        jLabel_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_cerrarMouseExited(evt);
            }
        });

        jPanel_titulo.setBackground(new java.awt.Color(0, 240, 0));
        jPanel_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_tituloMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_tituloLayout = new javax.swing.GroupLayout(jPanel_titulo);
        jPanel_titulo.setLayout(jPanel_tituloLayout);
        jPanel_tituloLayout.setHorizontalGroup(
            jPanel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tituloLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(86, 86, 86))
        );
        jPanel_tituloLayout.setVerticalGroup(
            jPanel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );

        jLabel_user.setIcon(new ImageIcon("img/password.png"));

        jLabel_password.setIcon(new ImageIcon("img/user.png"));

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(153, 153, 153));
        txtUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUser.setText("Username");
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setToolTipText("password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        login.setBackground(new java.awt.Color(0, 84, 140));
        login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        login.setText("Login");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText(">> ¿No tienes cuenta?  Crea una aquí!");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMaximumSize(new java.awt.Dimension(236, 17));
        jButton1.setMinimumSize(new java.awt.Dimension(236, 17));
        jButton1.setPreferredSize(new java.awt.Dimension(236, 17));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_password, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_password, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtPassword.getAccessibleContext().setAccessibleName("password");

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(jPanel_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jLabel_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_minimizar)
                        .addComponent(jLabel_cerrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizarMouseEntered
        Border jlabel_borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimizar.setBorder(jlabel_borde);
        jLabel_minimizar.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_minimizarMouseEntered

    private void jLabel_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizarMouseExited
        Border jlabel_borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimizar.setBorder(jlabel_borde);
        jLabel_minimizar.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_minimizarMouseExited

    private void jLabel_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_cerrarMouseExited
        // TODO add your handling code here:
        Border jlabel_borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_cerrar.setBorder(jlabel_borde);
        jLabel_cerrar.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_cerrarMouseExited

    private void jLabel_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_cerrarMouseEntered
         Border jlabel_borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_cerrar.setBorder(jlabel_borde);
        jLabel_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_cerrarMouseEntered

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        if(txtUser.getText().trim().toLowerCase().equals("username"))
        {
            txtUser.setText("");
            txtUser.setForeground(Color.black);
            //poner un borde amarillo al jlabel 
            Border jlabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW);
       jLabel_user.setBorder(jlabel_icon);
        }
        
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
    if(txtUser.getText().equals(""))
        {
            txtUser.setText("Username");
            txtUser.setForeground(Color.gray);
            //poner un borde amarillo al jlabel 
            Border jlabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW);
       jLabel_user.setBorder(jlabel_icon);
        }
    }//GEN-LAST:event_txtUserFocusLost

    private void jLabel_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_cerrarMouseClicked
       
        System.exit(0);
    }//GEN-LAST:event_jLabel_cerrarMouseClicked

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
  if(evt.getKeyCode()== KeyEvent.VK_ENTER){
    verifyLogin();  
  }// TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
    verifyLogin(); 
}
    }//GEN-LAST:event_txtUserKeyPressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    verifyLogin();     
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel_tituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tituloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_tituloMouseClicked

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
                if(txtPassword.getText().equals("Username"))
        {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
            //poner un borde amarillo al jlabel 
            Border jlabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW);
       jLabel_user.setBorder(jlabel_icon);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if(txtPassword.getText().equals(""))
        {
            txtPassword.setText("Username");
            txtPassword.setForeground(Color.gray);
            //poner un borde amarillo al jlabel 
            Border jlabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW);
       jLabel_user.setBorder(jlabel_icon);
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Register openRegister = new Register();
//       openRegister.setLocationRelativeTo(null);
       openRegister.setVisible(true);
       setVisible(false);
       openRegister.pack();
        openRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        verifyLogin();        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        // TODO add your handling code here:
        login.setBackground(new Color(0,101,183));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        // TODO add your handling code here:
        login.setBackground(new Color(0,84,104));
    }//GEN-LAST:event_loginMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
         Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
      jButton1.setBorder(label_border);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
         Border label_create_accont_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray);
        jButton1.setBorder(label_create_accont_border);
    }//GEN-LAST:event_jButton1MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
public void verifyLogin(){
        loginuser = txtUser.getText().toLowerCase();
        password = String.valueOf(txtPassword.getPassword());
         if(loginuser.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Username", "Empty Username", 2);
        }
        else if(password.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Password", "Empty Password", 2);
        } else{
            try {
                Class.forName(driver);
                try {
                    conn = DriverManager.getConnection(url, user, pass);
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM usuario WHERE nombre_usuario='" + loginuser + "'"
                            + "and contrasenya='" + password + "'");
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Acceso autorizado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor comprueba las credenciales");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No vaAAAAAAAAA2");
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No va");
            }
        }

    }
    public void setLogin(String registerlogin){
        if(!registerlogin.isEmpty()){
        txtUser.setText(registerlogin);
    }}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_cerrar;
    private javax.swing.JLabel jLabel_minimizar;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_titulo;
    private javax.swing.JToggleButton login;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}