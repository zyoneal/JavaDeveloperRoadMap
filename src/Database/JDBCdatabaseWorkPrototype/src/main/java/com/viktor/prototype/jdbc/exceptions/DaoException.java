package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions;

public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
