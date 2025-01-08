package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Shoes  implements Serializable {

    @SerializedName("_id")
    private String id;

    @SerializedName("shoe_name")
    private String shoeName;

    @SerializedName("shoe_Description")
    private String shoeDescription;

    @SerializedName("price")
    private String price;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("purchases")
    private int purchases;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("color")
    private String color;

    @SerializedName("amount")
    private int amount;

    @SerializedName("inStock")
    private int inStock;

    @SerializedName("categoryId")
    private String categoryId;

    // Constructor
    public Shoes(String id, String shoeName, String shoeDescription, String price, List<String> images,
                int purchases, List<String> tags, String color, int amount, int inStock, String categoryId) {
        this.id = id;
        this.shoeName = shoeName;
        this.shoeDescription = shoeDescription;
        this.price = price;
        this.images = images;
        this.purchases = purchases;
        this.tags = tags;
        this.color = color;
        this.amount = amount;
        this.inStock = inStock;
        this.categoryId = categoryId;
    }

    // Default Constructor
    public Shoes() {}

    public Shoes(String shoeName, String shoeDescription, String price, List<String> images, String purchases, List<String> tags, String color, int amount, int inStock, String categoryId) {
    }


    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeDescription() {
        return shoeDescription;
    }

    public void setShoeDescription(String shoeDescription) {
        this.shoeDescription = shoeDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id='" + id + '\'' +
                ", shoeName='" + shoeName + '\'' +
                ", shoeDescription='" + shoeDescription + '\'' +
                ", price='" + price + '\'' +
                ", images=" + images +
                ", purchases=" + purchases +
                ", tags=" + tags +
                ", color='" + color + '\'' +
                ", amount=" + amount +
                ", inStock=" + inStock +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}

