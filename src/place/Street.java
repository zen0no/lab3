package place;

import enums.Action;
import interfaces.Message;
import interfaces.Movable;
import other.StoryTeller;

public class Street extends Place{
    public Street(String name){
        super(name, "улица");
    }

    public Street(){
        super("", "улица");
    }

    @Override
    public void addMovable(Movable m){
        super.addMovable(m);
    }

}
