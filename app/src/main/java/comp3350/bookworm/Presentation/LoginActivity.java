package comp3350.bookworm.Presentation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
import comp3350.bookworm.R;

//
//Reference:
//        https://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
//



public class LoginActivity extends AppCompatActivity {
    AccountManager accountManager = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // TODO: add simple identity verification here, half done
        final Button loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String username = ((EditText)  findViewById(R.id.login_username)).getText().toString();
                String password = ((EditText)  findViewById(R.id.login_password)).getText().toString();
                Account account = new Account(username, password);
                if(accountManager.validateAccount(account)) {

                    accountManager.addLoggedInUser(username);
                    startActivity(new Intent(LoginActivity.this, HomePage.class));
                    finish();
                }
                else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, R.string.login_validation_failed, duration);
                    toast.show();
                }
            }
        });


        final TextView signupLink = (TextView) findViewById(R.id.link_signup);
        signupLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });
    }
}
