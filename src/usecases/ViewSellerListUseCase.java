package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import exception.AdminException;
import model.SellerDTO;

import java.util.List;

public class ViewSellerListUseCase {
    public static void main(String[] args) {
        viewSellerList();
    }
    public static void viewSellerList(){
        AdminDao dao=new AdminDaoImpl();
        try {
            List<SellerDTO> list=dao.ViewSellers();
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Sellers" + ConsoleColors.RESET+ "---------------------------");

            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf("%7s %12s %10s %25s",ConsoleColors.BLACK_BOLD + "SellerId", "SellerName","Email", "Location" + ConsoleColors.RESET);
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %14s %20s %13s",li.getSellerId(),li.getSellerName(),li.getEmail(),li.getLocation());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
