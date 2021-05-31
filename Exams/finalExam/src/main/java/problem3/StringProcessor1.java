package problem3;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor1 {

  public StringProcessor1() {
  }

  /**
   * Static method to replace letter for a list of strings.
   * @param sourceChar source character
   * @param destChar desired character
   * @param stringList a list of strings to be replaced.
   * @return a list of StringResultPack, a data structure I create to contain the results for each
   * element of the stringList.
   */
  public static List<StringResultPack> replaceLetters(char sourceChar, char destChar, List<String> stringList){

    //YOUR CODE HERE
    List<StringResultPack> resultList = new ArrayList<>();
    for(String element:stringList){
      StringResultPack stringResultPack;
      if(element.indexOf(sourceChar) != -1){
        StringBuilder string = new StringBuilder(element);
        int CountFrequency = 0;
        for(int i = 0; i < element.length(); i++){
          if(sourceChar == element.charAt(i)){
            string.setCharAt(i,destChar);
            CountFrequency++;
          }
        }
        stringResultPack = new StringResultPack(element, string.toString(),CountFrequency);

      }else{
        stringResultPack = new StringResultPack(element, null,0);
      }
      resultList.add(stringResultPack);
    }
  return resultList;
  }
  }


