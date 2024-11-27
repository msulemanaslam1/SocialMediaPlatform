package View;

import Controller.CreateUser;
import Controller.UpdateUser;
import Model.Database;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Modify {
    public Modify(User user, Database database){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(72,84,149, 84));
        panel.add(new JLabel("Modify your Profile",45,GUIConstants.blue,Font.BOLD),
                BorderLayout.NORTH);

        JPanel center = new JPanel((new GridLayout(4,1,10,10)));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(50,231,17,231));

        JTextField firstName = new JTextField("First Name");
        firstName.setText(user.getFirstName());
        firstName.setForeground(GUIConstants.black);
        center.add(firstName);
        JTextField lastName = new JTextField("Last Name");
        lastName.setText(user.getLastName());
        lastName.setForeground(GUIConstants.black);
        center.add(lastName);
        JTextField email = new JTextField("Email");
        email.setText(user.getEmail());
        email.setForeground(GUIConstants.black);
        center.add(email);
        JButton submit = new JButton("Submit",45,20);
        submit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (firstName.isEmpty()){
                    new Alert("First name cannot be Empty!", frame);
                    return;
                }
                if (lastName.isEmpty()){
                    new Alert("Last name cannot be Empty!", frame);
                    return;
                }
                if (email.isEmpty()){
                    new Alert("Email cannot be Empty!", frame);
                    return;
                }

                User updatedUser = user;
                updatedUser.setFirstName(firstName.getText());
                updatedUser.setLastName(lastName.getText());
                updatedUser.setEmail(email.getText());
                UpdateUser updateUser = new UpdateUser(updatedUser, database);
                if (!email.getText().equals(user.getEmail()) && updateUser.isEmailUsed()){
                    new Alert("This email has been used before!",frame);
                    return;
                }
                if(updateUser.update()){
                    new Home(updatedUser,database);
                    new Alert("Profile Updated successfully!",frame);
                    frame.dispose();
                } else {
                    new Home(user,database);
                }
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
        center.add(submit);
        panel.add(center,BorderLayout.CENTER);

        JLabel changePassword = new JLabel("Change Password",20,
                GUIConstants.black,Font.BOLD);
        changePassword.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChangePassword(user,database);
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
        changePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePassword.setHorizontalAlignment(JLabel.CENTER);
        panel.add(changePassword,BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.requestFocus();
    }
}
