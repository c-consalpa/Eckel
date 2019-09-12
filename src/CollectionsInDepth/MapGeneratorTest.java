package CollectionsInDepth;

import java.util.HashMap;
import java.util.Map;

public class MapGeneratorTest {
    public static void main(String[] args) {
       Pair<Integer, String> pair = new Pair<>(12, "qqqwe");
        MapData<Pair<Integer,String>> mapData = new MapData<>(pair);

    }


}


class Pair<K,V> {
    public  K key;
    public V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MapGenerator<Pair> {

}

class MapData<P> extends HashMap {
    P pair;



    public MapData(P pair) {
        this.pair = pair;
    }

    public void put(P test) {
        
    }
}