package exceptions;

import interfaces.Message;

import java.util.Formatter;

public class IncorrectCurrencyException  extends Exception implements Message {

    private String currency;

    public IncorrectCurrencyException(String message, String currency){
        super(message);
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toMessage() {
        return (new Formatter().format("не та валюта: %s", getCurrency())).toString();
    }
}
