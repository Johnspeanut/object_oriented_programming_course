package todoApplication.control;
public class NoneIdFoundException extends Exception{

  public NoneIdFoundException(){
    super("The id does not exist.");
  }

  public NoneIdFoundException(String message){
    super(message);
  }
}