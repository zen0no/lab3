package interfaces;

import place.Place;

public interface Movable {
    public void visit(Place p);
    public void leave(Place p);
}
