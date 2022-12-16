package main;

import usecases.BuyerLoginUsecase;
import usecases.BuyerRegistrationUseCase;

public class BuyerMain {

    public static boolean BuyerLogin(){
        BuyerLoginUsecase login=new BuyerLoginUsecase();
        boolean result=login.BuyerLogin();
        return result;
    }
    public void BuyerRegistration(){
        BuyerRegistrationUseCase register=new BuyerRegistrationUseCase();
        register.BuyerRegistraion();
    }
}
