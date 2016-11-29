package com.example.admin.quizchallenge;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rdoTrue1,rdoFalse1,rdoTrue2,rdoFalse2,rdoTrue3,rdoFalse3,rdoTrue4,rdoFalse4,rdoTrue5,rdoFalse5;
    private Button btnSubmitResults;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rdoTrue1 = (RadioButton) findViewById(R.id.gala_loe_two);
        rdoFalse1 = (RadioButton) findViewById(R.id.plato_two);
        rdoTrue2 = (RadioButton) findViewById(R.id.raini_two);
        rdoFalse2 = (RadioButton) findViewById(R.id.raini_three);
        rdoTrue3 = (RadioButton) findViewById(R.id.gala_loe_two);
        rdoFalse3 = (RadioButton) findViewById(R.id.gala_loe_three);
        rdoTrue4 = (RadioButton) findViewById(R.id.einstain);
        rdoFalse4 = (RadioButton) findViewById(R.id.einstain_two);
        rdoTrue5 = (RadioButton) findViewById(R.id.yes_radio_button);
        rdoFalse5 = (RadioButton) findViewById(R.id.no_radio_button);
        btnSubmitResults =(Button) findViewById(R.id.next_button2);
        btnSubmitResults.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int correctAnswer=0;
        if(rdoFalse1.isChecked())
        {
            correctAnswer+=1;
        }
        if(rdoTrue2.isChecked())
        {
            correctAnswer+=1;
        }
        if(rdoTrue3.isChecked())
        {
            correctAnswer+=1;
        }

        if(rdoTrue4.isChecked())
        {
            correctAnswer+=1;
        }

        if(rdoFalse5.isChecked())
        {
            correctAnswer+=1;
        }

        TextView displayText = (TextView)findViewById(R.id.display_text) ;

        if (correctAnswer < 3){

            displayText.setText("You failed  :(  " + correctAnswer + " \nYou should get atleast 3");

        }
        else {

            displayText.setText("You passed :)   " + correctAnswer  );
        }



        String s = ""+correctAnswer;
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();


    }
    // Exit the game to the main activity.
    public void exitButton(View view) {

        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
        builder.setCancelable(true);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
