package model;

public class SearchBuyerDTO {
    private int buyerId;
    private String buyerName;
    private String email;
    private String productName;
    private int sellerId;
    private String sellerName;
    private String categoryName;
    private int categoryId;
    private int price;

    public SearchBuyerDTO() {
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchBuyerDTO{" +
                "buyerId=" + buyerId +
                ", buyerName='" + buyerName + '\'' +
                ", email='" + email + '\'' +
                ", productName='" + productName + '\'' +
                ", sellerId=" + sellerId +
                ", categoryId=" + categoryId +
                ", price=" + price +
                '}';
    }
}
