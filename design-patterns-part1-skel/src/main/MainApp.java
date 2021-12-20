package main;

import storage.ConsoleLogger;
import storage.DataAggregator;
import storage.DataRepository;
import storage.SensorData;
import storage.ServerCommunicationController;

import java.util.Scanner;

import dataprocessing.StepCountStrategy;
import factory.StepCountStrategyFactory;

public class MainApp {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();

        StepCountStrategy strategy = StepCountStrategyFactory.makeStrategy(strategyType);

        ConsoleLogger consoleLogger = new ConsoleLogger();
        DataAggregator dataAgreggator = new DataAggregator(strategy);
        ServerCommunicationController serverComms = new ServerCommunicationController();
        
        dataRepository.addObserver(consoleLogger);
        dataRepository.addObserver(serverComms);
        dataRepository.addObserver(dataAgreggator);

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();
        
        // 20 / (2 - 1) = 20 > 16.66, nu se aduna la filtered
        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        // TODO: after the first successful run, change this to baseTimestamp + 40000 and check the result
        dataRepository.addData(new SensorData(4000, baseTimestamp + 40000));
        System.out.println();
        // daca schimb din 4 in 40000 => 40000/4000 = 10 < 16.67 asa ca se aduna

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();
    }
}
