package main;

import usecases.SellerLoginUseCase;
import usecases.SellerRegistrationUseCase;

public class SellerMain {
    public static boolean BuyerLogin(){
        SellerLoginUseCase login=new SellerLoginUseCase();
        boolean result=login.SellerLogin();
        return result;
    }
    public void SellerRegistration(){
        SellerRegistrationUseCase register=new SellerRegistrationUseCase();
        register.SellerRegistraion();
    }
}
