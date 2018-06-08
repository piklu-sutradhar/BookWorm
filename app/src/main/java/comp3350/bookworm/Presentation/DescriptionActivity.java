package comp3350.bookworm.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class DescriptionActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Bundle extras = getIntent().getExtras();
        String bookName = "";
        if(extras != null)
            bookName = extras.getString("BookName", "C++");

//        Log.i("!!!!!!", bookName);

        Book book = Service.getBookListStub().getBook(bookName);

        final Button buttonBuy = (Button) findViewById( R.id.btn_buy);
        buttonBuy.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });


        final TextView textView_title = (TextView) findViewById( R.id.textView_title );
        textView_title.setText(book.getBookName());

        final TextView textView_author = (TextView) findViewById( R.id.textView_authorName );
        textView_author.setText(book.getAuthorName());

        final TextView textView_price = (TextView) findViewById( R.id.textView_price );
        textView_price.setText(Double.toString(book.getBookPrice()));


    }
}
