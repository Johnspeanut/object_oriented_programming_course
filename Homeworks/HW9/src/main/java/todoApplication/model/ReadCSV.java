package todoApplication.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadCSV {

    /**
     * get the file path to process the CSV file
     * skip the first line and start reading from the second line
     * for each line, for each element split by comma, and make each todo as a single list
     * then add each todo to this.todoList for future use.
     * @param fileName the file name which stores the data
     * @return a list of string lists
     * @throws IOException throw IO exception if having processing error.
     */
    public static ArrayList<ArrayList<String>> readFile(String fileName) throws IOException {
        ArrayList<ArrayList<String>> todoList = new ArrayList<>();
        try(BufferedReader inputFile = new BufferedReader(new FileReader(fileName))){
            String keyNames = inputFile.readLine(); // read the first line
            String[] header = keyNames.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] lineParts = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                int arraySize = lineParts.length;
                ArrayList<String> todo = new ArrayList<>();
                for(int i = 0; i < arraySize; i++){
                    String singleCell = lineParts[i]. replaceAll("^\"+|\"+$", "");
                    todo.add(singleCell);
                }
                todoList.add(todo);
            }
            return todoList;
        }catch (FileNotFoundException fileNotFoundException) {
             throw new FileNotFoundException("file not found");
        } catch (IOException ioException) {
            throw new IOException("IO exception");
        }
    }

}
