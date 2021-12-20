package ex2;

import java.util.Random;

import ex2.Car.CarType;

public class Dealership {
	int carNumber;
	
	public Dealership() {
		this.carNumber = 1;
	}
	
	public int getCarNumber() {
		return carNumber;
	}

	private class BrandOffer implements Offer {
		public int getDiscount(Car car) {
			if (car.getType().compareTo(CarType.DACIA) == 1) {
				return car.getPrice()*5/100;
			} else if(car.getType().compareTo(CarType.LADA) == 1) {
				return 0;
			} else {
				return car.getPrice()*3/100;
			}
		}
	}
	
	private class DealerOffer implements Offer {
		public int getDiscount(Car car) {
			// nu se pune anul curent ca sunt mai greedy dealerii
			return 100*(2020 - car.getYear());
		}
	}
	
	private class SpecialOffer implements Offer {
		public int getDiscount(Car car) {
			Random rand = new Random();
			return rand.nextInt(100);
		}
	}
	
	public void getFinalPrice(Car car) {
		System.out.println("Precio inicial del coche numero " + this.carNumber +
				" : " + car.getPrice() + " RON");
		
		int brandDiscount = new Dealership.BrandOffer().getDiscount(car);
		System.out.println("Aplicar descuento de marca: " + brandDiscount + " RON");
		
		int dealerDiscount = new Dealership.DealerOffer().getDiscount(car);
		System.out.println("Aplicar descuento de distribuidor: " + dealerDiscount + " RON");
		
		int specialDiscount = new Dealership.SpecialOffer().getDiscount(car);
		System.out.println("Aplicar descuento especial: " + specialDiscount + " RON");
		int discount = brandDiscount + dealerDiscount + specialDiscount;
		
		// daca discount-ul e mai mare decat pretul se da pe moca
		if (discount > car.getPrice()) {
			car.setPrice(0);
		} else {
			car.setPrice(car.getPrice() - discount);
		}
		
		this.carNumber++;
		System.out.println("Precio final: " + car.getPrice() + " RON");
	}
	
	public void negotiate(Car car, Offer offer) {
		Random rand = new Random();
		
		if (rand.nextInt(2) == 0) {
			System.out.println("La negociación falló");
			return;
		}
		
		int discount = offer.getDiscount(car);
		System.out.println("Aplicando descuento de cliente: " + discount + " RON");
		
		if (discount > car.getPrice()) {
			car.setPrice(0);
		} else {
			car.setPrice(car.getPrice() - discount);
		}
		
		System.out.println("Precio final tras negociación: " + car.getPrice() + " RON");
	}
}
