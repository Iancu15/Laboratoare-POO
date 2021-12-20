package ex1;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
 
        Car.OttoEngine firstEngine = car.getEngine();
        Car.OttoEngine secondEngine = car.new OttoEngine(10);
        Engine thirdEngine = car.getEngine(12);
 
        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());
        // Afiseaza tot 11 ca exemplul din lab avea hardcodat 11
        System.out.println(thirdEngine.getFuelCapacity());
    }
}
