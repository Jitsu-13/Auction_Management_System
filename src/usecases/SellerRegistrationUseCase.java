package usecases;

import custom.ConsoleColors;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.SellerException;
import model.Seller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SellerRegistrationUseCase {
    public static void main(String[] args) {
        SellerRegistraion();
    }

    public static void SellerRegistraion(){
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name");
            String n=sc.next();
            System.out.println("Enter Email");
            String e=sc.next();
            System.out.println("Enter Password");
            String p=sc.next();
            System.out.println("Enter Location");
            String l=sc.next();

            String result;
            SellerDao dao =new SellerDaoImpl();

            Seller seller =new Seller();

            seller.setSellerName(n);
            seller.setEmail(e);
            seller.setPassword(p);
            seller.setLocation(l);

            try {
                result=dao.RegisterSeller(seller);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            } catch (SellerException ex) {
                result=ex.getMessage();
                System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            }

        }catch (InputMismatchException i){
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
        }

    }
}
