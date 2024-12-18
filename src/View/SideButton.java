package View;

import Model.Database;
import Model.User;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideButton extends JPanel {
    public SideButton(String text, String pic, User user, Database database,JFrame f){
        super(new FlowLayout(FlowLayout.LEFT));
        setMaximumSize(new Dimension(182,50));
        setBackground(GUIConstants.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel img = new JLabel(new ImageIcon("pics/"+pic+".png"),25,25);
        add(img);

        add(new JLabel(text,17,GUIConstants.textAreaHint,Font.BOLD));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CustomView(text,user,database);
                f.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(GUIConstants.hover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(GUIConstants.white);
            }
        });
    }
}
