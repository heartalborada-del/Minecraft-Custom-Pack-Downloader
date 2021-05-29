package me.heartalborada.downloader;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.getProperty;

public class Start {
    public static String url="";
    public static String email="";
    public static void main(String[] args){
        String create_info = getProperty("Create_Info","");
        if (create_info.equals("Yes")) {
            System.out.println("Loading create info Gui,please be wait!");
            new Create_info().setVisible(true);
        } else {
            String[] file=Info_File.read();
            if(file!=null){
                url=file[0];
                email=file[1];
                System.out.println("Gui is loading,please be wait!");
                if (new Internet().Ping(url)) {
                    String[] File_list = getProperty("user.dir").replace("\\", "/").split("/");
                    if (File_list[File_list.length - 1] != "resourcepacks" || File_list.length == 1) {
                        Frame frame = new Frame();
                        frame.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(frame, "建议放在minecraft游戏目录下的resourcepacks文件夹", "信息", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("建议放在minecraft游戏目录下的resourcepacks文件夹");
                    }
                    new Gui().setVisible(true);
                    System.out.println("The window is open!");
                    Gui.add_List(GetHttp.GetList(url));
                } else {
                    Frame frame = new Frame();
                    frame.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(frame, "网络链接失败!", "错误!", JOptionPane.ERROR_MESSAGE);
                    System.err.println("You are offline!");
                    System.out.println("The program exited!");
                    System.exit(0);
                }
            }
            else if(file==null){
                System.err.println("No Url or email,please tell your server admin!");
            }
            System.out.println(url+"\n"+email);
        }
    }
}
