package usecases;

import custom.ConsoleColors;
import dao.BuyerDao;
import dao.BuyerDaoImpl;
import exception.ByerException;
import model.Buyer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyerRegistrationUseCase {
    public static void main(String[] args) {
        BuyerRegistraion();
    }

    public static void BuyerRegistraion(){
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
            BuyerDao dao =new BuyerDaoImpl();

            Buyer buyer =new Buyer();

            buyer.setBuyerName(n);
            buyer.setEmail(e);
            buyer.setPassword(p);
            buyer.setLocation(l);

            try {
                result=dao.RegisterBuyer(buyer);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            } catch (ByerException ex) {
                result=ex.getMessage();
                System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            }

        }catch (InputMismatchException i){
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
        }

    }
}
