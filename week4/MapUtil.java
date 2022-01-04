package ss.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	if (map.isEmpty()) {
    		return true;
    	}
    	Set<V> set = new HashSet<V>(map.values());
        return set.size() == map.keySet().size();
    }
    
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	return map.values().containsAll(range) || map.isEmpty();
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> inverse = new HashMap<V, Set<K>>();
    	
    	for (V val: map.values()) {
    		Set<K> keyset = new HashSet<K>();
    		for (K key: map.keySet()) {
    			if (val.equals(map.get(key))) {
    				keyset.add(key);
    			}
    		}
    		inverse.put(val, keyset);
    	}
    	return inverse;
    }
    
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
    	
    	Map<V, K> inverse = new HashMap<V, K>();
    	Set<V> range = new HashSet<V>(map.values());
    	
    	if (isOneOnOne(map) && isSurjectiveOnRange(map, range)) {
    		for (K key: map.keySet()) {
    			inverse.put(map.get(key), key);
    		}
    	}
    
    	return inverse;
    }
	
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
    	
    	return g.keySet().containsAll(f.values());
    }
	
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
    	if (compatible(f, g)) {
    		
    		Map<K, W> composed = new HashMap<K, W>();
    		
    		for (K k: f.keySet()) {
    			composed.put(k, g.get(f.get(k)));
    		}
    		return composed;
    	}
        return null;
    }
	
}







//public static <K, V> boolean isOneOnOne(Map<K, V> map) {
//	if (map.isEmpty()) {
//		return true;
//	}
//	
//	int contains = 0;
//	for (V val : map.values()) {
//		for (K key: map.keySet()) {
//			if (val.equals(map.get(key))) {
//				contains++;
//				if (contains > 1) {
//					return false;
//				}
//			}
//		}
//		contains = 0;
//	}
//    return true;
//}