package communication_automation;

import java.util.ArrayList;
import java.util.Map;

/**
 * This is the entrance of the package.
 */
public class Main {

  public static void main(String[] args) {
//    args = "--letter-template letter-template.txt --letter --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
    // args = "--email --email-template email-template.txt --output-dir outputfoler/ --csv-file nonprofit-supporters.csv".split(" ");
    try{
      /**
       *  Parse command line
       */
      CommandLineParser parser = new CommandLineParser(args);
      /**
       *  Create a receivers list
       */
      Receivers receivers = new Receivers();
      receivers.extractReceivers(parser.getInputCSVPath());
      ArrayList<Map<String, String>> listReceiver = receivers.getReceiverList();

      /**
       * *  Build the responses for letter and email
       */
      ProcessTemplate processTemplate = new ProcessTemplate();
      if(parser.getEmailRequired() != null && parser.getEmailRequired()){  // for emails
        StringBuilder templateStringEmail = processTemplate.stringTemplate(parser.getEmailTemplatePath());
        String outputFolderEmail = "emails_" + parser.getOutputDirectoryPath();
        processTemplate.writeTemplate(templateStringEmail,listReceiver, outputFolderEmail);
      }

      if(parser.getLetterRequired() != null && parser.getLetterRequired()){  // for letters
        StringBuilder templateStringLetter = processTemplate.stringTemplate(parser.getLetterTemplatePath());
        String outputFolderLetter = "letters_" + parser.getOutputDirectoryPath() ;
        processTemplate.writeTemplate(templateStringLetter,listReceiver, outputFolderLetter);
      }

    }catch(InvalidArgumentsException e) {
      e.printStackTrace();
    }
  }
}
