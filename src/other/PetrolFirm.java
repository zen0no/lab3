package other;

import enums.Action;
import interfaces.Customer;
import interfaces.Message;
import interfaces.Movable;
import place.Place;
import util.StoryObject;

import java.util.Formatter;
import java.util.Objects;

public class PetrolFirm extends StoryObject {
    private Place storePoint;

    public PetrolFirm(String name, String description, Place storePoint ){
        super(name, description);
        this.storePoint = storePoint;
    }

    public void setStorePoint(Place p){
        this.storePoint = p;
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
        StoryTeller.tell(this, Action.IS_BROKEN);
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
        return getName().equals(that.getName()) && getDescription().equals(that.getDescription()) && storePoint.equals(that.storePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), storePoint);
    }
}
