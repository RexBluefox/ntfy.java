package dev.rexbluefox.ntfy.enums;

public enum Priority {
    MAX("max",5),
    HIGH("high",4),
    DEFAULT("default",3),
    LOW("low",2),
    MIN("min",1);

    private String name;
    private int id;
    Priority(String name, int id){
        this.name = name;
        this.id = id;
    }


}
