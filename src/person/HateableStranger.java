package person;


public class HateableStranger extends Person{
    public HateableStranger(String name, String description){
        super(name, description, "человек");
    }

    public void blame(Person p){
        p.setDescription("оскарблённый");
    }
}
