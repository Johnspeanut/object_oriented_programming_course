package todoApplication.model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {

    private ArrayList<String> header;

    public WriteCSV() {
        this.header = new ArrayList<>();
        addHeader();
    }

    /**
     * add header to the header list
     */
    private void addHeader(){
        this.header.add("id");
        this.header.add("text");
        this.header.add("completed");
        this.header.add("due");
        this.header.add("priority");
        this.header.add("category");
    }

    /**
     * print the item in the list to CSV file
     * @param todoList the todo list to be printed
     * @param fileName path of the csv file
     */
    public void writeCSV(ArrayList<ArrayList<String>> todoList, String fileName){
        todoList.add(0,this.header);
        try (BufferedWriter CSVWriter =
                     new BufferedWriter(new FileWriter(fileName))) {
            //String outputFile = null;
            for(int i = 0; i < todoList.size();i++) {
                List<String> todo = todoList.get(i);
                // join each element with comma, and print
                String line = String.join(",",todo);
                // end of each todo, add newline
                line = line + System.lineSeparator();
                // write to the csv file
                CSVWriter.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
