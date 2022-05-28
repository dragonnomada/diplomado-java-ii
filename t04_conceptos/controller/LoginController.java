package controller;

import model.ILoginModel;
import view.ILoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController {

    ILoginView loginView; // -> Interfaz con el usuario
    ILoginModel loginModel; // -> Interfaz con los datos

    public LoginController(ILoginView loginView, ILoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        loginView.getSignInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = loginView.getUser();
                String password = loginView.getPassword();

                try {
                    if (loginModel.isValidUserAndPassword(user, password)) { // El modelo determinará si es válido vía base de datos
                        loginView.showSuccessLogin();
                    } else {
                        loginView.showErrorLogin("El usuario o la contraseña no son válidos");
                    }
                } catch (SQLException ex) {
                    loginView.showErrorLogin(ex.getMessage());
                }
            }
        });
    }

}
