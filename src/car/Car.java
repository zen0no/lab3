package car;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

import enums.Action;
import enums.Brand;
import exceptions.IncorrectCurrencyException;
import exceptions.MovableNotFoundException;
import interfaces.Customer;
import interfaces.Destroyable;
import interfaces.Message;
import interfaces.Movable;
import other.StoryTeller;
import place.Place;

public class Car implements Destroyable, Movable, Message, Customer {
    private final String name;
    private final String description;
    private final Brand brand;
    private boolean intact = true;
    private ArrayList<Component> components = new ArrayList<>();

    private HiddenMoney stolenMoney;

    public Car(String name, String description, Brand brand){
        this.name = name;
        this.description = description;
        components.add(new Tire("1", "левая передняя"));
        components.add(new Tire("2", "правая передняя"));
        components.add(new Tire("3", "левая задняя"));
        components.add(new Tire("4", "правая задняя"));
        this.brand = brand;

    }

    public class HiddenMoney implements Message {
        private final Car car;
        private int amount;
        private String currency;

        private HiddenMoney(int amount, String currency, Car car) {
            this.amount = amount;
            this.car = car;
            this.currency = currency;
        }

        private String getCurrency(){
            return currency;
        }

        private void setCurrency(String currency) {
            this.currency = currency;
        }

        private int getAmount() {
            return this.amount;
        }

        private void addMoney(int i) {
            this.amount += i;
        }

        @Override
        public String toMessage() {
            return (new Formatter().format("%s %s", String.valueOf(getAmount()), getCurrency())).toString();
        }
    }


    public void hideMoney(int i, String currency){
        if (stolenMoney == null){
            stolenMoney = new HiddenMoney(i, "доллар", this);
            StoryTeller.tell(Action.IN, this, Action.HIDE, this.getStolenMoney());
            StoryTeller.tell(Action.NAME_WANTED_CAR_BRAND , this.getBrand());
            return;
        }
        try {
            if (!currency.equals(stolenMoney.currency)) {
                throw new IncorrectCurrencyException("Incorrect currency of money", currency);
            }
            stolenMoney.addMoney(i);
            StoryTeller.tell(Action.IN, this, Action.HIDE, this.getStolenMoney());
        }
        catch (IncorrectCurrencyException e){
            StoryTeller.tell(e);
        }
    }

    public boolean isWanted(){
        return (stolenMoney != null);
    }


    public void visit(Place p){
        StoryTeller.tell((Message) this, Action.DRIVE_TO, p);
        p.addMovable(this);
    }

    public void leave(Place p){
        StoryTeller.tell((Message) this, Action.DRIVE_FROM, p);
        p.removeMovable(this);

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

    public HiddenMoney getStolenMoney() {
        return stolenMoney;
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