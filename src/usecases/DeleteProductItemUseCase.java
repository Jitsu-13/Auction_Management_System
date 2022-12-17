package usecases;

import custom.ConsoleColors;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.SellerException;

import java.util.Scanner;

public class DeleteProductItemUseCase {
    public static void main(String[] args) {
        deleteProductitem();
    }

    public static void deleteProductitem(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to delete");
        int productId=sc.nextInt();

        String result;
        SellerDao dao=new SellerDaoImpl();
        try {
            result= dao.DeleteProductItems(productId);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        } catch (SellerException e) {
            result=e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        }

    }
}
