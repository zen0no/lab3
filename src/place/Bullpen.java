package place;

import interfaces.Movable;
import person.Person;


public class Bullpen extends Place{

    public Bullpen(String name){
        super(name, "кутузка");
    }

    @Override
    public void addMovable(Movable m) {
        super.addMovable(m);
    }

}
