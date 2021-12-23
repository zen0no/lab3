package person;

import car.Car;
import enums.Action;
import interfaces.Message;
import other.StoryTeller;

import java.util.Formatter;
import java.util.Objects;

public class Shorty extends Person implements Message {

    public Shorty(String name, String description){
        super(name, description, "коротышка");
    }

    public void makeFuss(Car c){
        c.destroy();
        StoryTeller.tell(this, Action.DESTROY_TIRES, c);
    }

    public void blame(Person p){
        p.setDescription("оскарблённый");
        StoryTeller.tell(this, Action.BLAME_FOR_MONEY_STEALING);

    }


    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s", getDescription(), getName()).toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shorty s = (Shorty) o;
        return Objects.equals(getName(), s.getName()) && Objects.equals(getDescription(), s.getDescription());
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s %s", getClass().toString(), getName(), getDescription()).toString();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getDescription());
    }
}
