package me.heartalborada.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crash {
    public static void Write_Crash_log(String Crash_info){
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="["+formatter.format(date)+"]";
        FileOutputStream fileoutputstream=null;
        File file=new File(System.getProperty("user.dir") + "/Crash.log");
        try{
            if(file.exists()){
                file.createNewFile();
            }
            fileoutputstream=new FileOutputStream(file);
            fileoutputstream.write((time+"\n"+Crash_info).getBytes());
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        catch (Exception e){ }
        System.out.println("The program exited!");
        System.exit(0);
    }
}
