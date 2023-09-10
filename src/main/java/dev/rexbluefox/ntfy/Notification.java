package dev.rexbluefox.ntfy;

import dev.rexbluefox.ntfy.actions.Action;
import dev.rexbluefox.ntfy.enums.Priority;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
public class Notification {
    @Getter
    private String title;

    @Builder.Default
    @Getter
    private String message = "";

    @Builder.Default
    @Getter
    private Priority priority = Priority.DEFAULT;

    @Builder.Default
    @Getter
    private boolean markdown = false;

    @Builder.Default
    @Getter
    private String[] tags = new String[]{};

    @Builder.Default
    @Getter
    private Action[] actions = new ArrayList<Action>().toArray(new Action[]);

//    public Notification(String title,String message,Priority priority,boolean markdown,Action[] actions,String[] tags) throws Exception {
//        if(actions.length > 3){
//            throw new Exception("Cant add more than 3 Actions");
//        }
//        this.title = title;
//        this.message = message;
//        this.priority = priority;
//        this.markdown = markdown;
//        this.tags = tags;
//        this.actions = actions;
//
//    }
}
