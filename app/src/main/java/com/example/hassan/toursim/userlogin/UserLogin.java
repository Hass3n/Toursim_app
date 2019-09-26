
package com.example.hassan.toursim.userlogin;


import com.google.gson.annotations.SerializedName;


public class UserLogin {

    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

}
