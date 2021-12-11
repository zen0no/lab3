package person;

import place.Place;

public class PoliceCommissar extends Person {
    public PoliceCommissar(String name, String description){
        super(name, description, "полицейский комиссар");
    }

    public void makeVisit(Person person, Place place){
        place.addMovable(person);
    }
}
