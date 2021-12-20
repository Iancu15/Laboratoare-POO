package dataprocessing;

import java.util.List;

import storage.SensorData;

public class FilteredStepCountStrategy implements StepCountStrategy {

    @Override
    public int getTotalSteps(List<SensorData> data) {
        int numberOfSteps = 0;
        long lastTimestamp = 0;
        for (SensorData sensorData : data) {
            int stepCount = sensorData.getStepsCount();
            // prima data intra automat ca n-are timestamp fata de care sa se compare
            if (lastTimestamp == 0) {
                lastTimestamp = sensorData.getTimestamp();
                numberOfSteps += stepCount;
                continue;
            }
            
            if (stepCount > 0) {
                long pause = sensorData.getTimestamp() - lastTimestamp;
                // 1000 de steps la 60 de secunde ~= 16.66 steps pe secunda
                // adauga doar daca nu a depasit aceasta limita de 16.66 de la ultimul timestamp
                if (stepCount/pause < 16.66)
                    numberOfSteps += stepCount;
            }
        }
        
        return numberOfSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "returns the total number of steps, that satisfy the filter, since the app started "
                                                                                    + "running";
    }

}
