package com.youshibi.app.presentation.book;

import android.view.View;

import com.youshibi.app.AppRouter;
import com.youshibi.app.R;
import com.youshibi.app.base.BaseRxPresenter;
import com.youshibi.app.data.DataManager;
import com.youshibi.app.data.bean.Book;
import com.youshibi.app.data.bean.BookChapter;
import com.youshibi.app.data.bean.BookSectionItem;
import com.youshibi.app.rx.SimpleSubscriber;
import com.youshibi.app.ui.help.CommonAdapter;
import com.youshibi.app.ui.help.CommonViewHolder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author : zchu
 * date   : 2017/9/19
 * desc   :
 */

public class BookCatalogPresenter extends BaseRxPresenter<BookCatalogContract.View> implements BookCatalogContract.Presenter {

    private static final int PAGE_SIZE = 50;

    private Book mBook;
    private int mSectionCount;
    private ArrayList<BookChapter> mBookChapters;

    private CommonAdapter<BookSectionItem> bookSectionAdapter;
    private List<String> sectionData;

    public BookCatalogPresenter(Book book, int sectionCount,ArrayList<BookChapter> bookChapters) {
        this.mBook = book;
        this.mSectionCount = sectionCount;
        this.mBookChapters = bookChapters;
    }

    @Override
    public void start() {
        super.start();
        if (bookSectionAdapter == null) {
            loadData(1);
        } else {
            getView().setListAdapter(bookSectionAdapter);
        }
        if (sectionData == null) {
            sectionData = createSectionData(mSectionCount);
        }
        getView().setSectionData(sectionData);
    }

    @Override
    public void loadData(int page) {
        List<BookSectionItem> datas = new LinkedList<>();
        for (BookChapter chapter : mBookChapters){
            BookSectionItem item = new BookSectionItem();
            item.setSectionName(chapter.getChapterName());
            item.setSectionId(chapter.getChapterId());
            item.setSectionIndex(datas.size());
            datas.add(item);
        }
        setData(datas);
    }

    private void setData(List<BookSectionItem> bookSectionItems) {
        if (bookSectionAdapter == null) {
            bookSectionAdapter = new CommonAdapter<BookSectionItem>(R.layout.list_item_book_section, bookSectionItems) {
                @Override
                protected void convert(CommonViewHolder helper, final BookSectionItem item) {
                    helper.setText(R.id.tv_section_name, item.getSectionName());
                    helper.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             AppRouter.showReadActivity(v.getContext(), mBook, item.getSectionIndex(), item.getSectionId(),mBookChapters);
                        }
                    });
                }
            };
            getView().setListAdapter(bookSectionAdapter);
        }
        bookSectionAdapter.setNewData(bookSectionItems);
    }

    private List<String> createSectionData(int sectionCount) {
        ArrayList<String> sectionTitles = new ArrayList<>();

        int size = sectionCount / PAGE_SIZE;
        for (int i = 0; i < size; i++) {
            sectionTitles.add(i * PAGE_SIZE + 1 + "-" + ((1 + i) * PAGE_SIZE) + "章");
        }
        if (PAGE_SIZE * size < sectionCount) {
            sectionTitles.add(1 + size * PAGE_SIZE + "-" + sectionCount + "章");
        }
        return sectionTitles;
    }

}
