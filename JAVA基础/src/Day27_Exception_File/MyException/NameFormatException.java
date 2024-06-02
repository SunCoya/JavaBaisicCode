package Day27_Exception_File.MyException;
//编译异常继承Exception，运行异常就继承RuntimeException
public class NameFormatException extends RuntimeException{
    public NameFormatException() {
    }
    public NameFormatException(String message) {
        super(message);
    }
}
