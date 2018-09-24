package com.hash;

public class SimpleHashtable {
    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    //LINEAR PROBE ON PUT IF A COLLISION WITH THE HASHKEYS OCCURS
    public void put (String key, Employee employee) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)){
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1){
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    //WE STOP SEARCHING ON NULL FOR COLLISIONS BECAUSE ALL HASHKEYS MUST BE CONSECUTIVELY NEXT TO EACH OTHER (GETS REHASHED WHEN REMOVED)
    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey) && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;

        if (hashedKey == hashtable.length - 1){
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if ( hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        } else {
            return -1;
        }
    }

    //REMOVE CREATES A NEW HASHMAP AND RE PUTS EVERYTHIGN SO ALL THE HASHKEYS WLL BE PROPERLY MAPPED AND IF THERE IS LINEAR PROBIGN IT WILL BE REPROBED BECAUSE IT'S BEING PUT(LINEAR PROBING PUT FUNCTION) BACK
    //INTO A NEW ARRAY
    //HASHES THAT HAVE COLLISION KEYS CAN ONLY CONSECUTIVELY BE NEXT TO EACH OTHER THATS WHY WE HAVE TO REHASH ON EVERY REMOVAL
    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];

        //REHASHING on every removal :O
        for (int i = 0; i  < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println(i);
            } else {
                System.out.println(hashtable[i].employee);
            }
        }
    }
}
