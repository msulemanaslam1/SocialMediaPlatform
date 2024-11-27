package Controller;

import Model.Database;
import View.Alert;

import java.sql.SQLException;

public class ChangePassword {
    private String password;
    private int ID;
    private Database database;
    public ChangePassword(String password, int ID, Database database){
        this.ID = ID;
        this.password = password;
        this.database = database;
    }

    public boolean change(){
        boolean changed = false;
        String update = "UPDATE `users` SET `Password` = '"+password+"' Where `ID` = "+ID+";";
        try {
            database.getStatement().execute(update);
            changed = true;
        } catch (SQLException e){
            new Alert(e.getMessage(),null);

        }
        return changed;
    }
}
