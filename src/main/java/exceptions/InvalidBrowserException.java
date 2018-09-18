package exceptions;

public class InvalidBrowserException extends RuntimeException {

    public InvalidBrowserException() {
    }

    public InvalidBrowserException(String s) {
        super(s);
    }

    public InvalidBrowserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidBrowserException(Throwable throwable) {
        super(throwable);
    }

    public InvalidBrowserException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
