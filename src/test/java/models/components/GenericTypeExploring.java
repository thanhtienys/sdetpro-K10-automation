package models.components;

import java.lang.reflect.Constructor;

public class GenericTypeExploring {

//    public void login(LoginPage loginPage){
//        loginPage.login();
//        loginPage.verifyLoginSuccess();
//    }

    public <T extends LoginPage> void login(Class<T> loginPageClass){

        Class<?>[] parameters = new Class[]{};
        try {
           Constructor<T> constructor = loginPageClass.getConstructor(parameters);
           T loginPageObj = constructor.newInstance();
           loginPageObj.login();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new GenericTypeExploring().login(ExternalLoginPage.class);
        new GenericTypeExploring().login(InternalLoginPage.class);
    }

}
