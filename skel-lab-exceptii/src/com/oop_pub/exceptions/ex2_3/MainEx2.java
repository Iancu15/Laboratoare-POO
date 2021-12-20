package com.oop_pub.exceptions.ex2_3;

import java.util.ArrayList;
import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        /**
         * Raspuns Ex3: In situatia asta ar trebui sa fie unchecked pentru ca sunt genul de erori 
         * dupa care nu mai poti continua programul ca strica flow-ul
         * In cazul in care folosim checked putem face ca mai jos sa afisam stack trace-ul la
         * toate sau pentru a nu opri serverul in cazul unui website sau ceva am putea sa rugam
         * utilizatorul sa bage alte valori
         * Legat de cealalta intrebare, utilizatorul nu prea poate sa faca operatii arimetice
         * ca doar da parametrii, nu are acces la cod ca sa faca direct cu operatorul "+-/", asa
         * ca trebuie sa foloseasca o instanta de Calculator
         */
        Calculator calculator = new CalculatorDouble();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

        /**
         * Daca le puneam pe toate intr-un singur try-catch imi afisa doar stacktrace-ul primei
         * exceptii pe care o intalnea, asa ca le-am bagat in try-catch-uri separate sa le vad pe
         * toate
         */
        System.out.println("-----------------ADD EXCEPTIONS----------------------------");
        try {
            System.out.println(calculator.add(2d, null));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }
        
        try {
            System.out.println(calculator.add(null, 2d));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.add(1d, Double.POSITIVE_INFINITY - 1));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.add(Double.NEGATIVE_INFINITY, 0d));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        System.out.println("-----------------DIVIDE EXCEPTIONS----------------------------");

        try {
            System.out.println(calculator.divide(2d, null));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }
        
        try {
            System.out.println(calculator.divide(null, 2d));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.divide(5d, 0d));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        System.out.println("-----------------AVERAGE EXCEPTIONS----------------------------");

        try {
            System.out.println(calculator.average(List.of(null, 2d, 3d, 4d)));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.average(List.of(1d, 2d, 3d, null)));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.average(null));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        /**
         * Da divide by zero pentru ca atunci cand face divide(sum, new Double(numbers.size())),
         * numbers.size() este 0 pentru ca lista e goala
         */
        try {
            System.out.println(calculator.average(new ArrayList<Double>()));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.average(List.of(Double.POSITIVE_INFINITY, 0d, -1d, 1d)));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println(calculator.average(List.of(2d, 3d, Double.NEGATIVE_INFINITY, -5d)));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\n");
        }
    }
}
