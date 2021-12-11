package enums;

import interfaces.Message;

import java.util.Formatter;

public enum Action implements Message {
    NAME_WANTED_CAR_BRAND("брэнд разыскиваемой машины: "),
    DRIVE_TO("заехал на"),
    DESTROY_TIRES("попрезал шины у"),
    IS_BROKEN("обанкротилась"),
    BLAME_FOR_MONEY_STEALING("обвинил полицию в похещении денег"),
    WANT_TO_ARREST("хочет посадить"),
    TO("в")
    ;


    private final String description;

    Action(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toMessage(){
        return getDescription();
    }
}
