package main;

import usecases.CreateProductListUseCase;
import usecases.SellerLoginUseCase;
import usecases.SellerRegistrationUseCase;
import usecases.UpdateProductPriceUseCase;

public class SellerMain {
    public static boolean BuyerLogin(){
        SellerLoginUseCase login=new SellerLoginUseCase();
        boolean result=login.SellerLogin();
        return result;
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
}
