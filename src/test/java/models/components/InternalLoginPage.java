package models.components;

public class InternalLoginPage extends LoginPage{


    @Override
    protected String userName() {
        System.out.println("Input username with Internal Login Page");
        return null;
    }

    @Override
    protected String password() {
        System.out.println("Input password with Internal Login Page");
        return null;
    }

    @Override
    protected String loginBtn() {
        System.out.println("Click btn Login with Internal Login Page");
        return null;
    }
}