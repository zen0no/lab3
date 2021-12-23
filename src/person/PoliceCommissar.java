package person;

import enums.Action;
import other.AddressBook;
import other.StoryTeller;
import place.Place;

public class PoliceCommissar extends Person {
    public PoliceCommissar(String name, String description){
        super(name, description, "полицейский комиссар");
    }

    public void tryToArrest(AddressBook b, Person person, Place place){
        StoryTeller.tell(this, Action.WANT_TO_ARREST, person, Action.TO, place);
        AddressBook.Address a = searchAddress(b, person);
        if (a != null){
            place.addMovable(person);
        }

    }

    public AddressBook.Address searchAddress(AddressBook book, Person p){
        StoryTeller.tell(this, Action.SEARCH_ADDRESS, p, Action.IN, book);
        return book.getAddress(p);
    }
}
