package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OurStory extends AppCompatActivity {

    public void onclicksignup (View view)
    {
        Intent signup = new Intent(OurStory.this, SignUp.class);
        startActivity(signup);
        finish();
    }

    public void onclicklogin (View view)
    {
        Intent login = new Intent(OurStory.this, Login.class);
        startActivity(login);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_story);
    }
}