package View;

import Controller.ReadAllUsers;
import Model.Database;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CustomView {
    public CustomView(String view, User user, Database database){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(null);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(GUIConstants.white);
        Dimension dimension = new Dimension(500,50);
        header.setPreferredSize(dimension);
        header.setMinimumSize(dimension);
        header.setMaximumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));

        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel(view,20,GUIConstants.black,Font.BOLD),
                BorderLayout.WEST);
        JLabel home = new JLabel(new ImageIcon("pics/home.png"),40,40);
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Home(user,database);
                frame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);

        panel.add(header);
        switch (view){
            case "Friends":
                ArrayList<User> users = new ReadAllUsers(database,user).getList();
                for (User u: users){
                    panel.add(Box.createVerticalStrut(7));
                    panel.add(new Friend(user,database,u));
                }
                break;
        }
//        for (int i = 0; i < 10; i++) {
//            panel.add(Box.createVerticalStrut(7));
//            panel.add(new Friend());
//            if (i%2==0){
//                panel.add(new Post());
//            } else {
//                panel.add(new Comment());
//            }
//        }

        frame.getContentPane().add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();
    }
}
