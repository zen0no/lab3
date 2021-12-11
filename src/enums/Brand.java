package enums;

import interfaces.Message;

public enum Brand implements Message {
    VOLKSWAGEN("фольксваген"),
    MERCEDES("мерс"),
    RENO("рено"),
    VAZ("вазик"),
    BMW("бэха"),
    UNKNOWN("неизвестно");



    private final String description;

    Brand(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toMessage(){
        return this.getDescription();
    }

}
