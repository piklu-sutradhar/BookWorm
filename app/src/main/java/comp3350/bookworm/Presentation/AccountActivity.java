package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
import comp3350.bookworm.R;

public class AccountActivity extends AppCompatActivity {
    AccountManager accountManager = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        if(accountManager.anyLoggedInUser()) {
            findViewById(R.id.account_visitor).setVisibility(View.INVISIBLE);
            findViewById(R.id.account_logined).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.account_uername)).setText(accountManager.getLoggedInUsername());
        }
        else {
            findViewById(R.id.account_logined).setVisibility(View.INVISIBLE);
            findViewById(R.id.account_visitor).setVisibility(View.VISIBLE);
        }

        final Button loginBtn = (Button) findViewById(R.id.btn_login_account_page);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, LoginActivity.class));
                finish();
            }
        });

        final Button logoutBtn = (Button) findViewById(R.id.btn_account_logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                accountManager.logout();
                startActivity(new Intent(AccountActivity.this, HomePage.class));
                finish();
            }
        });

        final Button purchaseBtn = (Button) findViewById(R.id.btn_Purchase_History);
        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

               startActivity(new Intent(AccountActivity.this, OrderHistoryActivity.class));
            }
        });

        final Button tempBtn = (Button) findViewById(R.id.button4);
        tempBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                startActivity(new Intent(AccountActivity.this, PlaceOrderActivity.class));
            }
        });
    }

}
