package person;

import interfaces.Message;
import interfaces.Movable;
import place.Place;

import java.util.Formatter;
import java.util.Objects;

public abstract class Person implements Message, Movable {

    private final String name;
    private String description;
    private final String job;

    Person(String name, String description, String job){
        this.name = name;
        this.description = description;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getJob() {
        return job;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void visit(Place p){
        p.addMovable(this);
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
        return name.equals(person.name) && description.equals(person.description) && job.equals(person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, job);
    }
}
