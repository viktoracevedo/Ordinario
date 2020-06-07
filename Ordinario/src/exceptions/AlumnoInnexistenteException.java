package exceptions;

public class AlumnoInnexistenteException extends Exception{
    public AlumnoInnexistenteException() {
    }

    public AlumnoInnexistenteException(String message) {
        super(message);
    }
}
