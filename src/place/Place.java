package place;

import exceptions.MovableNotFoundException;
import interfaces.Message;
import interfaces.Movable;
import other.StoryTeller;
import util.StoryObject;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

public abstract class Place extends StoryObject {
    private String type;
    protected ArrayList<Movable> movables = new ArrayList<Movable>();

    public Place(String name, String type){
        super(name, "");
        this.type = type;
    }

    public void setType(String type){
        this.type =type;
    }


    public String getType(){
        return type;
    }

    public void addMovable(Movable m){
        this.movables.add(m);
    }
    public void removeMovable(Movable m){
        try {
            if (this.movables.contains(m)) {
                this.movables.remove(m);
            } else {
                throw new MovableNotFoundException("Movable not found at movables", m);
            }
        }
        catch (MovableNotFoundException e){
            StoryTeller.tell(e);
        }
    }

    public ArrayList<Movable> getMovables(){
        return movables;
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s", getClass().toString(), getName(), type).toString();
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
