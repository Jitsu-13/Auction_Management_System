package usecases;

import custom.ConsoleColors;
import dao.AdminDao;
import dao.AdminDaoImpl;
import exception.AdminException;
import model.BuyerDTO;

import java.util.List;

public class ViewBuyerListUseCase {
    public static void main(String[] args) {
        viewBuyerList();
    }
    public static void viewBuyerList(){
        AdminDao dao=new AdminDaoImpl();
        try {
            List<BuyerDTO> list=dao.ViewBuyers();
            System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Buyers" + ConsoleColors.RESET+ "---------------------------");

            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf("%7s %12s %10s %25s",ConsoleColors.BLACK_BOLD + "BuyerId", "BuyerName","Email", "Location" + ConsoleColors.RESET);
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %14s %20s %13s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getLocation());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
