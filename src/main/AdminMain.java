package main;

import usecases.*;

public class AdminMain {

    public static boolean AdminLogin(){
        AdminLoginUseCase login=new AdminLoginUseCase();
        boolean result=login.adminLogin();
        return result;
    }
    public static void viewBuyers(){
        ViewBuyerListUseCase viewBuyerListUseCase=new ViewBuyerListUseCase();
        viewBuyerListUseCase.viewBuyerList();
    }
    public static void viewSellers(){
        ViewSellerListUseCase viewSellerListUseCase=new ViewSellerListUseCase();
        viewSellerListUseCase.viewSellerList();
    }
    public static void dailySellingReport(){
        DailySellingReportUsecase dailySellingReportUsecase=new DailySellingReportUsecase();
        dailySellingReportUsecase.dailySellingReport();
    }
    public static void solveDispute(){
        ResolveDisputeUseCase resolveDisputeUseCase =new ResolveDisputeUseCase();
        resolveDisputeUseCase.disputeResolve();
    }


}
