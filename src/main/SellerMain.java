package main;

import custom.ConsoleColors;
import usecases.*;

public class SellerMain {

    public static boolean SellerLogin(){
        SellerLoginUseCase login=new SellerLoginUseCase();
        boolean result=login.SellerLogin();
        return result;
    }
    public static void SellerHomeWindow() {
//        System.out.println(ConsoleColors.BROWN_BACKGROUND+ ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Seller Home Window : "+ ConsoleColors.RESET);
        System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create list of items to sell" + ConsoleColors.RESET);
        System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Update Item price" + ConsoleColors.RESET);
        System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Remove items from the list" + ConsoleColors.RESET);
        System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View the sold Item history" + ConsoleColors.RESET);
        System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
    }
    public static void SellerRegistration(){
        SellerRegistrationUseCase register=new SellerRegistrationUseCase();
        register.SellerRegistraion();
    }
    public static void createListofProducts(){
        CreateProductListUseCase createProductListUseCase=new CreateProductListUseCase();
        createProductListUseCase.createProductList();
    }
    public static void updateProductList(){
        UpdateProductPriceUseCase updateProductPriceUseCase=new UpdateProductPriceUseCase();
        updateProductPriceUseCase.updateProductlist();
    }

    public static void deleteProductItem(){
        DeleteProductItemUseCase deleteProductItemUseCase=new DeleteProductItemUseCase();
        deleteProductItemUseCase.deleteProductitem();
    }
    public static void soldItemHistory(){
        SoldItemHistoryListUseCase soldItemHistoryListUseCase=new SoldItemHistoryListUseCase();
        soldItemHistoryListUseCase.soldItemHistory();
    }

}
