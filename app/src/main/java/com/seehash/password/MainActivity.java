package com.seehash.password;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    byte[] salt;

    byte[] saltedHash;

    EditText etPassword;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etPassword = (EditText) findViewById(R.id.etPassword);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        Encrypt("AdminApp123");  // Sample Password

    }

    private void Encrypt(String password)
    {
        salt     =   Passwords.getNextSalt();

        String str = "";

        for (int x=0; x<salt.length; x++)
        {
            str = str + Array.getByte(salt, x);

            Log.d("salt 1", ""+str);

            Log.d("salt 1", ""+Array.getByte(salt, x));
        }

        char[] arr_password = password.toCharArray();

        saltedHash   =   Passwords.hash(arr_password, salt);

//        for (int x=0; x<saltedHash.length; x++)
//            Log.d("salt", ""+Array.getByte(saltedHash, x));

        Decrypt();
    }

    private void Decrypt()
    {

//      String userPassword     =   "" + etPassword.getText().toString();

        String userPassword     =   "AdminApp123";

        String saltStr          =   "AdminApp123";

        String saltedHashStr    =   "AdminApp123";

        char [] arr_password = userPassword.toCharArray();

        byte [] byteSalt = saltStr.getBytes();

        byte [] byteSaltedHash = saltedHashStr.getBytes();

        Boolean status  =   Passwords.isExpectedPassword(arr_password, byteSalt, byteSaltedHash);

        if (status)
        {
            Log.d("Go to next page", status.toString());
        }
        else
        {
            Log.d("Wrong Psssword", status.toString());
        }
    }

    public void go(View view)
    {
        Decrypt();
    }
}
