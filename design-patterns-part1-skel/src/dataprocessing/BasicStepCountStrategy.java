package dataprocessing;

import java.util.List;

import storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {

    @Override
    public int getTotalSteps(List<SensorData> data) {
        int numberOfSteps = 0;
        for (SensorData sensorData : data) {
            numberOfSteps += sensorData.getStepsCount();
        }
        
        return numberOfSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "returns the total number of steps since the app started running";
    }

}
