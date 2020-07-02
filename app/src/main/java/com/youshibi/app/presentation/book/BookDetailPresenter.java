package com.youshibi.app.presentation.book;

import android.content.Context;
import android.view.View;

import com.youshibi.app.AppRouter;
import com.youshibi.app.R;
import com.youshibi.app.base.BaseRxPresenter;
import com.youshibi.app.data.DataManager;
import com.youshibi.app.data.bean.Book;
import com.youshibi.app.data.bean.BookDetail;
import com.youshibi.app.data.bean.BookSectionItem;
import com.youshibi.app.data.bean.DataList;
import com.youshibi.app.rx.SimpleSubscriber;
import com.youshibi.app.ui.help.CommonAdapter;
import com.youshibi.app.ui.help.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Chu on 2017/5/28.
 */

public class BookDetailPresenter extends BaseRxPresenter<BookDetailContract.View> implements BookDetailContract.Presenter {

    private String bookId;
    private Book book;

    public BookDetailPresenter(String bookId) {
        this.bookId = bookId;
    }


    @Override
    public void loadData() {
        if (isViewAttached()) {
            getView().showLoading();
        }

        DataManager
                .getInstance()
                .getBookDetail(bookId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleSubscriber<Book>() {
                    @Override
                    public void onNext(Book bookDetail) {
                        if (isViewAttached()) {
                            book = bookDetail;
                            getView().setData(bookDetail);
                            getView().showContent();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (isViewAttached()) {
                            getView().showError(e.getMessage());
                        }
                    }
                });

//        loadRecommendBooks();
    }

//    private void loadRecommendBooks() {
//        Subscription subscribe = DataManager
//                .getInstance()
//                .getBookList(bookId, new Random().nextInt(10)+1, 6)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SimpleSubscriber<DataList<Book>>() {
//                    @Override
//                    public void onNext(DataList<Book> bookDataList) {
//                        if (isViewAttached()) {
//                            getView().setRecommendBooks(bookDataList.DataList);
//                        }
//                    }
//                });
//        addSubscription2Destroy(subscribe);
//    }


    @Override
    public void openRead(Context context) {
        ArrayList<BookSectionItem> bookSectionItems = new ArrayList<>();
        for (BookSectionItem sectionItem : book.getChapter().values()){
            bookSectionItems.add(sectionItem);
        }
        AppRouter.showReadActivity(context, book, 0, bookSectionItems.get(0).getSectionId(),bookSectionItems);
    }

}
