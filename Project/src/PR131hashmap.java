import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable {
    private static final long serialVersionUID = -5564091558358561121L; // Define el serialVersionUID

    private HashMap<String, Integer> hashMap = new HashMap<>();

    public void addHashMap(String text, Integer num) {
        hashMap.put(text, num);
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }
}
