package model;

import java.sql.SQLException;

public interface ILoginModel {

    boolean isValidUserAndPassword(String user, String password) throws SQLException;

}
