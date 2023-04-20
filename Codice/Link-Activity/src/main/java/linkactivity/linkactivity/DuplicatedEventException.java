package linkactivity.linkactivity;

import java.io.Serial;

public class DuplicatedEventException extends Exception {
    @Serial
    private static final long serialVersionUID = -1087345248663858448L;

    public DuplicatedEventException() {

        super();

    }

    public DuplicatedEventException(String message) {

        super(message);

    }
}
