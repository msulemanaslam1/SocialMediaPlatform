package View;

import javax.swing.*;
import java.awt.*;

public class JLabel extends javax.swing.JLabel{
    public JLabel(String text, int textSize, Color color, int style){
        setFont(new Font("Segoe UI", style, textSize));
        setText(text);
        setForeground(color);
    }
    public JLabel(String text) {
        setText(text);
    }

    public JLabel(ImageIcon imageIcon, int width, int height) {
        // Get the original image from the ImageIcon
        Image originalImage = imageIcon.getImage();
        // Scale the image to the desired dimensions
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Set the scaled icon in the JLabel
        setIcon(scaledIcon);
    }
}
