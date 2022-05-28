package view;

import javax.swing.*;

public interface ILoginView {

    JButton getSignInButton();
    String getUser();
    String getPassword();
    void showSuccessLogin();
    void showErrorLogin(String message);

}
