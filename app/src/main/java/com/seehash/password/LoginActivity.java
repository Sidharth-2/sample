package com.seehash.password;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{

    EditText user_name, password;

    TextView login_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        user_name = (EditText) findViewById(R.id.user_name);

        password = (EditText) findViewById(R.id.password);

        login_result = (TextView) findViewById(R.id.login_result);
    }

    public void toastMe(View view)
    {
        if ((user_name.getText().toString().trim().equals("sidharth"))&&(password.getText().toString().trim().equals("123")))
            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
    }
}
