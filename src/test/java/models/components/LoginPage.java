package models.components;

public abstract class LoginPage {

    protected abstract String userName();
    protected abstract String password();
    protected abstract String loginBtn();

    public void login(){
        System.out.println(userName());
        System.out.println(password());
        System.out.println(loginBtn());
    }

    public void verifyLoginSuccess(){
        System.out.println("Verifying Dashboard display");
    }

}
