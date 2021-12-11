package place;

import interfaces.Movable;
import person.Person;


public class Bullpen extends Place{

    public Bullpen(String name){
        super(name, "кутузка");
    }

    @Override
    public void addMovable(Movable m) {
        if (m instanceof Person) {
            super.addMovable(m);
        } else throw new IllegalArgumentException("Use Person");
    }

}
