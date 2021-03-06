package com.youshibi.app.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chu on 2016/12/3.
 */

public class Book implements Serializable, Parcelable {
    /**
     * BookId : 0a4d9876-fa33-4bfa-a76f-3f2833674745
     * BookName : 混沌战尊
     * BookAuthor : 作者：蓝色蝌蚪
     * BookOneType : 6
     * BookOneTypeName : 玄幻小说
     * BookIntro : 意外来到异世，获得阴阳混沌决，他需要让自己强大起来，来解开封印的功法，笑看异世风云，拥红颜知己，战天下群豪。
     * BookImg : http://pic.quanshuwu.com/files/book/1/3954/201610100732144489.jpg
     * IsFinish : true
     * BookWordNum : 3353200
     */


    @SerializedName("id")
    private String id;

    @SerializedName("pic")
    private String coverUrl;

    @SerializedName("title")
    private String name;

    @SerializedName("content")
    private String describe;

    @SerializedName("author")
    private String author;

    @SerializedName("chapter_count")
    private int chapterCount;

    @SerializedName("chapter_title")
    private String chapterName;

    @SerializedName("source_id")
    private String sourceId;



    @SerializedName("chapter")
    private Map<String,BookSectionItem> chapter;

    public Map<String, BookSectionItem> getChapter() {
        return chapter;
    }

    public void setChapter(Map<String, BookSectionItem> chapter) {
        this.chapter = chapter;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @SerializedName("category")
    private int category;

    @SerializedName("serialize")
    private int isFinished;

    @SerializedName("book_type_id")
    private int bookTypeId;

    @SerializedName("ctitle")
    private String bookTypeName;

    @SerializedName("word")
    private long bookWordNum;

    @SerializedName("hits")
    private long clickNum;

    @SerializedName("favorites")
    private long collectionNum;

    @SerializedName("recommend")
    private long recommendNum;

    @SerializedName("create_time")
    private String createDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isFinished() {
        return isFinished == 1;
    }

    public void setFinished(int finished) {
        isFinished = finished;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public long getBookWordNum() {
        return bookWordNum;
    }

    public void setBookWordNum(long bookWordNum) {
        this.bookWordNum = bookWordNum;
    }

    public long getClickNum() {
        return clickNum;
    }

    public void setClickNum(long clickNum) {
        this.clickNum = clickNum;
    }


    public long getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(long collectionNum) {
        this.collectionNum = collectionNum;
    }

    public long getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(long recommendNum) {
        this.recommendNum = recommendNum;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Book() {
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.coverUrl);
        dest.writeString(this.name);
        dest.writeString(this.describe);
        dest.writeString(this.author);
        dest.writeInt(this.isFinished);
        dest.writeInt(this.bookTypeId);
        dest.writeString(this.bookTypeName);
        dest.writeLong(this.bookWordNum);
        dest.writeLong(this.clickNum);
        dest.writeLong(this.collectionNum);
        dest.writeLong(this.recommendNum);
        dest.writeString(this.createDateTime);
        dest.writeString(this.sourceId);
    }

    protected Book(Parcel in) {
        this.id = in.readString();
        this.coverUrl = in.readString();
        this.name = in.readString();
        this.describe = in.readString();
        this.author = in.readString();
        this.isFinished = in.readInt();
        this.bookTypeId = in.readInt();
        this.bookTypeName = in.readString();
        this.bookWordNum = in.readLong();
        this.clickNum = in.readLong();
        this.collectionNum = in.readLong();
        this.recommendNum = in.readLong();
        this.createDateTime = in.readString();
        this.sourceId = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
