package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.SellerDao;
import dao.SellerDaoImpl;
import exception.AdminException;
import exception.SellerException;

import java.util.Scanner;

public class ResolveDisputeUseCase {
    public static void main(String[] args) {
        disputeResolve();
    }

    public static void disputeResolve(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to solve dispute of");
        int productId=sc.nextInt();
        System.out.println("Enter the correct category Id from the below table- \n"+
                "|       1001 | Bikes        |\n" +
                "|       1002 | Cars         |\n" +
                "|       1003 | Watches      |\n" +
                "|       1004 | Shoes        |\n" +
                "|       1005 | Jewellery    |\n" +
                "|       1006 | Paintings    |\n" +
                "|       1007 | Alcohols     |\n" +
                "|       1008 | Swords      |\n"+
                "------------------------------------------");
        int categoryId=sc.nextInt();

        String result;
        AdminDao dao=new AdminDaoImpl();
        try {
            result= dao.SolveDispute(categoryId, productId);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        } catch (AdminException e) {
            result=e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
        }

    }
}
