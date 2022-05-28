package test;

import view.AgregarProductoCLI;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class TestAgregarProductoCLI {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AgregarProductoCLI cli = new AgregarProductoCLI();

        cli.abrirMenu();
    }

}
