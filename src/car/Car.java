package car;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

import enums.Brand;
import interfaces.Customer;
import interfaces.Destroyable;
import interfaces.Message;
import interfaces.Movable;
import place.Place;

public class Car implements Destroyable, Movable, Message, Customer {
    private final String name;
    private final String description;
    private final Brand brand;
    private boolean intact = true;
    private ArrayList<Component> components = new ArrayList<>();

    public Car(String name, String description, Brand brand){
        this.name = name;
        this.description = description;
        components.add(new Tire("1", "левая передняя"));
        components.add(new Tire("2", "правая передняя"));
        components.add(new Tire("3", "левая задняя"));
        components.add(new Tire("4", "правая задняя"));
        this.brand = brand;

    }

    public void visit(Place p){
        p.addMovable(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Brand getBrand(){
        return brand;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public boolean isIntact() {
        return intact;
    }

    public void setIntact(boolean intact) {
        this.intact = intact;
    }

    @Override
    public boolean isActive(){
        return isIntact();
    }

    @Override
    public void destroy(){
        for(Component c: components){
            c.destroy();
        }
        setIntact(false);
    }

    @Override
    public void repair(){
        for(Component c: components){
            c.repair();
        }
        setIntact(true);
    }

    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s %s", getDescription(), getBrand().getDescription(), getName()).toString();
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s %s", getClass().toString(), getName(), getDescription(), getBrand()).toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Car c = (Car) o;
        return Objects.equals(getName(), c.getName()) && Objects.equals(getDescription(), c.getDescription()) && Objects.equals(getComponents(), c.getComponents()) && Objects.equals(getBrand(), c.getBrand());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getDescription(), getComponents(), getBrand());
    }
}