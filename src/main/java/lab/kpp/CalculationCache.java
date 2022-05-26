package lab.kpp;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CalculationCache {
    private final Map<DataClass,Integer> hashMap = new HashMap<>();
    public boolean isContain(DataClass key) {
        return hashMap.containsKey(key);
    }
    public void addToMap(DataClass key, Integer value){
        hashMap.put(key,value);
    }
    public Integer getParam(DataClass key){
        return hashMap.get(key);
    }

}