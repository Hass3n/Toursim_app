
package com.example.hassan.toursim.Trip;


import com.google.gson.annotations.SerializedName;


public class Links {

    @SerializedName("first")
    private String mFirst;
    @SerializedName("last")
    private String mLast;
    @SerializedName("next")
    private Object mNext;
    @SerializedName("prev")
    private Object mPrev;

    public String getFirst() {
        return mFirst;
    }

    public void setFirst(String first) {
        mFirst = first;
    }

    public String getLast() {
        return mLast;
    }

    public void setLast(String last) {
        mLast = last;
    }

    public Object getNext() {
        return mNext;
    }

    public void setNext(Object next) {
        mNext = next;
    }

    public Object getPrev() {
        return mPrev;
    }

    public void setPrev(Object prev) {
        mPrev = prev;
    }

}
