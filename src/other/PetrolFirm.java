package other;

import interfaces.Customer;
import interfaces.Message;
import interfaces.Movable;
import place.Place;

import java.util.Formatter;
import java.util.Objects;

public class PetrolFirm implements Message {
    private final String name;
    private final String description;
    private final Place storePoint;

    public PetrolFirm(String name, String description, Place storePoint ){
        this.name = name;
        this.description = description;
        this.storePoint = storePoint;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place getStorePoint() {
        return storePoint;
    }

    public boolean canSell(){
        for(Movable m: getStorePoint().getMovables()){
            if (m instanceof Customer && ((Customer) m).isActive()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s", getDescription(), getName()).toString();
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s", getClass().toString(), getName(), getDescription()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetrolFirm that = (PetrolFirm) o;
        return name.equals(that.name) && description.equals(that.description) && storePoint.equals(that.storePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, storePoint);
    }
}
