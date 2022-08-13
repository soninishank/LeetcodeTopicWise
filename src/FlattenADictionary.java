import java.util.HashMap;
import java.util.Map;

public class FlattenADictionary {
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        if (dict.size() == 0) {
            return new HashMap<>();
        }
        HashMap<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> hashMap : dict.entrySet()) {
            doRecursively(result, hashMap.getKey(), hashMap.getValue());
        }
        return result;
    }

    private static void doRecursively(HashMap<String, String> result, String key, Object value) {
        if (value == null) {
            return;
        }
        if (value.getClass().equals(Integer.class)) {
            result.put(key, String.valueOf(value));
        } else if (value.getClass().equals(String.class)) {
            result.put(key, String.valueOf(value));
        } else {
            HashMap<String, Object> dict = (HashMap<String, Object>) value;
            for (Map.Entry<String, Object> hashMap : dict.entrySet()) {
                if (key.isEmpty()) {
                    doRecursively(result, hashMap.getKey(), hashMap.getValue());
                } else {
                    if (hashMap.getKey().isEmpty()) {
                        doRecursively(result, key, hashMap.getValue());
                    } else {
                        doRecursively(result, key + "." + hashMap.getKey(), hashMap.getValue());
                    }
                }
            }
        }
    }
}
