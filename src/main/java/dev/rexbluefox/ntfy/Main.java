package dev.rexbluefox.ntfy;

import dev.rexbluefox.ntfy.actions.Action;
import dev.rexbluefox.ntfy.actions.HttpAction;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //System.out.println("Hello World!");
        NtfyClient client = new NtfyClient("https://ntfy.sh/clutchmc-bluefox");
        //NtfyClient client = new NtfyClient("https://postman-echo.com/post");
        HttpAction test = HttpAction.builder()
                .url("https://ntfy.sh/clutchmc-bluefox")
                .body("from Action")
                .label("Send Test")
                .headers(new String[]{"Title=Action","Tags=+1"})
                .clear(false)
                .build();
        System.out.println(test.toString());
        Notification notification = Notification.builder().title("Test 1").message("Test 2").actions(new Action[]{test}).build();
        //System.out.println(notification);
        client.send(notification);
    }
}
