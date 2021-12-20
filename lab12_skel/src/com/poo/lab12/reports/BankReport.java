package com.poo.lab12.reports;

import java.util.*;
import java.util.stream.Collectors;

import com.poo.lab12.entities.*;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet())
                                .size();
    }

    public static int getNumberOfAccounts(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .map(s -> s.getAccounts())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet())
                                .size();
    }

    /**
     * TreeSet implementeaza SortedSet asa ca il instantiez pe el cum nu pot instantia SortedSet
     * pentru ca e interfata
     * De asemenea nu mai trebuie sa folosesc .sorted() ca se sorteaza singur cand se transforma
     * intr-un TreeSet
     * A trebuit sa implementez Comparable pentru Employee pentru a avea metoda compareTo ce
     * compara numele pentru a fi folosita de TreeSet
     * Apropo apare si religia pentru ca asa am gasit toString-ul sau
     */
    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static double getTotalSumInAccounts(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .map(s -> s.getAccounts())
                                .flatMap(Collection::stream)
                                .map(s -> s.getBalance())
                                .reduce(0.0, (s, t) -> s + t);
    }

    /**
     * Era gresit return-ul, era SortedSet<Employee> in loc de SortedSet<Account>
     * Am folosit aceeasi idee ca la sortarea de customers, asa ca a trebuit sa implementez
     * comparable si in Account
     * Pentru a compara balance-ul, l-am transformat din double in Double pentru a-i folosi
     * compareTo-ul
     * Pentru ca folosesc TreeSet si comparam doar dupa balance, iar TreeSet-ul nu accepta
     * duplicate => desi 2 conturi aveau id diferit, daca aveau balance-ul identic, atunci aparea
     * doar una in lista
     * Pentru a rezolva problema asta am mai adaugat un if care sa compare dupa id daca sumele din
     * conturi sunt identice
     */
    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .map(s -> s.getAccounts())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * Ordinea din map nu e aceeasi cu Main-ul, dar nu e ca si cum ar conta ca vorbim de un Map
     * aici; m-am uitat la cele doua blocuri de text si sunt la fel ca marime asa ca imi pun
     * baza ca si continutul e bun
     */
    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toMap(s -> s, s -> s.getAccounts()));
    }

    /**
     * Ce ma enerveaza ca nu mai e autocomplete dupa flatMap, asa e si pe Intellij?
     * Imi pare ca groupingBy deja transforma toata treaba intr-un map, fain
     */
    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .collect(Collectors.groupingBy(s -> s.getCity(), Collectors.toList()));
    }

    /**
     * Fac rost de lista cu toate proiectele si apoi grupez fiecare proiect dupa numarul de
     * elemente de acel tip gasite
     * Iau lista cu entry-urile map-ului si caut maximul dupa numarul de aparitii, metoda
     * .max() imi returneaza un Optional<Entry> asa ca trb sa folosesc .get() ca sa fac rost de
     * entry-ul meu
     */
    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        return bank.getClients().stream()
                                .map(s -> s.getEmployees())
                                .flatMap(Collection::stream)
                                .map(s -> s.getProjects())
                                .flatMap(Collection::stream)
                                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .max((s, t) -> s.getValue().compareTo(t.getValue()))
                                .get()
                                .getKey();
    }

    /**
     * Arata suspect codul, dar eu sper ca va fi lizibil dupa explicatie
     * Am grupat angajatii dupa sex => MALE [lista de angajati barbati] 
     *                                       FEMALE [lista de angajati femei]
     * Apoi m-am gandit ca ar fi o idee buna sa prelucrez listele alea de angajati si sa le mapez
     * dupa proiecte si apoi sa le dau flat la proiecte ca sa raman doar cu proiectele angajatilor
     * din lista respectiva si sa dau .size() la lista de proiecte ce a rezultat si asa am facut
     * rost de numarul de proiecte pentru fiecare sex
     * Pentru a face toate astea, am facut un nou map unde am pastrat cheia (MALE -> MALE, 
     * FEMALE -> FEMALE) si doar am prelucrat value-ul cum am zis mai sus
     * Am ramas in final cu [MALE = 42, FEMALE = 22] sau ceva pe aproape, asa ca trebuia doar
     * sa vad maximul dupa value si primeam entry-ul MALE = 42, de unde luam cheia
     */
    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        return bank.getClients().stream()
                         .map(s -> s.getEmployees())
                         .flatMap(Collection::stream)
                         .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.toList()))
                         .entrySet()
                         .stream()
                         .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue().stream()
                                                                     .map(v -> v.getProjects())
                                                                     .flatMap(Collection::stream)
                                                                     .collect(Collectors.toList())
                                                                     .size()))
                         .entrySet()
                         .stream()
                         .max((s, t) -> s.getValue() - t.getValue())
                         .get()
                         .getKey();
    }
}
