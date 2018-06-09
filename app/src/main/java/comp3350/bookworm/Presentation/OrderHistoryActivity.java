package comp3350.bookworm.Presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        try {
            // Construct the data source
            ArrayList<Book> books = Service.getOrderHistoryStub().getOrderHistoryCurrentUser();
            // Create the adapter to convert the array to views
            BookArrayAdapter bookArrayAdapter = new BookArrayAdapter(this, books);
            // Attach the adapter to a ListView
            ListView listView = (ListView) findViewById(R.id.bookList_orderhistory);
            listView.setAdapter(bookArrayAdapter);
        }
        catch (InvalidAccountException e) {
            int duration = Toast.LENGTH_LONG;
            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context, R.string.InvalidUsername, duration);
            toast.show();
        }
    }
}
