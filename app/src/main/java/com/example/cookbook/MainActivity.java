package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onclickOS (View view)
    {
        Intent ourstory = new Intent(MainActivity.this, OurStory.class);
        startActivity(ourstory);
        finish();
    }

    public void onclicksignup (View view)
    {
        Intent signup = new Intent(MainActivity.this, SignUp.class);
        startActivity(signup);
    }

    public void onclicklogin (View view)
    {
        Intent login = new Intent(MainActivity.this, Login.class);
        startActivity(login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}