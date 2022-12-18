package dao;

import exception.ByerException;
import model.Buyer;
import model.SearchBuyerDTO;
import model.SoldItemsDTO;
import utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<SoldItemsDTO> searchItemByCategory(String categoryName) throws ByerException {
        List<SoldItemsDTO> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select p.productId,p.productName,s.sellerName,c.categoryName,p.price,p.status from products p " +
                    "Inner Join category c Inner Join seller s " +
                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId " +
                    "where status='available' and c.categoryName=?");

            ps.setString(1,categoryName);

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                SoldItemsDTO soldItemsDTO=new SoldItemsDTO();
                soldItemsDTO.setProductId(rs.getInt("productId"));
                soldItemsDTO.setProductName(rs.getString("productName"));
                soldItemsDTO.setSellerName(rs.getString("sellerName"));
                soldItemsDTO.setCategoryName(rs.getString("categoryName"));
                soldItemsDTO.setPrice(rs.getInt("price"));
                soldItemsDTO.setStatus(rs.getString("status"));
                list.add(soldItemsDTO);
            }
            if(list.size()==0){
                throw new ByerException("No Item found in Product List/ Category not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new ByerException(e.getMessage());
        }
        return list;
    }

    //==========================================*****************===================================================//

    @Override
    public String BuyItem(int buyerId,String productName) throws ByerException {
        String result;

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("update products set status='sold',buyerId=? where productName=?");

            ps.setInt(1, buyerId);
            ps.setString(2, productName);

            int x= ps.executeUpdate();
            if(x>0){
                result="Item Bought Successfully- Will be delivered shortly";
            }else{
                throw new ByerException("No Product found with productName- "+productName );
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new ByerException(e.getMessage());
        }

        return result;
    }

    //==========================================*****************===================================================//

    @Override
    public List<SearchBuyerDTO> ViewAllBuyersDetails(String categoryName) throws ByerException {
        List<SearchBuyerDTO> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select b.buyerId,b.buyerName,b.email,p.productName,c.categoryName,s.sellerName,p.price from products p " +
                    "Inner Join category c Inner Join seller s Inner Join buyer b " +
                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId and p.buyerId=b.buyerId " +
                    "where c.categoryName=? and status='sold'");

            ps.setString(1,categoryName);

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
                throw new ByerException("No Item found in Bought Items List/ Category not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new ByerException(e.getMessage());
        }
        return list;
    }
}
