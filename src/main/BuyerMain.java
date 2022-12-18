package main;

import custom.ConsoleColors;
import usecases.*;

public class BuyerMain {

    public static boolean BuyerLogin(){
        BuyerLoginUsecase login=new BuyerLoginUsecase();
        boolean result=login.BuyerLogin();
        return result;
    }
    public static void BuyerHomeWindow() {
//        System.out.println(ConsoleColors.BROWN_BACKGROUND+ ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Buyer Home Window : "+ ConsoleColors.RESET);
        System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Search and view Items by category" + ConsoleColors.RESET);
        System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Selects Items to buy" + ConsoleColors.RESET);
        System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Select and view all the buyers and also their Items category wise" + ConsoleColors.RESET);
        System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
    }
    public static void BuyerRegistration(){
        BuyerRegistrationUseCase register=new BuyerRegistrationUseCase();
        register.BuyerRegistraion();
    }
    public static void SearchItemCategory(){
        SearchItembyCategoryListUseCase searchItembyCategoryListUseCase=new SearchItembyCategoryListUseCase();
        searchItembyCategoryListUseCase.searchItemCategory();
    }
    public static void BuyItem(){
        BuyItemUseCase buyItemUseCase=new BuyItemUseCase();
        buyItemUseCase.buyitem();
    }
    public static void BuyerByCategory(){
        SearchBuyerbyCategoryNameUseCase searchBuyerbyCategoryNameUseCase=new SearchBuyerbyCategoryNameUseCase();
        searchBuyerbyCategoryNameUseCase.searchBuyerItembyCategory();
    }
}
