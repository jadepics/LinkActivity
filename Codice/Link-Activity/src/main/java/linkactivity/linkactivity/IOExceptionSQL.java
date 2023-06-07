package linkactivity.linkactivity;

import java.sql.SQLException;

public class IOExceptionSQL extends SQLException {

    public IOExceptionSQL(){
        super();
    }

    public IOExceptionSQL(String errorMessage){
        super(errorMessage);
    }

}
