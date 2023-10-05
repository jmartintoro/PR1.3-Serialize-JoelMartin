import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable{
    public HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    

    public void addHashMap(String text, Integer num) {
        hashMap.put(text, num);
    }
}
