package p1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreadingTopics {

  public Map<String, Integer> countTopics(List<String> list){
    Map<String,Integer> resultMap = new HashMap<>();
    for(String element:list){
      if(resultMap.containsKey(element)){
        resultMap.put(element, resultMap.get(element) + 1);
      }else{
        resultMap.put(element,1);
      }
    }
    return resultMap;
  }
}
