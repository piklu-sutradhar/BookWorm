package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.BookManager;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.R;

public class LibraryActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_library:
                    return true;
                case R.id.navigation_discover:
                    startActivity(new Intent( LibraryActivity.this, HomePage.class));
                    finish();
                    return true;
                case R.id.navigation_account:
                    startActivity(new Intent(LibraryActivity.this, AccountActivity.class));
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        BookManager bookManager = new BookManager();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.library_navigation);
        navigation.setSelectedItemId(R.id.navigation_library);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        LinearLayout visitorMode = (LinearLayout) findViewById(R.id.library_visitor);
        visitorMode.setVisibility(View.INVISIBLE);

        try {
            GridView gridView = (GridView) findViewById(R.id.library_gridView);
            BookGripAdapter booksAdapter = new BookGripAdapter(this, bookManager.getOrderHistoryForCurrentUser());
            gridView.setAdapter(booksAdapter);
        }
        catch (InvalidAccountException e) {
            visitorMode.setVisibility(View.VISIBLE);
        }
        catch (BookNotFoundException e) {
            GridView gridView = (GridView) findViewById(R.id.library_gridView);
            BookGripAdapter booksAdapter = new BookGripAdapter(this, new ArrayList<Book>());
            gridView.setAdapter(booksAdapter);
        }
    }
}
