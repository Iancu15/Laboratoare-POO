package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ex2.Car.CarType;

public class Test {
	public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Car dacia = new Car(20000, 2005, CarType.DACIA);
        Car lada = new Car(10000, 1995, CarType.LADA);
        Car maruti = new Car(3000, 1981, CarType.MARUTI);
        
        dealership.getFinalPrice(dacia);
        dealership.negotiate(dacia, new Offer() {
        	public int getDiscount(Car car) {
        		Random rand = new Random();
        		int[] discount = new int[] {10, 50, 100, 1000, 10000, 100000};
        		return discount[rand.nextInt(discount.length)];
        	}
        });
        System.out.println("\n");
        
        dealership.getFinalPrice(lada);
        System.out.println("\n");
        
        // Maruti-ul il dau pe gratis sa scape de el
        dealership.getFinalPrice(maruti);
        System.out.println("\n");
        
        // se genereaza toate clasele la compilare
        // se genereaza un fisier .class si pentru interfata Offer
        // clasele interne arata de forma ClasaExterna$ClasaInterna.class
        // ex: Dealership$BrandOffer.class
        
        // clasa anonima se ia drept clasa interna a Test-ului, pentru ea
        // apare fisierul Test$1.class, fiind anonima a fost numerotata de
        // compilator
        
        // Task 5 Lambda
        List<Car> cars = new ArrayList<>();
        cars.add(dacia);
        cars.add(lada);
        cars.add(maruti);
        
        System.out.println(cars);
        cars.removeIf((v) -> v.getPrice() > 5000);
        System.out.println(cars);
    }
}
