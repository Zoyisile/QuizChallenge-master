package com.example.admin.quizchallenge;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
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

/**
 * Created by admin on 2016/10/03.
 */
public class Philosophy extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rdoTrue1,rdoFalse1,rdoTrue2,rdoFalse2,rdoTrue3,rdoFalse3,rdoTrue4,rdoFalse4,rdoTrue5,rdoFalse5;
    private Button btnSubmitResults;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

       rdoTrue1 = (RadioButton) findViewById(R.id.yes_radio_butt);
        rdoFalse1 = (RadioButton) findViewById(R.id.radio_false1);
        rdoTrue2 = (RadioButton) findViewById(R.id.yes_radio_but);
        rdoFalse2 = (RadioButton) findViewById(R.id.no_radio_bu);
        rdoTrue3 = (RadioButton) findViewById(R.id.yes_radio_b);
        rdoFalse3 = (RadioButton) findViewById(R.id.no_radio);
        rdoTrue4 = (RadioButton) findViewById(R.id.yes_radi);
        rdoFalse4 = (RadioButton) findViewById(R.id.no_rad);
        rdoTrue5 = (RadioButton) findViewById(R.id.yes_radio_button);
        rdoFalse5 = (RadioButton) findViewById(R.id.no_radio_button);
        btnSubmitResults =(Button) findViewById(R.id.next_button);
        btnSubmitResults.setOnClickListener(this);


    }

//    @Override
//    public void onClick(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.yes_radio_butt:
//                if (checked) {
//                    // yes_radio_butt are the best
//
//                }
//                    break;
//            case R.id.no_radio_butto:
//                if (checked)
//                    // no_radio_butto rule
//                    break;
//        }
//    }

    @Override
    public void onClick(View view) {

        int correctAnswer=0;
        if(rdoTrue1.isChecked())
        {
            correctAnswer+=1;
        }
        if(rdoTrue2.isChecked())
        {
            correctAnswer+=1;
        }
        if(rdoFalse3.isChecked())
          {
              correctAnswer+=1;
          }

          if(rdoFalse4.isChecked())
          {
              correctAnswer+=1;
          }

          if(rdoTrue5.isChecked())
          {
              correctAnswer+=1;
          }



        TextView displayText = (TextView)findViewById(R.id.display_text) ;

        if (correctAnswer < 3){

            displayText.setText("You failed  :(  " + correctAnswer + " \nYou should get atleast 3");
            displayText.setTextColor(getResources().getColor(R.color.colorAccent));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Philosophy.this);
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
