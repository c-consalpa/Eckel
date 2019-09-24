package CollectionsInDepth.SetsFunctionality;

import java.util.*;

public class SlowSetDemo {
    public static void main(String[] args) {
        Random random = new Random();
        SlowSet slowSet = new SlowSet(3);
        for (int i = 0; i < 20; i++) {
            SlowSetEntry slowSetEntry = new SlowSetEntry(random.nextInt(128), random.nextInt(128));
            slowSet.add(slowSetEntry);
        }
        slowSet.add(new SlowSetEntry(0, 0));
        slowSet.add(new SlowSetEntry(0, 0));




        System.out.println(slowSet);
    }
}

class SlowSet {
    LinkedList<SlowSetEntry>[] buckets;

    public SlowSet(int capacity) {
        buckets = new LinkedList[capacity];
    }

    public void add(SlowSetEntry slowSetEntry) {
        int insertionBucket = slowSetEntry.hashCode() % buckets.length;

        if (buckets[insertionBucket] == null) {
            buckets[insertionBucket] = new LinkedList<>();
            LinkedList<SlowSetEntry> list = buckets[insertionBucket];
            list.add(slowSetEntry);
        } else {
            LinkedList<SlowSetEntry> list = buckets[insertionBucket];
            if (list.contains(slowSetEntry)) {
                System.out.println("Attempt to insert  a duplicate. Rejected: " + slowSetEntry);
                return;
            }

            list.add(slowSetEntry);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            Iterator<SlowSetEntry> it = buckets[i].iterator();
            while (it.hasNext()) {
                SlowSetEntry sEntry =  it.next();
                sb.append(sEntry.toString());
                sb.append(", ");
            }
        }
        sb.append("};");
        return sb.toString();
    }
}

class SlowSetEntry {
    public Integer value1;
    public Integer value2;


    public SlowSetEntry(int i, int j) {
        this.value1 = i;
        this.value2 = j;
    }

    @Override
    public String toString() {
            return "{" + value1 + ":" + value2 + ": hash: " + hashCode() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (    obj instanceof SlowSetEntry &&
                this.value1 == ((SlowSetEntry) obj).value1 &&
                this.value2 == ((SlowSetEntry) obj).value2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        hash =  prime * hash + value1.hashCode();
        hash =  prime * hash + value2.hashCode();
        return hash;
    }
}