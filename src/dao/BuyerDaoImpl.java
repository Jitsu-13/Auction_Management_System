package dao;

import exception.ByerException;
import model.Buyer;
import utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerDaoImpl implements BuyerDao {
    @Override
    public Buyer BuyerLogin(String email, String password) throws ByerException {
        Buyer buyer=null;

        try(Connection conn=DBUtility.provideConnection()){

            PreparedStatement ps=conn.prepareStatement("Select * from buyer where email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                buyer =new Buyer();
                buyer.setBuyerId(rs.getInt("buyerID"));
                buyer.setBuyerName(rs.getString("buyerName"));
                buyer.setEmail(rs.getString("email"));
                buyer.setPassword(rs.getString("password"));
                buyer.setLocation(rs.getString("location"));

            }else{
                throw new ByerException("Invalid email/password");
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new ByerException(e.getMessage());

        }


        return buyer;
    }

    //==========================================*****************===================================================//

    @Override
    public String RegisterBuyer(Buyer buyer) throws ByerException {
        String result="Not Registered-Bad Details (Enter Unique Email)";

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("insert into buyer (buyerName,email,password,location) values (?,?,?,?)");

            ps.setString(1, buyer.getBuyerName());
            ps.setString(2, buyer.getEmail());
            ps.setString(3, buyer.getPassword());
            ps.setString(4, buyer.getLocation());

           int x= ps.executeUpdate();
           if(x>0){
               result="Registered Successfully";
           }else{
               throw new ByerException(result);
           }

        }catch (SQLException e){
            e.printStackTrace();
            throw new ByerException(e.getMessage());
        }

        return result;
    }

    //==========================================*****************===================================================//

}
