package exceptions;

import interfaces.Message;
import person.Person;

import java.util.Formatter;

public class PersonNoAddressException extends RuntimeException implements Message {

    private Person person;

    public PersonNoAddressException(String message, Person person){
        super(message);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toMessage() {
        return (new Formatter().format("%s %s", getPerson().getName(), "нет адреса")).toString();
    }
}
