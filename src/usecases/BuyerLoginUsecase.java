package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.ByerException;
import model.Buyer;

import java.util.Scanner;

public class BuyerLoginUsecase {
    public static void main(String[] args) {
        boolean result=BuyerLogin();
    }
    public static boolean BuyerLogin() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        BuyerDao blogindao =new BuyerDaoImpl();
        try {
            Buyer buyer=blogindao.BuyerLogin(email,password);
            int buyerId=buyer.getBuyerId();
            String buyerName=buyer.getBuyerName();
            String buyerEmail=buyer.getEmail();
            String buyerPassword=buyer.getPassword();
            String buyerLocation=buyer.getLocation();
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT +"Welcome to Buyer Dashboard- "+buyerName + ConsoleColors.RESET);
            return true;

        } catch (ByerException e) {
            result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
        }
    }

}
