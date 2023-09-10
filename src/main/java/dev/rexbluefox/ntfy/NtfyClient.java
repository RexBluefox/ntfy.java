package dev.rexbluefox.ntfy;

import dev.rexbluefox.ntfy.actions.Action;
import lombok.Builder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

@Builder
public class NtfyClient {
    private String url;
    public NtfyClient(String url){
        this.url = url;
    }

    public void send(Notification notification){
        try {
            URL url = new URL(this.url);
            String postData = notification.getMessage();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Title", notification.getTitle());
            conn.setRequestProperty("Priority", notification.getPriority().name());
            conn.setRequestProperty("Markdown",String.valueOf(notification.isMarkdown()));
            if(notification.getActions()[0]!=null){
                ArrayList<String> actionStrings = new ArrayList<>();
                for (Action action : notification.getActions()) {
                    actionStrings.add(action.toString());
                }
                System.out.println(String.join(";",actionStrings));
                conn.setRequestProperty("Actions",String.join(";",actionStrings));
            }
            conn.setUseCaches(false);

            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
