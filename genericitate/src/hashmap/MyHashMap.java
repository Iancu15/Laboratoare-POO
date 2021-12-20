package hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private class Entry {
        private K key;
        private List<V> value;

        public Entry(K key) {
            this.key = key;
            this.value = new ArrayList<V>();
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public List<V> getValue() {
            return value;
        }

        public void setValue(List<V> value) {
            this.value = value;
        }

        public void addValue(V individualValue) {
            value.add(individualValue);
        }

        @Override
        public String toString() {
            return "(" + this.key + ", " + this.value + ")\n";
        }
    }

    private List<Entry> entries;
    private Integer numberOfBuckets;

    /**
     * By default iau numarul de buckets ca 100
     */
    public MyHashMap() {
        this.entries = new ArrayList<Entry>(100);
        for (int i = 0; i < 100; i++) {
            this.entries.add(null);
        }

        numberOfBuckets = 100;
    }

    /**
     * Adaug toate entry-urile pe care sa le populez mai incolo, nu am gasit o metoda sa fac
     * un arrayList fix asa ca m-am multumit cu asta
     * array nu merge pentru obiecte din pacate
     * @param numberOfBuckets   numarul de buckets
     */
    public MyHashMap(Integer numberOfBuckets) {
        this.entries = new ArrayList<Entry>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            this.entries.add(null);
        }

        this.numberOfBuckets = numberOfBuckets;
    }

    /**
     * Adauga un entry in lista de entries in caz ca nu se afla, in caz contrar adaug valoarea
     * la entry-ul deja existent
     * @param key       cheia noului sau curentului entry
     * @param value     valoarea ce trebuie adauga in hashmap
     */
    public void put(K key, V value) {
        try {
            Entry entry = entries.get(getHashCode(key));
            if (entry != null) {
                // daca entry-ul exista si nu are acea valoare o adauga in lista de valori
                if (!entry.getValue().contains(value)) {
                    entry.addValue(value);
                }
            } else {
                addNewEntry(key, value);
            }
        } catch (IndexOutOfBoundsException e) {
            addNewEntry(key, value);
        }
    }

    /**
     * Adauga un nou entry
     * @param key       cheia noului entry
     * @param value     prima valoare din noul entry
     */
    private void addNewEntry(K key, V value) {
        Entry entry = new Entry(key);
        entry.addValue(value);
        entries.add(getHashCode(key), entry);
    }

    /**
     * Intoarce valoarea aflata la haschcode-ul cheii daca ea exista, altfel afiseaza null
     * @param key       cheia dupa care se cauta in map
     * @return
     */
    public List<V> get(K key) {
        if (entries.get(getHashCode(key)) != null) {
            return entries.get(getHashCode(key)).getValue();
        }

        return null;
    }

    /**
     * Calculeaza hashCode-ul cheii
     * @param key
     * @return
     */
    private Integer getHashCode(K key) {
        Integer hashCode = key.hashCode() % numberOfBuckets;
        if (hashCode > 0) {
            return hashCode;
        } else {
            return -hashCode;
        }
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numberOfBuckets; i++) {
            if (entries.get(i) != null) {
                builder.append("Entries[" + i + "] -> " + entries.get(i).toString());
            }
        }

        return builder.toString();
    }
}
