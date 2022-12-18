package dao;

import exception.AdminException;
import exception.CredentialException;
import model.BuyerDTO;
import model.Products;
import model.SearchBuyerDTO;
import model.SellerDTO;
import utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl implements AdminDao{

    @Override
    public String AdminLogin(String email, String password) throws CredentialException {
        String result="Invalid email/password";

        if (email.equals(AdminDao.email) && password.equals(AdminDao.password)) {
            result="Welcome Admin -Login Successful";
        }else{
            throw new CredentialException(result);
        }

        return result;

    }

    //=================================**************************====================================================/

    @Override
    public List<BuyerDTO> ViewBuyers() throws AdminException {
        List<BuyerDTO> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("select * from buyer");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                BuyerDTO buyerDTO=new BuyerDTO();
                buyerDTO.setBuyerId(rs.getInt("buyerId"));
                buyerDTO.setBuyerName(rs.getString("buyerName"));
                buyerDTO.setEmail(rs.getString("email"));
                buyerDTO.setLocation(rs.getString("location"));
                list.add(buyerDTO);
            }
            if(list.size()==0){
                throw new AdminException("No data in Buyers List");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
    }

    //=================================**************************====================================================//

    @Override
    public List<SellerDTO> ViewSellers() throws AdminException {
        List<SellerDTO> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("select * from seller");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                SellerDTO sellerDTO=new SellerDTO();
                sellerDTO.setSellerId(rs.getInt("sellerId"));
                sellerDTO.setSellerName(rs.getString("sellerName"));
                sellerDTO.setEmail(rs.getString("email"));
                sellerDTO.setLocation(rs.getString("location"));
                list.add(sellerDTO);
            }
            if(list.size()==0){
                throw new AdminException("No data in Sellers List");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
    }

    //=================================**************************====================================================//

    @Override
    public List<SearchBuyerDTO> DailySellingReport(String date) throws AdminException {
        List<SearchBuyerDTO> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select b.buyerId,b.buyerName,b.email,p.productName,c.categoryName,s.sellerName,p.price from products p " +
                    "Inner Join category c Inner Join seller s Inner Join buyer b " +
                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId and p.buyerId=b.buyerId " +
                    "where p.date=?");

            ps.setString(1, String.valueOf(date));

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                SearchBuyerDTO searchBuyerDTO=new SearchBuyerDTO();
                searchBuyerDTO.setBuyerId(rs.getInt("buyerId"));
                searchBuyerDTO.setBuyerName(rs.getString("buyerName"));
                searchBuyerDTO.setEmail(rs.getString("email"));
                searchBuyerDTO.setProductName(rs.getString("productName"));
                searchBuyerDTO.setCategoryName(rs.getString("categoryName"));
                searchBuyerDTO.setSellerName(rs.getString("sellerName"));
                searchBuyerDTO.setPrice(rs.getInt("price"));
                list.add(searchBuyerDTO);
            }
            if(list.size()==0){
                throw new AdminException("No Item Sold on Date- "+date);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
    }

    //=================================**************************====================================================//

    @Override
    public List<Products> DailyDisputeReport(String date) throws AdminException {
        List<Products> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select * from products where categoryId is Null and date=?");

            ps.setString(1, String.valueOf(date));

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Products products=new Products();
                products.setProductId(rs.getInt("productId"));
                products.setProductName(rs.getString("productName"));
                products.setSellerId(rs.getInt("sellerId"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setPrice(rs.getInt("price"));
                list.add(products);
            }
            if(list.size()==0){
                throw new AdminException("No Item found n product list with Category ID as null on Date- "+date);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
    }
}
