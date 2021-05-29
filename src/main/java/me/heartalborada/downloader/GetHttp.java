package me.heartalborada.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetHttp {
    public static String[] GetList(String url) {
        Get_File http = new Get_File();
        String[] text_data = http.doGet(url+"/list.txt").split(";");
        return text_data;
    }

    public static String[] GetInfo(String url) {
        Get_File http = new Get_File();
        String[] text_data = http.doGet(url+"/update_log.txt").split(";");
        return text_data;
    }

    public static class Get_File {
        public String doGet(String URL) {
            HttpURLConnection conn = null;
            InputStream is = null;
            BufferedReader br = null;
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL(URL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(60000);
                conn.setRequestProperty("Accept", "application/json");
                conn.connect();
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line;
                if (200 == conn.getResponseCode() && (line = br.readLine()) != null) {
                    result.append(line);
                    return line;
                }
            } catch (MalformedURLException e) {
                System.err.println("No URL specified!\nAnd you can send \"Crash.log\" to "+Start.email+"!");
                StackTraceElement[] a= e.getStackTrace();
                String Crash_info = null;
                for(int i=0;i<=a.length-1;i++) {
                    Crash_info =Crash_info+a[i]+"\n";
                }
                Crash.Write_Crash_log(Crash_info);
            } catch (IOException e) {
                System.err.println("Unable to connect to the server!\nAnd you can send \"Crash.log\" to "+Start.email+"!");
                StackTraceElement[] a= e.getStackTrace();
                String Crash_info = null;
                for(int i=0;i<=a.length-1;i++) {
                    Crash_info =Crash_info+a[i]+"\n";
                }
                Crash.Write_Crash_log(Crash_info);
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
                    if (br != null)
                        br.close();
                    if (is != null)
                        is.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                conn.disconnect();
            }
            return result.toString();
        }
    }
}
