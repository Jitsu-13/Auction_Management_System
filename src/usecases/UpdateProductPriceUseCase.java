package usecases;

import custom.ConsoleColors;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.SellerException;

import java.util.Scanner;

public class UpdateProductPriceUseCase {
    public static void main(String[] args) {
        updateProductlist();
    }

    public static void updateProductlist(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to update");
        int productId=sc.nextInt();
        System.out.println("Enter the updated Price");
        int price=sc.nextInt();

        String result;
        SellerDao dao=new SellerDaoImpl();
        try {
            result=dao.UpdateProductPrice(productId,price);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        } catch (SellerException e) {
            result=e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        }

    }
}
