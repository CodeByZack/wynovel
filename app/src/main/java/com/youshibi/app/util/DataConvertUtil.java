package com.youshibi.app.util;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.youshibi.app.data.bean.Book;
import com.youshibi.app.data.bean.BookSectionItem;
import com.youshibi.app.data.db.table.BookTb;

import java.util.ArrayList;

/**
 * Created by Chu on 2017/5/29.
 */

public class DataConvertUtil {

    public static BookTb book2BookTb(Book book, ArrayList<BookSectionItem> bookSectionItems, @Nullable BookTb bookTb) {
        if (bookTb == null) {
            bookTb = new BookTb();
        }
        bookTb.setId(book.getSourceId());
        bookTb.setAuthor(book.getAuthor());
        bookTb.setCoverUrl(book.getCoverUrl());
        bookTb.setDescribe(book.getDescribe());
        bookTb.setIsFinished(book.isFinished());
        bookTb.setName(book.getName());
        bookTb.setSectionCount(book.getChapterCount());
        bookTb.setChaptersJson(new Gson().toJson(bookSectionItems));
        return bookTb;
    }

    public static Book bookTb2Book(BookTb bookTb) {
        Book book = new Book();
        book.setId(bookTb.getId());
        book.setAuthor(bookTb.getAuthor());
        book.setCoverUrl(bookTb.getCoverUrl());
        book.setDescribe(bookTb.getDescribe());
        book.setFinished(bookTb.getIsFinished());
        book.setChapterCount(bookTb.getSectionCount());
        book.setName(bookTb.getName());
        return book;
    }
}
