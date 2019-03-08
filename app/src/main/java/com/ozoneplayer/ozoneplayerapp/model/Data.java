package com.ozoneplayer.ozoneplayerapp.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Das on 10/2/17.
 */

public class Data implements Parcelable{
    private String title;
    private String description;
    private String displayName;
    private int imageId;


    private Data(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.displayName = in.readString();
        this.imageId = in.readInt();
    }

    public Data() {
        // Normal actions performed by class, since this is still a normal object!
    }

    public Data(String title, String description, String displayName, int imageId) {
        this.title = title;
        this.description = description;
        this.displayName = displayName;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<Data> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<Data> CREATOR
            = new Parcelable.Creator<Data>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}