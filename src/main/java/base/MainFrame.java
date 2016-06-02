package base;

/**
 * Created by Администратор on 01.06.2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.oracle.jrockit.jfr.ContentType.Address;

public class MainFrame {

    Connect c = new Connect();
    Connection conn = null;
    JFrame frame,connectedFrame;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton button;
    JLabel label1;
    JLabel label2;
    JTextField text1;
    JTextField text2;
    int connectedPreor=-1;
    public  void init() {

        frame = new JFrame("LogIN");
        frame.setLayout(null);
        frame.setSize(250,400);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        button = new JButton("Connect");



        button.setSize(100,40);
        button.setLocation(75,280);
        frame.add(button);

        label1 = new JLabel("Логин");
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setSize(100,30);
        label1.setLocation(100,50);

        label2 = new JLabel("Пароль");
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setSize(100,30);
        label2.setLocation(100,150);

        text1= new JTextField();
        text1.setSize(150,30);
        text1.setLocation(52,75);

        text2= new JTextField();
        text2.setSize(150,30);
        text2.setLocation(52,175);

        frame.add(label1);
        frame.add(label2);
        frame.add(text1);
        frame.add(text2);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                connectedPreor=connect();
                if (connectedPreor!=-1)
                {
                    frame.setVisible(false);
                    conedFrameInit();
                }
            }
        });
    }
    public void conedFrameInit(){

        connectedFrame = new JFrame("DataBase");
        connectedFrame.setLayout(null);
        connectedFrame.setSize(640,480);
        connectedFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Таблицы", panel1);
        tabbedPane.addTab("Палаты", panel2);
        tabbedPane.addTab("Диаграммы распределения", panel3);
        tabbedPane.setSize(640,480);

        connectedFrame.add(tabbedPane);
        connectedFrame.setLocation(200, 200);
        connectedFrame.setVisible(true);
    };
    public void run()
    {
        init();
    }
    public int connect()
    {
     boolean isConnected=false;

       conn=c.Connect(conn);
       String s= "select preor from users where log = ";
        s+="'";
        if (text1.getText().length()==0) text1.setText("PlsEnterLogin");
        s+=text1.getText();
        s+="' and pas = '";
        if (text2.getText().length()==0) text2.setText("PlsEnterPassword");
        s+=text2.getText();
        s+="'";


        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs =  st.executeQuery(s);

            if (rs.next()) {
                connectedPreor=rs.getInt(1);
                System.out.println("CONNECTED");
                System.out.println(connectedPreor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connectedPreor;
    }
}