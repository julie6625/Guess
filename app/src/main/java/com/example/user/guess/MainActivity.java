package com.example.user.guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    String temp;
    Random secrect = new Random();
    int sec = secrect.nextInt(100)+1;
    String stringValue = Integer.toString(sec);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView secEdit = findViewById(R.id.sec_textView);

        secEdit.setText(sec+"");

    }

    public void guesses(View view){

        String guessedit = ((EditText)findViewById(R.id.editText)).getText().toString();
        int guessedit1 = Integer.parseInt(guessedit);
        if (stringValue.equals(guessedit)){
            getSharedPreferences("atm", MODE_PRIVATE)
                    .edit()
                    .putString("USERID", guessedit)
                    .apply();
            Toast.makeText(this,"Yes, the number is "+stringValue, Toast.LENGTH_LONG).show();
        }else if (Integer.parseInt(guessedit)>sec){
            Toast.makeText(this,"1 to "+guessedit, Toast.LENGTH_LONG).show();
        }else if (Integer.parseInt(guessedit)<sec){
            Toast.makeText(this,guessedit+" to 100", Toast.LENGTH_LONG).show();
        }

    }
}
