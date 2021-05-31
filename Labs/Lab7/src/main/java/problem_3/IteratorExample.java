package problem_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class IteratorExample {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(100);
    list.add(5);
    list.add(15);
    Iterator iterator = list.iterator();
//    while(iterator.hasNext()){
//      if((int)iterator.next() > 1){
////        iterator.remove();
////        System.out.println("" + iterator.next());
//        int element = (int)iterator.next();
//        System.out.println(element);
//      }
//    }
    System.out.println(Arrays.asList(list));
  }


}
