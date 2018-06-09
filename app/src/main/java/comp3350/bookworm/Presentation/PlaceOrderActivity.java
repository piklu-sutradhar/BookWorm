package comp3350.bookworm.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.R;

public class PlaceOrderActivity extends AppCompatActivity {

    String fee = "CAD$";
    double figure = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        String loggedInUser = Service.getLoginUserPersistenceStub().getUsername().toUpperCase();
        TextView deliveringToText = (TextView)findViewById(R.id.current_user);

        deliveringToText.setText("Delivering To: "+ loggedInUser);



    }

}
