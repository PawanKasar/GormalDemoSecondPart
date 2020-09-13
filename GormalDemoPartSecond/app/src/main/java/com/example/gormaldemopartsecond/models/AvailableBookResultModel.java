package com.example.gormaldemopartsecond.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableBookResultModel {

    @SerializedName("book_id")
    @Expose
    private Integer bookId;
    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("book_desc")
    @Expose
    private String bookDesc;
    @SerializedName("book_author")
    @Expose
    private String bookAuthor;
    @SerializedName("book_price")
    @Expose
    private String bookPrice;
    @SerializedName("book_img_url")
    @Expose
    private String bookImgUrl;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl;
    }
}
