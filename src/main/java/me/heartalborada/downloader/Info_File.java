package me.heartalborada.downloader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Info_File {
    public static void Out(String url, String email){
        FileOutputStream fileoutputstream;
        File file=new File(System.getProperty("user.dir") + "/Config.cfg");
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String url_base64;
        String email_base64;
        System.out.println(new String(decoder.decode(encoder.encodeToString(url.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        url_base64 = encoder.encodeToString(url.getBytes(StandardCharsets.UTF_8));
        email_base64=encoder.encodeToString(email.getBytes(StandardCharsets.UTF_8));
        try{
            if(file.exists()){
                file.createNewFile();
            }
            fileoutputstream=new FileOutputStream(file);
            fileoutputstream.write((url_base64+"\n"+email_base64).getBytes());
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        catch (Exception e){ }
        System.out.println("The program exited!");
        System.exit(0);
    }
    public static String[] read(){
        String[] info =null;
        File file=new File(System.getProperty("user.dir") + "/Config.cfg");
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String tmp;
            String tmp1=null;
            while ((tmp=reader.readLine())!=null)
            {
                tmp1=tmp1+tmp+"\n";
            }
            reader.close();
            info=tmp1.split("\n");
            for(int i=0;i<=info.length-1;i++)
            {
                info[i]= new String(decoder.decode(info[i]), StandardCharsets.UTF_8);
            }

            info[0]=info[0].substring(3);
        }catch (IOException e) { }
        return info;
    }
}
