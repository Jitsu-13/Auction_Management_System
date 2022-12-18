package dao;


import exception.AdminException;
import exception.CredentialException;
import model.BuyerDTO;
import model.Products;
import model.SearchBuyerDTO;
import model.SellerDTO;


import java.util.List;

public interface AdminDao {
    public final String email="admin";
    public final String password="admin";

    public String AdminLogin(String email,String password) throws CredentialException;

    public List<BuyerDTO> ViewBuyers() throws AdminException;

    public List<SellerDTO> ViewSellers() throws AdminException;

    public List<SearchBuyerDTO>DailySellingReport(String date) throws AdminException;

    public List<Products> DailyDisputeReport(String date) throws AdminException;
}
