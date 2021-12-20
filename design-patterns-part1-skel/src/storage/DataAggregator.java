package storage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import dataprocessing.StepCountStrategy;

@SuppressWarnings("deprecation")
public class DataAggregator implements Observer{
    private StepCountStrategy strategy;

    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof List))
            return;
        
        System.out.println(this.strategy.getTotalSteps((List<SensorData>) arg));
    }
}
