package me.heartalborada.downloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {
    public static boolean Ping(String internet_url) {
        {
            HttpURLConnection conn;
            try {
                URL url = new URL(internet_url);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(60000);
                conn.setRequestProperty("Accept", "application/json");
                conn.connect();
                int Code=conn.getResponseCode();
                if (Code!=404) {
                    return true;
                }
            } catch (IOException ignored) { }
            return false;
        }
    }
}
