package com.seehash.password;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Expresso_UI_Test extends AppCompatActivity{

    Button mLoginButton;

    TextView mResultTV;

    EditText mEmailET, mPasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.expresso_ui_testing);

        initialize();
    }

    private void initialize()
    {
        mLoginButton = (Button) findViewById(R.id.button);

        mEmailET = (EditText) findViewById(R.id.editTextEmail);

        mPasswordET = (EditText) findViewById(R.id.editTextPassword);

        mResultTV = (TextView) findViewById(R.id.textViewResult);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEmailET.getText().toString().equals("sid@gmail.com") && mPasswordET.getText().toString().equals("pwd"))
                    mResultTV.setText("success");
                else
                    mResultTV.setText("failed");
            }
        });
    }
}
