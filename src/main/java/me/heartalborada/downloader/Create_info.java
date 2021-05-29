/*
 * Created by JFormDesigner on Sun May 02 22:00:11 CST 2021
 */

package me.heartalborada.downloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author heartalborada
 */
public class Create_info extends JFrame {
    private Frame frame = new Frame();
    public Create_info() {
        initComponents();
        frame.setAlwaysOnTop(true);
    }

    private void okMouseClicked(MouseEvent e) {
        if(Url_Input.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "请填写正确的Url地址", "错误", JOptionPane.ERROR_MESSAGE);
        } else if(!(!Url_Input.getText().contains("https://")||!Url_Input.getText().contains("http://"))){
            JOptionPane.showMessageDialog(frame, "请在开头加上\"https://\"或者\"http://\"", "错误", JOptionPane.ERROR_MESSAGE);
        } else{
            if(email_Input.getText().equals("")||!email_Input.getText().contains("@")){
                JOptionPane.showMessageDialog(frame, "请填写正确的邮箱地址", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                new Info_File().Out(Url_Input.getText(),email_Input.getText());
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        Url_Input = new JTextArea();
        panel3 = new JPanel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        email_Input = new JTextArea();
        panel1 = new JPanel();
        ok = new JButton();

        //======== this ========
        setFocusable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //---- label1 ----
            label1.setText("Url:");
            panel2.add(label1);

            //======== scrollPane1 ========
            {

                //---- Url_Input ----
                Url_Input.setPreferredSize(new Dimension(700, 18));
                scrollPane1.setViewportView(Url_Input);
            }
            panel2.add(scrollPane1);
        }
        contentPane.add(panel2);
        panel2.setBounds(5, 10, 740, 40);

        //======== panel3 ========
        {
            panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //---- label2 ----
            label2.setText("E-mail:");
            panel3.add(label2);

            //======== scrollPane2 ========
            {

                //---- email_Input ----
                email_Input.setPreferredSize(new Dimension(683, 18));
                scrollPane2.setViewportView(email_Input);
            }
            panel3.add(scrollPane2);
        }
        contentPane.add(panel3);
        panel3.setBounds(5, 55, 740, 40);

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(760, 38));
            panel1.setLayout(new FlowLayout(FlowLayout.TRAILING));
            ((FlowLayout)panel1.getLayout()).setAlignOnBaseline(true);

            //---- ok ----
            ok.setText("OK");
            ok.setPreferredSize(new Dimension(745, 28));
            ok.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    okMouseClicked(e);
                }
            });
            panel1.add(ok);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 95, 755, 50);

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea Url_Input;
    private JPanel panel3;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTextArea email_Input;
    private JPanel panel1;
    private JButton ok;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
