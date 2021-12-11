package other;

import enums.Action;
import interfaces.Message;

import java.util.Formatter;

public class StoryTeller {
    public static void tell(Message... m){
        String s = "";
        for (Message n: m){
            s += n.toMessage() + " ";
        }
        System.out.println(s);
    }
}
