package me.heartalborada.downloader;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download {
    public static void downloadFile(String remoteFilePath, String localFilePath) {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
                bos.write(b, 0, len);
            Frame frame = new Frame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "已下载到本目录", "信息", JOptionPane.INFORMATION_MESSAGE);
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (Exception e) {
            System.err.println("Unknown error,please send \"Crash.log\" to "+Start.email+"!");
            StackTraceElement[] a= e.getStackTrace();
            String Crash_info = null;
            for(int i=0;i<=a.length-1;i++) {
                Crash_info =Crash_info+a[i]+"\n";
            }
            Crash.Write_Crash_log(Crash_info);
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                System.err.println("Unable to connect to the server!\nAnd you can send \"Crash.log\" to "+Start.email+"!");
                StackTraceElement[] a= e.getStackTrace();
                String Crash_info = null;
                for(int i=0;i<=a.length-1;i++) {
                    Crash_info =Crash_info+a[i]+"\n";
                }
                Crash.Write_Crash_log(Crash_info);
            }
        }
    }
}
