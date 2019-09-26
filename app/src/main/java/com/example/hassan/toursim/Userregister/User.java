
package com.example.hassan.toursim.Userregister;


import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("about")
    private Object mAbout;
    @SerializedName("address")
    private Object mAddress;
    @SerializedName("avatar")
    private Object mAvatar;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private Object mPhone;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public Object getAbout() {
        return mAbout;
    }

    public void setAbout(Object about) {
        mAbout = about;
    }

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public Object getAvatar() {
        return mAvatar;
    }

    public void setAvatar(Object avatar) {
        mAvatar = avatar;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Object getPhone() {
        return mPhone;
    }

    public void setPhone(Object phone) {
        mPhone = phone;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
