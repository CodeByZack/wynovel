package com.youshibi.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Chu on 2017/5/28.
 */

public class BookSectionItem implements Serializable, Parcelable {
    /**
     * "ChapterIndex": 2181,
     * "ChapterName": "2181.第2181章 终极神话"
     */

    @SerializedName("chapter_index")
    private int sectionIndex;

    @SerializedName("title")
    private String sectionName;

    @SerializedName("id")
    private String sectionId;

    protected BookSectionItem(Parcel in) {
        sectionIndex = in.readInt();
        sectionName = in.readString();
        sectionId = in.readString();
    }

    public BookSectionItem() {
    }

    public static final Creator<BookSectionItem> CREATOR = new Creator<BookSectionItem>() {
        @Override
        public BookSectionItem createFromParcel(Parcel in) {
            return new BookSectionItem(in);
        }

        @Override
        public BookSectionItem[] newArray(int size) {
            return new BookSectionItem[size];
        }
    };

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(sectionIndex);
        parcel.writeString(sectionName);
        parcel.writeString(sectionId);
    }
}
