package storage;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ConsoleLogger implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString());
    }

}