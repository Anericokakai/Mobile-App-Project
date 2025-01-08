package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddUserRes {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Inner class for User
    public static class User {
        @SerializedName("userName")
        @Expose
        private String userName;

        @SerializedName("userEmail")
        @Expose
        private String userEmail;

        @SerializedName("user_adress")
        @Expose
        private List<Object> userAdress;

        @SerializedName("password")
        @Expose
        private String password;

        @SerializedName("_id")
        @Expose
        private String id;

        @SerializedName("__v")
        @Expose
        private Integer v;

        // Getters and Setters
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public List<Object> getUserAdress() {
            return userAdress;
        }

        public void setUserAdress(List<Object> userAdress) {
            this.userAdress = userAdress;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }
    }
}
