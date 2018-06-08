package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.BusinessLogic.BookAdapter;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class HomePage extends AppCompatActivity {

//    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_library:
//                    mTextMessage.setText(R.string.title_bookshelf);
                    return true;
                case R.id.navigation_discover:
//                    mTextMessage.setText(R.string.title_account);
                    return true;
                case R.id.navigation_account:
//                    mTextMessage.setText(R.string.title_shoppingcart);
                    startActivity(new Intent(HomePage.this, AccountActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        mTextMessage = (TextView) findViewById(R.id.home_page_message);
        //ListViewAdapter viewAdapter;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.home_page_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final SearchView searchView = (SearchView) findViewById(R.id.Search_bar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchView.clearFocus();
            }
        }, 300);
        //searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        // perform set on query text listener event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //ArrayList<Book> similarBooks = (ArrayList<Book>) Service.getBookListStub().getSimilarBooks(query);
                //BookAdapter bookAdapter = new BookAdapter(this, similarBooks);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Book> similarBooks = (ArrayList<Book>) Service.getBookListStub().getSimilarBooks(newText);
                ListView similarBookList = (ListView) findViewById(R.id.bookList);
                //BookAdapter similarBookAdapter = new BookAdapter(comp3350.bookworm.Presentation.HomePage, similarBooks);
                return false;
            }
        });
        // Construct the data source
        ArrayList<Book> books = Service.getBookListStub().getBookList();
        // Create the adapter to convert the array to views
        BookAdapter bookAdapter = new BookAdapter(this, books);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.bookList);
        listView.setAdapter(bookAdapter);

    }

}
