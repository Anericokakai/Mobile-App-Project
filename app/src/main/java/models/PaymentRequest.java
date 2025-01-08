package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentRequest {
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    @SerializedName("Amount")
    @Expose
    private String amount;

    // Constructor
    public PaymentRequest(String phoneNumber, String amount) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
