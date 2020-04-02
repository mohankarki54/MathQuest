package mohankarki.mathquest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Homepage extends AppCompatActivity {

    private ImageButton to_addition, to_subtraction, to_division, to_multiplication, to_mixed, to_instruction,to_score, to_exit;
    private long back_pressed_time;

    //DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

       to_addition = findViewById(R.id.imageButton1);
       to_subtraction = findViewById(R.id.imageButton2);
       to_division = findViewById(R.id.imageButton3);
       to_multiplication = findViewById(R.id.imageButton4);
       to_mixed = findViewById(R.id.imageButton5);
       to_instruction = findViewById(R.id.imageButton6);
       to_score = findViewById(R.id.imageButton7);
       to_exit= findViewById(R.id.imageButton9);


       to_addition.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(getApplicationContext(), Addition.class));
               finish();
           }
       });

       to_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Subtraction.class));
                finish();
            }
        });

        to_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Division.class));
                finish();
            }
        });

        to_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Multiplication.class));
                finish();
            }
        });

        to_mixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Mixed.class));
                finish();
            }
        });

        to_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Instruction.class));
                finish();
            }
        });


        to_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Scores.class));
                finish();
            }
        });

        to_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
    }

    public void exit(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View mView = (View) getLayoutInflater().inflate(R.layout.forexit,null);
        final Button done= (Button)mView.findViewById(R.id.done);
        final Button cancel = (Button) mView.findViewById(R.id.can);
        alertDialog.setView(mView);
        final AlertDialog dialog = alertDialog.create();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Runtime.getRuntime().halt(0);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

    }

    @Override
    public void onBackPressed() {
        if (back_pressed_time + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            exit();
        }
        back_pressed_time = System.currentTimeMillis();

    }


}
