
package com.example.hassan.toursim.Userregister;


import com.google.gson.annotations.SerializedName;


public class UserRegister {

    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

}
