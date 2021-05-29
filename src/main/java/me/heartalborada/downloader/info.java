/*
 * Created by JFormDesigner on Fri Apr 30 19:49:08 CST 2021
 */

package me.heartalborada.downloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author heartalborada
 */
public class info extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton close;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    public static JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public info() {
        initComponents();
        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void thisWindowOpened(WindowEvent e) {
        String[] arr = GetHttp.GetInfo(Start.url);
        String Info = "";
        for (int i = 0; i <= arr.length - 1; i++) {
            Info = Info + arr[i] + "\n";
        }
        textArea1.setText(Info);
    }

    private void closeMouseClicked(MouseEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        close = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Pack info");
        setMinimumSize(null);
        setAutoRequestFocus(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- close ----
            close.setText("Close");
            close.setPreferredSize(new Dimension(800, 23));
            close.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    closeMouseClicked(e);
                }
            });
            panel1.add(close);
        }
        contentPane.add(panel1);
        panel1.setBounds(new Rectangle(new Point(9, 262), panel1.getPreferredSize()));

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setPreferredSize(new Dimension(800, 250));
                scrollPane1.setViewportView(textArea1);
            }
            panel2.add(scrollPane1);
        }
        contentPane.add(panel2);
        panel2.setBounds(10, 10, 800, 250);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
