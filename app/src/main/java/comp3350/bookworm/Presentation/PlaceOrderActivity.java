package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.R;

public class PlaceOrderActivity extends AppCompatActivity {

    String fee = "CAD$ ";
    double figure = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        // Display the current signed in user
        String loggedInUser = Service.getLoginUserPersistenceStub().getUsername().toUpperCase();
        TextView deliveringToText = (TextView)findViewById(R.id.current_user);
        deliveringToText.setText("Delivering To: "+ loggedInUser);

        // Display the fees dynamically
        String itemFee = fee + Double.toString(figure);
        TextView item = (TextView)findViewById(R.id.items_price);
        item.setText(itemFee);

        String deliveryFee = fee + Double.toString(figure);
        TextView delivery = (TextView)findViewById(R.id.delivery_price);
        delivery.setText(deliveryFee);

        String totalFeeB4Tax = fee + Double.toString(figure);
        TextView total = (TextView)findViewById(R.id.totalb4tax_price);
        total.setText(totalFeeB4Tax);

        String gstFee = fee + Double.toString(figure);
        TextView gst = (TextView)findViewById(R.id.gst_price);
        gst.setText(gstFee);

        String pstFee = fee + Double.toString(figure);
        TextView pst = (TextView)findViewById(R.id.pst_price);
        pst.setText(pstFee);

        String orderTotalFee = fee + Double.toString(figure);
        TextView orderTotal = (TextView)findViewById(R.id.ordertotal_price);
        orderTotal.setText(orderTotalFee);

        // Confirm and Delete Buttons Actions
        Button confirm_btn = (Button)findViewById(R.id.confirm_btn);
        Button cancel_btn = (Button)findViewById(R.id.cancel_btn);

        confirm_btn.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                Toast.makeText( PlaceOrderActivity.this,
                        R.string.not_implemented_msg,
                        Toast.LENGTH_SHORT ).show();
            }
        });

        cancel_btn.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                Intent intentBackToHome = new Intent( PlaceOrderActivity.this, AccountActivity.class );
                startActivity( intentBackToHome );
            }
        });



    }

}
