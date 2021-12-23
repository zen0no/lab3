package util;

import interfaces.Message;

public abstract class StoryObject implements Message {
    private String name;
    private String description;


    public StoryObject(String name, String description){
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public abstract String toMessage();


}
