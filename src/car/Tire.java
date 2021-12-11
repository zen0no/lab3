package car;

import interfaces.Message;

import java.util.Formatter;

public class Tire extends Component implements Message {

    Tire(String name, String description){
        super(name, description, "шина");
    }

    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s", getDescription(), getName()).toString();
    }
}
