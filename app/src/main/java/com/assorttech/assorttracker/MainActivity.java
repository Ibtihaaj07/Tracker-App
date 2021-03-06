package com.assorttech.assorttracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {
    Button mButtonLogIn;
    private final static int LOGIN_PERMISSION= 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonLogIn = findViewById(R.id.btnSignIn);

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder().setAllowNewEmailAccounts(true).build(),LOGIN_PERMISSION);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode == LOGIN_PERMISSION)
       {
           startNewActivity(resultCode,data);
       }
    }

    private void startNewActivity(int resultCode, Intent data) {
        if(resultCode == RESULT_OK)
        {
            Intent intent = new Intent(MainActivity.this,listOnline.class);
            startActivity(intent);
            finish();
        }
        else
            {
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
            }
    }
}
