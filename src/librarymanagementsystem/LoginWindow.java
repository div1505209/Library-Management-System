package librarymanagementsystem;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.math.BigInteger; // password to md5
import java.security.MessageDigest; // password to md5
import java.security.NoSuchAlgorithmException; // password to md5
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class LoginWindow extends javax.swing.JFrame {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static String logged_in_admin;

    JFileChooser fr = new JFileChooser();
    FileSystemView fw = fr.getFileSystemView();
    Base64Converter base64 = new Base64Converter();
    ConfigWindow config_window;

    public LoginWindow() {
        initComponents();
        set_image();

        Image icon16 = new ImageIcon(getClass().getResource("img/ico/sksc_logo16.png")).getImage();
        Image icon24 = new ImageIcon(getClass().getResource("img/ico/sksc_logo24.png")).getImage();
        Image icon28 = new ImageIcon(getClass().getResource("img/ico/sksc_logo28.png")).getImage();
        Image icon30 = new ImageIcon(getClass().getResource("img/ico/sksc_logo30.png")).getImage();
        Image icon32 = new ImageIcon(getClass().getResource("img/ico/sksc_logo32.png")).getImage();
        Image icon64 = new ImageIcon(getClass().getResource("img/ico/sksc_logo64.png")).getImage();
        Image icon128 = new ImageIcon(getClass().getResource("img/ico/sksc_logo128.png")).getImage();

        List<Image> icons = new ArrayList<Image>();
        icons.add(icon16);
        icons.add(icon24);
        icons.add(icon28);
        icons.add(icon30);
        icons.add(icon32);
        icons.add(icon64);
        icons.add(icon128);

        this.setIconImages(icons);

        //this belowe code working if config file in user documents not exists.
        File file = new File("config.dat");
        File file_in_library_ms_dir = new File(fw.getDefaultDirectory() + "\\Library\\config.dat");
        File library_ms_dir = new File(fw.getDefaultDirectory() + "\\Library");
        if (!library_ms_dir.exists() | !file_in_library_ms_dir.exists()) {
            try {
                library_ms_dir.mkdir();
            } catch (SecurityException ex) {
                JOptionPane.showMessageDialog(null, "Cannot create a folder in your document, because of security of your system");
            }
            
            try {
                
                FileOutputStream writeStream = new FileOutputStream(file, false); // true to append
                PrintWriter pw = new PrintWriter(writeStream);
                pw.println("");
                pw.println("divyansh");
                pw.println("dvd@1234");
                pw.println("db4free.net:3306");
                pw.println("sp_library_ms");
                pw.flush();
                pw.close();

                base64.encode_to_base64(); //convert temporary file to Base64
                file.delete(); //delete temporary created file
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error writting to config file!");
            }
        }
        
        view_config_window();
    }

    public void set_image() {
        Icon bgImage = new ImageIcon(getClass().getResource("img/sksc_library_ms_login.png"));
        jLabel3.setIcon(bgImage);

        Icon closeNormal = new ImageIcon(getClass().getResource("img/closeNormal.png"));
        Icon closeHover = new ImageIcon(getClass().getResource("img/closeHover.png"));
        Icon closeClicked = new ImageIcon(getClass().getResource("img/closeClicked.png"));
        close_btn.setIcon(closeNormal);
        close_btn.setRolloverIcon(closeHover);
        close_btn.setPressedIcon(closeClicked);

        Icon minNormal = new ImageIcon(getClass().getResource("img/minNormal.png"));
        Icon minHover = new ImageIcon(getClass().getResource("img/minHover.png"));
        Icon minClicked = new ImageIcon(getClass().getResource("img/minClicked.png"));
        min_btn.setIcon(minNormal);
        min_btn.setRolloverIcon(minHover);
        min_btn.setPressedIcon(minClicked);

        Icon settingsNormal = new ImageIcon(getClass().getResource("img/settingsNormal.png"));
        Icon settingsHover = new ImageIcon(getClass().getResource("img/settingsHover.png"));
        Icon settingsClicked = new ImageIcon(getClass().getResource("img/settingsClicked.png"));
        config_btn.setIcon(settingsNormal);
        config_btn.setRolloverIcon(settingsHover);
        config_btn.setPressedIcon(settingsClicked);

    }
    
    public void view_config_window(){
        config_window =  new ConfigWindow();
    }

    public static String md5(String input) {

        String md5 = null;

        if (null == input) {
            return null;
        }

        try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return md5;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);

            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        username_txt = new javax.swing.JTextField();
        login_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();
        password_txt = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        min_btn = new javax.swing.JButton();
        config_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(0, 0, 300, 300));
        setName("login_window"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(300, 300));

        username_txt.setName("username_txt"); // NOI18N
        username_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                username_txtKeyTyped(evt);
            }
        });

        login_btn.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        login_btn.setText("LOGIN");
        login_btn.setName("login_btn"); // NOI18N
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        close_btn.setFocusable(false);
        close_btn.setName("close_btn"); // NOI18N
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        min_btn.setFocusable(false);
        min_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                min_btnActionPerformed(evt);
            }
        });

        config_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                config_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(login_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_txt))
                        .addContainerGap(109, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(config_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(min_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(config_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_close_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed

        String username_db = "", password_db = "";

        String line, mysql_uname = "divyansh", mysql_pass = "dvd@1234", mysql_server = "db4free.net:3306", mysql_db = "sp_library_ms";

        try {
            base64.decode_from_base64();
            File temp_config = new File(fw.getDefaultDirectory() + "\\Library\\config_temp.dat");
            FileReader fr = new FileReader(temp_config);

            BufferedReader br = null;
            if (temp_config.exists()) {
                br = new BufferedReader(fr);
            }

            while ((line = br.readLine()) != null) {
                mysql_uname = br.readLine();
                mysql_pass = br.readLine();
                mysql_server = br.readLine();
                mysql_db = br.readLine();
            }
            //fetching details from the config file
            fr.close();
            br.close();
            temp_config.delete();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading the config file!");
        }

        try {
            String url = "jdbc:mysql://" + mysql_server + "/" + mysql_db;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, mysql_uname, mysql_pass);
            stmt = con.createStatement();

            ResultSet rs_login = stmt.executeQuery("SELECT username,password FROM admins WHERE username='" + username_txt.getText().trim() + "'");
            logged_in_admin = username_txt.getText().trim();
            while (rs_login.next()) {
                username_db = rs_login.getString(1);
                password_db = rs_login.getString(2);
            }

            stmt.close();
            rs_login.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Connection Error! \nMake sure you entered correct credentials in settings and\n '" + mysql_db + "' database exists on your local machine. ");

        }

        if (!username_txt.getText().trim().equals("") && username_txt.getText().trim().equals(username_db)) {

            String x = md5(String.valueOf(password_txt.getPassword()));
            if (!password_txt.getText().equals("") && x.equals(password_db)) {
                this.dispose();
                LibrarySystem s = new LibrarySystem();
                s.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Username/Password is incorrect!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username/Password is incorrect!");
        }


    }//GEN-LAST:event_login_btnActionPerformed

    private void min_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_min_btnActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_min_btnActionPerformed

    
    private void config_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_config_btnActionPerformed
        
            config_window.setVisible(true);
        
        
    }//GEN-LAST:event_config_btnActionPerformed

    private void username_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_txtKeyTyped
        char vchar = evt.getKeyChar();
        if (vchar == KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_username_txtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close_btn;
    public static javax.swing.JButton config_btn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JButton min_btn;
    private javax.swing.JPasswordField password_txt;
    private static javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
