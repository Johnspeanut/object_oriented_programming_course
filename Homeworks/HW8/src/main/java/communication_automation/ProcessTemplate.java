package communication_automation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class representing processing template.
 */
public class ProcessTemplate {

    public ProcessTemplate() {
    }
    /**
     * Read the template and make the whole template to a StringBuilder
      * @param templatePath the input template path
     */
    public StringBuilder stringTemplate(String templatePath) {
        StringBuilder templateString = new StringBuilder();
            try (BufferedReader templateReader =
                    new BufferedReader(new FileReader(templatePath))) {

                String templateLine;
                while((templateLine = templateReader.readLine()) != null) {
                    templateString.append(templateLine);
                    templateString.append("\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return templateString;
    }

    /**
     * write files with given template and personList
     * @param templateString StringBuilder that has template as a string
     * @param personList list that contains all users information from csv file
     */

    public void writeTemplate(StringBuilder templateString,ArrayList<Map<String, String>> personList, String outputFolder) {
        String currDic = System.getProperty("user.dir");
        File dictionary = new File(currDic + "/" +outputFolder);
        if(!dictionary.exists()){
            dictionary.mkdir();
        }

        for (int i = 0; i < personList.size(); i++ ) {
            String s = templateString.toString();
            try (BufferedWriter templateWriter =
                         new BufferedWriter(new FileWriter(outputFolder + i + ".txt"))) {
                String outputFile = null;
                Pattern re1 = Pattern.compile("\\[\\[([^\\]]+)\\]\\]");
                Matcher matcher1 = re1.matcher(s);
                Map<String, String> temPerson = personList.get(i);
                while (matcher1.find()) {
                    String field = matcher1.group(1);
                    s = s.replaceAll("\\[\\[" + field + "\\]\\]", temPerson.get("\"" + field+ "\""));
                    s = s.replaceAll("\"", "");
                    outputFile = s;
                }
                templateWriter.write(outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
