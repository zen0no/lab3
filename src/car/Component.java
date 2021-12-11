package car;

import interfaces.Destroyable;
import interfaces.Message;

import java.util.Objects;
import java.util.Formatter;

abstract class Component implements Message {
    private final String name;
    private final String description;
    private final String type;
    private boolean intact = true;

    Component(String name, String description, String componentName){
        this.name = name;
        this.description = description;
        this.type = componentName;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getType(){
        return type;
    }

    public boolean isIntact(){
        return intact;
    }

    public void destroy(){
        intact = false;
    }

    public void repair(){
        intact = true;
    }

    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s", this.getDescription(), this.getName()).toString();
    }

    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s %s", getClass().toString(), getName(), getDescription(), getType()).toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Component c = (Component) o;
        return java.util.Objects.equals(getName(), c.getName()) && java.util.Objects.equals(getDescription(), c.getDescription()) &&
                java.util.Objects.equals(getType(), c.getType());
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(getName(), getDescription(), getType());
    }

}
