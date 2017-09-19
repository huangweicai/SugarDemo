package com.hwc.sugar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hwc.sugar.bean.Book;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_add_record;
    private TextView tv_delete_record;
    private TextView tv_alter_record;
    private TextView tv_query_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_add_record = (TextView) findViewById(R.id.tv_add_record);
        tv_delete_record = (TextView) findViewById(R.id.tv_delete_record);
        tv_alter_record = (TextView) findViewById(R.id.tv_alter_record);
        tv_query_record = (TextView) findViewById(R.id.tv_query_record);
        tv_add_record.setOnClickListener(this);
        tv_delete_record.setOnClickListener(this);
        tv_alter_record.setOnClickListener(this);
        tv_query_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Book book = null;
        switch (view.getId()) {
            case R.id.tv_add_record:
                //单条插入
                book = new Book("isbn123", "Title here", "2nd edition");
                book.save();
                //SugarRecord.save(book); // if using the @Table annotation


                //批量插入
//                List<Book> books = new ArrayList<>();
//                books.add(new Book("isbn123", "Title here", "2nd edition"))
//                books.add(new Book("isbn456", "Title here 2", "3nd edition"))
//                books.add(new Book("isbn789", "Title here 3", "4nd edition"))
//                SugarRecord.saveInTx(books);
                break;
            case R.id.tv_delete_record:
                //根据id查询
                book = Book.findById(Book.class, 1);
                book.delete();

                //批量删除
                //List<Book> books = Book.listAll(Book.class);
                //Book.deleteAll(Book.class);
                break;
            case R.id.tv_alter_record:
                book = Book.findById(Book.class, 1);
                book.title = "updated title here"; // modify the values
                book.edition = "3rd edition";
                book.save(); // updates the previous entry with new values.
                break;
            case R.id.tv_query_record:
                //book = Book.findById(Book.class, 1);
                //Log.d("TAG", "bookToString:" + (null == book ? "book表为null" : book.toString()));

                //指定条件查询，批量回来
                //List<Book> books = Book.find(Book.class, "title = ? and edition = ?", "Title here", "2nd edition");
                //Log.d("TAG", "bookToString:" + (null == books ? "books表为null" : books.toString()));

                //查询表中所有记录

                break;
        }
    }
}
