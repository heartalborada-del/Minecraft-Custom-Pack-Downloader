/*
 * Created by JFormDesigner on Fri Apr 30 18:37:04 CST 2021
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
public class Gui extends JFrame {
    public Gui() {
        initComponents();
        setAlwaysOnTop(true);
        setResizable(false);
    }

    private void Downloader_ButtonMouseClicked(MouseEvent e) {
        String File_name= String.valueOf(File_List.getSelectedValue());
        if(File_name=="null")
        {
            Frame frame=new Frame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame,"你还未选择要下载的文件!","错误!", JOptionPane.ERROR_MESSAGE);
        } else {
            Download.downloadFile(Start.url+File_name,System.getProperty("user.dir") + "/" +File_name);
        }
    }

    private void infoMouseClicked(MouseEvent e) {
        this.setEnabled(false);
        JFrame This=this;
        JFrame window=new info();
        window.setVisible(true);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                This.setEnabled(true);
            }
        });
    }


    private void thisWindowClosing(WindowEvent e) {
        System.out.println("The program is exit!");
        System.exit(0);
    }

    private void thisWindowOpened(WindowEvent e) {

        DefaultListModel list = new DefaultListModel();
        String[] arr = GetHttp.GetList(Start.url);
        for(int i=0;i<= arr.length-1;i++){
            list.addElement(arr[i]);
        }
        File_List.setModel(list);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        File_List = new JList();
        panel2 = new JPanel();
        Downloader_Button = new JButton();
        info = new JButton();

        //======== this ========
        setTitle("Custom Pack Downloader");
        setFocusableWindowState(false);
        setFocusable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- File_List ----
            File_List.setFixedCellWidth(300);
            scrollPane1.setViewportView(File_List);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(30, 0), scrollPane1.getPreferredSize()));

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());
            ((FlowLayout)panel2.getLayout()).setAlignOnBaseline(true);

            //---- Downloader_Button ----
            Downloader_Button.setText("Download!");
            Downloader_Button.setHorizontalTextPosition(SwingConstants.CENTER);
            Downloader_Button.setHideActionText(true);
            Downloader_Button.setDoubleBuffered(true);
            Downloader_Button.setFocusable(false);
            Downloader_Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Downloader_ButtonMouseClicked(e);
                }
            });
            panel2.add(Downloader_Button);

            //---- info ----
            info.setText("Pack info");
            info.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    infoMouseClicked(e);
                }
            });
            panel2.add(info);
        }
        contentPane.add(panel2);
        panel2.setBounds(5, 140, 360, 35);

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
    private JScrollPane scrollPane1;
    public static JList File_List;
    private JPanel panel2;
    private JButton Downloader_Button;
    private JButton info;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void add_List(String[] arr) {
        DefaultListModel list = new DefaultListModel();
        for(int i=0;i<= arr.length-1;i++){
            list.addElement(arr[i]);
        }
        File_List.setModel(list);
    }

}
