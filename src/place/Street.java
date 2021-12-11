package place;

public class Street extends Place{
    public Street(String name){
        super(name, "улица");
    }

    public Street(){
        super("", "улица");
    }
}
