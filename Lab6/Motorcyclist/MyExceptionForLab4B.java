package Motorcyclist;
import java.io.Serializable;

public class MyExceptionForLab4B extends Exception implements Serializable {
    public MyExceptionForLab4B() { }
    public MyExceptionForLab4B(String message)
    {
        super(message);
    }
    public MyExceptionForLab4B(String message, Throwable cause)
    {
        super(message, cause);
    }
    public MyExceptionForLab4B(Throwable cause)
    {
        super(cause);
    }
}
