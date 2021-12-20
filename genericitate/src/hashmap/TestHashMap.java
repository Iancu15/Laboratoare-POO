package hashmap;

public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> hashMap = new MyHashMap<>();
        hashMap.put(1, 10);
        hashMap.put(5, 13);
        hashMap.put(5, 5);
        hashMap.put(5, 13);
        hashMap.put(1000, 40);
        System.out.println(hashMap);
        System.out.println(hashMap.get(1000) + "\n");

        MyHashMap<Double, Double> hashMap2 = new MyHashMap<>();
        hashMap2.put(1.0, 10.0);
        hashMap2.put(5.1, 50.0);
        hashMap2.put(5.1, 13.4);
        hashMap2.put(5.1, 10.1);
        hashMap2.put(1000.7, 40.4);
        System.out.println(hashMap2);
        System.out.println(hashMap2.get(1000.7) + "\n");

        MyHashMap<String, Integer> hashMap3 = new MyHashMap<>();
        hashMap3.put("Bucharest", 10);
        hashMap3.put("Giovanni", 13);
        hashMap3.put("Nil", 5);
        hashMap3.put("Nil", 5);
        hashMap3.put("Nil", 13);
        hashMap3.put("Madonna", 40);
        System.out.println(hashMap3);
        System.out.println(hashMap3.get("Nil") + "\n");
        // testez daca cauta o cheie inexistenta => afiseaza null
        System.out.println(hashMap3.get("Ceva"));
    }
}
