package person;

import interfaces.Message;
import interfaces.Movable;
import place.Place;
import util.StoryObject;

import java.util.Formatter;
import java.util.Objects;

public abstract class Person extends StoryObject implements Movable {

    private String job;

    Person(String name, String description, String job){
        super(name, description);
        this.job = job;
    }

    public String getJob() {
        return job;
    }


    public void setJob(String s){
        this.job = job;
    }



    @Override
    public void visit(Place p){
        p.addMovable(this);
    }

    @Override
    public void leave(Place p){
        p.removeMovable(this);
    }

    @Override
    public String toMessage(){
        return (new Formatter()).format("%s %s %s", getDescription(), getJob(), getName()).toString();
    }


    @Override
    public String toString(){
        return (new Formatter()).format("<%s> %s: %s %s", getClass().toString(), getName(), getDescription(), getJob()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getDescription().equals(person.getDescription()) && job.equals(person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), job);
    }
}
