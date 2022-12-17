package main;

import usecases.BuyerLoginUsecase;
import usecases.BuyerRegistrationUseCase;
import usecases.SearchItembyCategoryListUseCase;

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
    public void SearchItemCategory(){
        SearchItembyCategoryListUseCase searchItembyCategoryListUseCase=new SearchItembyCategoryListUseCase();
        searchItembyCategoryListUseCase.searchItemCategory();
    }
}
