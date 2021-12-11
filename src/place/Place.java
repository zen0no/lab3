package place;

import interfaces.Message;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

public abstract class Place implements Message {
    private final String name;
    private final String type;
    protected ArrayList<Movable> movables = new ArrayList<Movable>();

    public Place(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;

    }


    public String getType(){
        return type;
    }

    public void addMovable(Movable m){
        this.movables.add(m);
    }

    public ArrayList<Movable> getMovables(){
        return movables;
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s", getClass().toString(), name, type).toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place p = (Place) o;
        return Objects.equals(getName(), p.getName()) && Objects.equals(getType(), p.getType());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getType());
    }

    @Override
    public String toMessage(){
        return this.getName();
    }
}
