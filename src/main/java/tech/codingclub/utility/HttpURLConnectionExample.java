package tech.codingclub.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.Buffer;
import java.net.URL;

public class HttpURLConnectionExample {
    private final String USER_AGENT = "Brave/1.73.105";
    public static String sendGet(String urlStr) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine()) != null) {
            result.append(line);
        }
        br.close();
        return result.toString();
    }

    public static void main(String[] args) {
        try{
            System.out.println(sendGet("https://codingclub.tech/test-get-request?name=Tejas"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
