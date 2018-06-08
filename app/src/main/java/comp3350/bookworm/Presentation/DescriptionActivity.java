package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.bookworm.BusinessLogic.BookManager;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class DescriptionActivity extends AppCompatActivity {
    private BookManager bookManeger;
    private ArrayList<Book> bookList;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        final Button buttonBuy = (Button) findViewById( R.id.buttonBuy );
        buttonBuy.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                // TODO: print message like "order completed" by using alertdialog
                // https://developer.android.com/guide/topics/ui/dialogs
                dialog = new AlertDialog();
            }
        });

        final Button buttonPreview = (Button) findViewById( R.id.buttonPreview );
        buttonPreview.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                startActivity( new Intent(DescriptionActivity.this, BookPreviewActivity.class) );
                finish();
            }
        });

        final Button buttonSubmit = (Button) findViewById( R.id.buttonSubmit );
        buttonSubmit.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });

        final TextView textView_title = (TextView) findViewById( R.id.textView_title );
//        textView_title.setText();

        final TextView textView_price = (TextView) findViewById( R.id.textView_price );
//        textView_price.setText();

        final TextView textView_review = (TextView) findViewById( R.id.textView_reviewScore );
        textView_review.setText( R.string.title_review );
    }
}
