package com.hwc.sugar.bean;


import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * 时间：2017/9/19
 * 作者：黄伟才
 * 简书：http://www.jianshu.com/p/87e7392a16ff
 * github：https://github.com/huangweicai/OkLibDemo
 * 描述：
 */

public class Book extends SugarRecord {
    @Unique
    public String isbn;
    public String title;
    public String edition;

    // Default constructor is necessary for SugarRecord
    public Book() {

    }

    public Book(String isbn, String title, String edition) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
