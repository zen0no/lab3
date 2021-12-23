package exceptions;

import interfaces.Message;
import interfaces.Movable;

import java.util.Formatter;

public class MovableNotFoundException extends Exception implements Message {
    private Movable m;

    public MovableNotFoundException(String message, Movable m){
        super(message);
        this.m = m;
    }

    @Override
    public String toMessage(){
        return (new Formatter().format("%s %s", "движущийся объект не найден", m)).toString();
    }
}
