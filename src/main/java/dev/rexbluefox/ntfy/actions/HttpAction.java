package dev.rexbluefox.ntfy.actions;

import dev.rexbluefox.ntfy.enums.HttpMethod;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class HttpAction extends Action{
    private final String action = "http";
    private String label;
    private String url;
    @Builder.Default
    private HttpMethod method = HttpMethod.POST;
    @Builder.Default
    private String[] headers = new String[]{};
    private String body;
    private boolean clear;

//    public HttpAction(String label, String url, String body, boolean clear, String[] headers, HttpMethod method){
//        this.label = label;
//        this.url = url;
//        this.body = body;
//        this.clear = clear;
//        this.headers = headers;
//        this.method = method;
//
//    }

    @Override
    public String toString(){
        ArrayList<String> headerStrings = new ArrayList<>();
        for (String header : headers) {
            headerStrings.add("headers."+header);
        }
        return action + ", "+label+", "+url+", "+"method="+method.toString()+", "+String.join(",",headerStrings)+", "+"body="+body;
    }
}
