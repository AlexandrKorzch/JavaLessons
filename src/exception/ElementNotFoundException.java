package exception;

public class ElementNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Sorry but element hasn't been found in array";
    }
}