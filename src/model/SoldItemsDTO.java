package model;

public class SoldItemsDTO {
    private int productId;
    private String productName;
    private String sellerName;
    private String categoryName;
    private int price;
    private String status;

    public SoldItemsDTO() {
    }

    public SoldItemsDTO(int productId, String productName, String sellerName, String categoryName, int price, String status) {
        this.productId = productId;
        this.productName = productName;
        this.sellerName = sellerName;
        this.categoryName = categoryName;
        this.price = price;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SoldItemsDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", sellerName=" + sellerName +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
