package communication_automation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A class representing receivers based on input csv file.
 */
public class Receivers {
  private ArrayList<Map<String, String>> receiverList = new ArrayList();

  /**
   * Read supporter csv and create a list containing receivers' information. Each receiver is a
   * map object. "nonprofit-supporters.csv"
   */
  public void extractReceivers(String fileName){
    System.out.println(System.getProperty("user.dir"));
    try(BufferedReader inputFile =new BufferedReader(new FileReader(fileName))){
      String keyNames = inputFile.readLine(); // this will read the first line
      String[] keyList = keyNames.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");;
      String line;
      while ((line = inputFile.readLine()) != null) {
        String[] lineParts = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        Map<String,String> map = new HashMap();
        for(int i = 0; i < keyList.length; i++){
          map.put(keyList[i],lineParts[i]);
        }
        this.receiverList.add(map);
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * Gets the list of receivers
   * @return the list of receivers.
   */
  public ArrayList<Map<String, String>> getReceiverList() {
    return receiverList;
  }
}
