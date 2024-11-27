package View;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import javax.swing.JButton;

public class JScrollPane extends javax.swing.JScrollPane{
    public JScrollPane(JComponent component){
        super(component);
        setBackground(null);
        getViewport().setBackground(null);
        setBorder(null);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(null);
        scrollBar.setBorder(null);
        scrollBar.setUI(new BasicScrollBarUI() {
            // To change scrollbar color
            protected void configureScrollBarColors(){
                this.thumbColor = GUIConstants.textAreaHint;
            }
            // To hide the arrows of scroll bar
            protected JButton createDecreaseButton(int orientation){
                return createZeroButton();
            }

            protected JButton createIncreaseButton(int orientation){
                return createZeroButton();
            }

            private JButton createZeroButton(){
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(0,0));
                btn.setMaximumSize(new Dimension(0,0));
                btn.setMinimumSize(new Dimension(0,0));
                return btn;
            }
        });

        setVerticalScrollBar(scrollBar);
        // To hide horizontal scroll bar
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setPreferredSize(new Dimension(5,0));
        getHorizontalScrollBar().setPreferredSize(new Dimension(0,5));

    }
}
