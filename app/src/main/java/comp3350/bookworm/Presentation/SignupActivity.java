package comp3350.bookworm.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.bookworm.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // TODO: add simple identity verification here
        final Button loginBtn = (Button) findViewById(R.id.btn_signup);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(SignupActivity.this, HomePage.class));
                finish();
            }
        });


        final TextView signupLink = (TextView) findViewById(R.id.link_login);
        signupLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
