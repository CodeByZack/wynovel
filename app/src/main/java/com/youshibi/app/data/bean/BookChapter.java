package com.youshibi.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * author : zchu
 * date   : 2017/9/20
 * desc   :
 */

public class BookChapter implements Parcelable {

    /**
     * chapter_id : d6771dd9-05da-4aa6-9344-0017ee8623cf
     * chapter_index : 3127
     * chapter_name : 第3119章 岂不是又纠缠不清了？
     * create_time : 2017-04-02T10:51:45.367
     */

    @SerializedName("id")
    private String chapterId;

    @SerializedName("chapter_index")
    private int chapterIndex;

    @SerializedName("title")
    private String chapterName;

    @SerializedName("update_time")
    private long createTime;

    protected BookChapter(Parcel in) {
        chapterId = in.readString();
        chapterIndex = in.readInt();
        chapterName = in.readString();
        createTime = in.readLong();
    }

    public static final Creator<BookChapter> CREATOR = new Creator<BookChapter>() {
        @Override
        public BookChapter createFromParcel(Parcel in) {
            return new BookChapter(in);
        }

        @Override
        public BookChapter[] newArray(int size) {
            return new BookChapter[size];
        }
    };

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(chapterId);
        parcel.writeInt(chapterIndex);
        parcel.writeString(chapterName);
        parcel.writeLong(createTime);
    }
}
