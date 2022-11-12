package models.components;

public class ExternalLoginPage extends LoginPage{

    @Override
    protected String userName() {
        System.out.println("Input username with External Login Page");
        return null;
    }

    @Override
    protected String password() {
        System.out.println("Input password with External Login Page");
        return null;
    }

    @Override
    protected String loginBtn() {
        System.out.println("Click button Login with External Login Page");
        return null;
    }
}