package me.heartalborada.downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Internet {
    public static boolean Ping(String internet_url) {
        URL url = null;
        try {
            url = new URL(internet_url);
            InputStream in = url.openStream();
            in.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
