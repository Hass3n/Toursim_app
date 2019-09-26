
package com.example.hassan.toursim.Trip;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class TripModel {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("links")
    private Links mLinks;
    @SerializedName("meta")
    private Meta mMeta;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        mLinks = links;
    }

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

}
