package exceptions;

public class AlumnoExistenteException extends Exception{
    public AlumnoExistenteException() {
    }

    public AlumnoExistenteException(String message) {
        super(message);
    }
}
