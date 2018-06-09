package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.stubs.BookListStub;
import comp3350.bookworm.R;


public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Bundle extras = getIntent().getExtras();
        String bookName = "";
        if(extras != null)
            bookName = extras.getString("BookName", "C++");
        Book book = Service.getBookListStub().getBook(bookName);

        final Button buttonBuy = (Button) findViewById( R.id.btn_buy );
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

        // TODO: not implemented yet
//        final Button buttonPreview = (Button) findViewById( R.id.buttonPreview );
//        buttonPreview.setOnClickListener( new View.OnClickListener() {
//            public void onClick( View v ) {
//                Intent intentPreview = new Intent( DescriptionActivity.this, BookPreviewActivity.class);
//                intentPreview.putExtra( "PREVIEW_CONTENT", whichBook.getPreview() );
//                startActivity( intentPreview );
//            }
//        });


        final TextView textView_title = (TextView) findViewById( R.id.textView_title );
        textView_title.setText(book.getBookName());

        final TextView textView_author = (TextView) findViewById( R.id.textView_authorName );
        textView_author.setText(book.getAuthorName());

        final TextView textView_price = (TextView) findViewById( R.id.textView_price );
        textView_price.setText(Double.toString(book.getBookPrice()));


    }
}
