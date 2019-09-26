
package com.example.hassan.toursim.Userregister;


import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("token")
    private String mToken;
    @SerializedName("user")
    private User mUser;

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
