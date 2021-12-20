package storage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import communication.ServerMessage;
import main.Utils;

@SuppressWarnings("deprecation")
public class ServerCommunicationController implements Observer {
    
    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof List))
            return;
        
        // verific ca e lista asa ca n-ar trebui sa-mi mai dea IDE ca e unchecked
        List<SensorData> data = (List<SensorData>) arg;
        int last = data.size() - 1;
        System.out.println(new ServerMessage(data.get(last).getStepsCount(), Utils.getClientId(), 
                                                        data.get(last).getTimestamp()).toString());
    }
}
