package factory;

import dataprocessing.BasicStepCountStrategy;
import dataprocessing.FilteredStepCountStrategy;
import dataprocessing.StepCountStrategy;
import main.Utils;

public class StepCountStrategyFactory {
    public static StepCountStrategy makeStrategy(String strategyName) {
        switch(strategyName) {
            case Utils.BASIC_STRATEGY: return new BasicStepCountStrategy();
            case Utils.FILTERED_STRATEGY: return new FilteredStepCountStrategy();
        }
        
        return null;
    }
}
