package dao;

import exception.AdminException;
import exception.CredentialException;
import model.BuyerDTO;
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

    //=================================**************************====================================================/
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
}
