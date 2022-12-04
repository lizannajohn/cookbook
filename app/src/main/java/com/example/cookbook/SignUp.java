package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText fname, lname, email, pwd;
    Button signupbtn, loginrdrct;
    String userid;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fname = findViewById(R.id.textfirstname);
        lname = findViewById(R.id.textlastname);
        email = findViewById(R.id.textemail);
        pwd = findViewById(R.id.textpwd);

        signupbtn = findViewById(R.id.signupbtn);
        loginrdrct = findViewById(R.id.loginrdrct);
    }

    private boolean validatefname() {
        String flag = fname.getText().toString();

        if (flag.isEmpty()) {
            fname.setError("Field cannot be Empty!");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    private boolean validatelname() {
        String flag = lname.getText().toString();

        if (flag.isEmpty()) {
            lname.setError("Field cannot be Empty!");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    private boolean validateemail() {
        String flag = email.getText().toString();
        String emailformat = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        if (flag.isEmpty()) {
            email.setError("Field cannot be Empty!");
            return false;
        } else if (!flag.matches(emailformat)) {
            email.setError("Incorrect Email ID!");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatepwd() {
        String flag = pwd.getText().toString();

        if (flag.isEmpty()) {
            pwd.setError("Field cannot be Empty!");
            return false;
        } else {
            pwd.setError(null);
            return true;
        }
    }

    public void loginrdrct(View view) {
        Intent loginrdrct = new Intent(SignUp.this, Login.class);
        startActivity(loginrdrct);
    }

    public void onclicksuccsignup(View view) {
        if (!validatefname() | !validatelname() | !validateemail() | !validatepwd()) {
            return;
        }

        //Variable fields

        String firstname = fname.getText().toString();
        String lastname = lname.getText().toString();
        String mail = email.getText().toString();
        String password = pwd.getText().toString();

        //Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        //Create object of dataholder
        final DataHolder dbdataholder = new DataHolder(firstname, lastname, mail, password);

        //Create object of Firebase Database
        FirebaseDatabase dbfirebase = FirebaseDatabase.getInstance();

        //Create object of Data Reference
        final DatabaseReference dbreference = dbfirebase.getReference("User");

        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    userid = mAuth.getCurrentUser().getUid();
                    dbreference.child(userid).setValue(dbdataholder);

                    fname.setText("");
                    lname.setText("");
                    email.setText("");
                    pwd.setText("");

                    Toast.makeText(SignUp.this, "User Sign up Sucessful!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                } else {
                    Toast.makeText(SignUp.this, "Process Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}