package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.BookAdapter;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class HomePage extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_library:
                    return true;
                case R.id.navigation_discover:
                    return true;
                case R.id.navigation_account:
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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.home_page_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final SearchView searchView = (SearchView) findViewById(R.id.Search_bar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchView.clearFocus();
            }
        }, 300);

        // Construct the data source
        ArrayList<Book> books = Service.getBookListStub().getBookList();
        // Create the adapter to convert the array to views
        BookAdapter bookAdapter = new BookAdapter(this, books);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.bookList_homepage);
        listView.setAdapter(bookAdapter);

    }

}
