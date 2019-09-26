
package com.example.hassan.toursim.userlogin;


import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("token")
    private String mToken;

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
