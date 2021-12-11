package other;

import car.Car;
import interfaces.Message;

import java.util.Formatter;
import java.util.Objects;

public class Shorty implements Message {
    private final String name;
    private final String description;

    public Shorty(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void makeFuss(Car c){
        c.destroy();
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
