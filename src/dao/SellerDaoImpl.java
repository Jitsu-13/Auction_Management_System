package dao;

import exception.SellerException;
import model.Seller;
import utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDaoImpl implements SellerDao{
    @Override
    public Seller SellerLogin(String email, String password) throws SellerException {
        Seller seller=null;

        try(Connection conn= DBUtility.provideConnection()){

            PreparedStatement ps=conn.prepareStatement("Select * from seller where email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                seller =new Seller();
                seller.setSellerId(rs.getInt("sellerID"));
                seller.setSellerName(rs.getString("sellerName"));
                seller.setEmail(rs.getString("email"));
                seller.setPassword(rs.getString("password"));
                seller.setLocation(rs.getString("location"));

            }else{
                throw new SellerException("Invalid email/password");
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());

        }


        return seller;
    }

    //===================================================*****************===================================================================================/

    @Override
    public String RegisterSeller(Seller seller) throws SellerException {

        String result="Not Registered-Bad Details (Enter Unique Email)";

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("insert into seller (sellerName,email,password,location) values (?,?,?,?)");

            ps.setString(1, seller.getSellerName());
            ps.setString(2, seller.getEmail());
            ps.setString(3, seller.getPassword());
            ps.setString(4, seller.getLocation());

            int x= ps.executeUpdate();
            if(x>0){
                result="Registered Successfully";
            }else{
                throw new SellerException(result);
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
    }

}
