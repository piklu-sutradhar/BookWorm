package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
import android.widget.EditText;
=======
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
>>>>>>> 897e3713c345841ac0db71fd876fb72f5c98a7a8
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class HomePage extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_library:
                    startActivity(new Intent(HomePage.this, LibraryActivity.class));
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
//        mTextMessage = (TextView) findViewById(R.id.home_page_message);
        //ListViewAdapter viewAdapter;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.home_page_navigation);
        navigation.setSelectedItemId(R.id.navigation_discover);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Handle query hint
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

<<<<<<< HEAD
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Book> similarBooks = (ArrayList<Book>) Service.getBookListStub().getSimilarBooks(newText);
                //ListView similarBookList = (ListView) findViewById(R.id.bookList);
                //BookAdapter similarBookAdapter = new BookAdapter(comp3350.bookworm.Presentation.HomePage, similarBooks);
                return false;
            }
        });
        // Construct the data source
        ArrayList<Book> books = Service.getBookListStub().getBookList();
        // Create the adapter to convert the array to views
        BookAdapter bookAdapter = new BookAdapter(this, books);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.bookList_homepage);
        listView.setAdapter(bookAdapter);
=======
        // Construct ArrayAdapter for best-seller
        final BookArrayAdapter bestsellerBookArrayAdapter = new BookArrayAdapter(this, Service.getBookListStub().getBestSellerList());
>>>>>>> 897e3713c345841ac0db71fd876fb72f5c98a7a8

        // TODO: change ArrayList to real data
        final BookArrayAdapter suggestionBookArrayAdapter = new BookArrayAdapter(this, new ArrayList<Book>());
        final ListView listView = (ListView) findViewById(R.id.bookList_homepage);
        listView.setAdapter(bestsellerBookArrayAdapter);

        // Construct spinner to switch between bestseller and suggestions
        final ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.best_seller));
        options.add(getString(R.string.best_choice));

        Spinner spinner = (Spinner) findViewById(R.id.discover_spinner);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,options));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomePage.this, options.get(position), Toast.LENGTH_SHORT).show();
                switch (options.get(position)) {
                    case "Best-seller":
                        listView.setAdapter(bestsellerBookArrayAdapter);
                        break;
                    case "Best choice":
                        listView.setAdapter(suggestionBookArrayAdapter);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
