package com.oop_pub.exceptions.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEx1 {
    private static void readAndPrintLine() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            System.out.println(input);
        } catch (IOException e) {
            throw new IOException("EROARE LA CITIRE");
        }
    }

    public static void main(String[] args) {
        try {
            readAndPrintLine();
        } catch (IOException e) {
            System.exit(1);
        } catch (Exception e) {
            System.exit(2);
        }
    }
}
