package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.BookManager;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.stubs.BookListStub;
import comp3350.bookworm.R;

import static comp3350.bookworm.R.layout.dialog_add_to_cart;

public class DescriptionActivity extends AppCompatActivity {
    private BookListStub bookListStub;
    private AlertDialog dialog;
    private Book whichBook;

    /* is it possible to get an object itself rather than String from previous activity?
    *  which one would be better?
    *  object will be better*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        bookListStub = Service.getBookListStub();
        whichBook = bookListStub.searchBook( getIntent().getStringExtra( "BOOK_NAME" ) );

        final Button buttonBuy = (Button) findViewById( R.id.buttonBuy );
        buttonBuy.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder( DescriptionActivity.this );
                View mView = getLayoutInflater().inflate( R.layout.dialog_add_to_cart, null );
                Button btn_back_to_list = (Button) mView.findViewById( R.id.btn_back_to_list );
                Button btn_check_cart = (Button) mView.findViewById( R.id.btn_check_cart );

                btn_back_to_list.setOnClickListener( new View.OnClickListener() {
                    public void onClick( View v ) {
                        Intent intentBackToHome = new Intent( DescriptionActivity.this, HomePage.class );
                        startActivity( intentBackToHome );
                    }
                });

                btn_check_cart.setOnClickListener( new View.OnClickListener() {
                    public void onClick( View v ) {
//                        Intent intentCart = new Intent( DescriptionActivity.this, Cart.class );
//                        startActivity( intentCart );

                        Toast.makeText( DescriptionActivity.this,
                                                R.string.not_implemented_msg,
                                                Toast.LENGTH_SHORT ).show();
                    }
                });

                mBuilder.setView( mView  );
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        final Button buttonPreview = (Button) findViewById( R.id.buttonPreview );
        buttonPreview.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                Intent intentPreview = new Intent( DescriptionActivity.this, BookPreviewActivity.class);
                intentPreview.putExtra( "PREVIEW_CONTENT", whichBook.getPreview() );
                startActivity( intentPreview );
            }
        });

        final Button buttonSubmit = (Button) findViewById( R.id.buttonSubmit );
        buttonSubmit.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });

        final TextView textView_title = (TextView) findViewById( R.id.textView_title );
        textView_title.setText( whichBook.getBookName() );

        final TextView textView_price = (TextView) findViewById( R.id.textView_price );
        textView_price.setText( String.format( "%.2f" , whichBook.getBookPrice()) );

    }
}
