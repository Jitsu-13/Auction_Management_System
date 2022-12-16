package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.ByerException;
import exception.SellerException;
import model.Buyer;
import model.Seller;

import java.util.Scanner;

public class SellerLoginUseCase {
    public static void main(String[] args) {
        boolean result=SellerLogin();
    }
    public static boolean SellerLogin() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        SellerDao slogindao =new SellerDaoImpl();
        try {
            Seller seller=slogindao.SellerLogin(email,password);
            int sellerId=seller.getSellerId();
            String sellerName=seller.getSellerName();
            String sellerEmail=seller.getEmail();
            String sellerPassword=seller.getPassword();
            String sellerLocation=seller.getLocation();
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT +"Welcome to Seller Dashboard- "+sellerName + ConsoleColors.RESET);
            return true;

        } catch (SellerException e) {
            result = e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            return false;
        }
    }
}
