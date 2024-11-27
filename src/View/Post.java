package View;

import Controller.LikePost;
import Model.Database;
import Model.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Post extends JPanel {
    public Post(User u, Database database, Model.Post post){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(null);

        JLabel author = new JLabel(post.getUser().getFirstName()+" "+post.getUser().getLastName(),20,GUIConstants.post,Font.BOLD);
        header.add(author,BorderLayout.WEST);

        JLabel date = new JLabel(post.getDateToString(),15,GUIConstants.post,Font.BOLD);
        header.add(date,BorderLayout.EAST);

        add(header);
        add(Box.createVerticalStrut(7));

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
        center.setBackground(null);
        JTextArea content = new JTextArea(post.getContent(),
                18, GUIConstants.post,Font.PLAIN);
        center.add(content);
        add(center);
        add(Box.createVerticalStrut(7));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(null);

        JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT,13,13));
        likes.setBackground(null);

        JLabel like = new JLabel(new ImageIcon("pics/like.png"),30,30);
        like.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (new LikePost(u,post,database).isLiked()){
                    ImageIcon originalIcon = new ImageIcon("pics/liked.png");
                    Image resizedImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                    like.setIcon(new ImageIcon(resizedImage));
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
        likes.add(like);
        likes.add(new JLabel("0 Likes",15,GUIConstants.textFieldHint,Font.BOLD));

        bottom.add(likes,BorderLayout.WEST);
        JLabel comments = new JLabel("0 Comments", 15,GUIConstants.textFieldHint,Font.BOLD);
        bottom.add(comments,BorderLayout.EAST);
        add(bottom);

        int height = (int) (115+content.getPreferredSize().getHeight());

        Dimension dimension = new Dimension(500, height);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
    }

    public Post() {
    }
}
