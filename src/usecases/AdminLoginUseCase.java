package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import exception.CredentialException;

import java.util.Scanner;

public class AdminLoginUseCase {

    public static boolean adminLogin(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        AdminDao dao=new AdminDaoImpl();
        try {
            result=dao.AdminLogin(email,password);
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            return true;
        } catch (CredentialException e) {
            result = e.getMessage();
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
            return false;
        }

    }
}
