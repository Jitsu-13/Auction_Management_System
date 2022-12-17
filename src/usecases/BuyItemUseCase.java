package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.ByerException;
import exception.SellerException;

import java.util.Scanner;

public class BuyItemUseCase {
    public static void main(String[] args) {
        buyitem();
    }

    public static void buyitem(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your BuyerId");
        int buyerId=sc.nextInt();
        System.out.println("Enter productName you want to buy");
        String productName=sc.next();

        String result;
        BuyerDao dao=new BuyerDaoImpl();
        try {
            result= dao.BuyItem(buyerId,productName);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        } catch (ByerException e) {
            result=e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        }

    }
}
