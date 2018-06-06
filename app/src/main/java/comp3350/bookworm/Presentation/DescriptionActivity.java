package comp3350.bookworm.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.bookworm.R;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        final Button buttonBuy = (Button) findViewById( R.id.buttonBuy );
        buttonBuy.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });

        final Button buttonPreview = (Button) findViewById( R.id.buttonPreview );
        buttonPreview.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });

        final Button buttonSubmit = (Button) findViewById( R.id.buttonSubmit );
        buttonSubmit.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {

            }
        });

        final TextView textView_title = (TextView) findViewById( R.id.textView_title );
        textView_title.setText( R.string.bookTitle );

        final TextView textView_price = (TextView) findViewById( R.id.textView_price );
        textView_price.setText( R.string.bookPrice );

        final TextView textView_review = (TextView) findViewById( R.id.textView_review );
        textView_review.setText( R.string.review );
    }
}
