package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.ByerException;

import java.time.LocalDate;
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
        LocalDate date= LocalDate.now();

        String result;
        BuyerDao dao=new BuyerDaoImpl();
        try {
            result= dao.BuyItem(buyerId,date,productName);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        } catch (ByerException e) {
            result=e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        }

    }
}
