package problem_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollection {

  public static void main(String[] args) {
    DataCollection test = new DataCollection();
    List<Integer> list = Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 4 ,4);
    HashMap map = test.frequency(list);
    System.out.println(Arrays.asList(map));

  }

  public HashMap<Integer, Double> frequency(List<Integer> list){
    HashMap<Integer, Integer> map = new HashMap<>();
    double size = (double)list.size();
    System.out.println(size);
    for(Integer element:list){
      map.put(element, map.getOrDefault(element,0) + 1);
    }
    HashMap<Integer, Double> mapReturn = new HashMap<>();
    for(Map.Entry<Integer, Integer> element:map.entrySet()){
      mapReturn.put(element.getKey(), element.getValue()/size);
    }
    return mapReturn;
  }

}
