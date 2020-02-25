package mohankarki.mathquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Homepage extends AppCompatActivity {

    private Button button1,button2,button3,button4,button5,button6,button7,button8;
    private ImageButton to_addition, to_subtraction, to_division, to_multiplication, to_mixed, to_instruction, to_credit ,to_score, to_exit;

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
       to_credit = findViewById(R.id.imageButton8);
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
                startActivity(new Intent(getApplicationContext(), instruction.class));
                finish();
            }
        });

        to_credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), credits.class));
                finish();
            }
        });


        to_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), scores.class));
                finish();
            }
        });

        to_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Addition.class));
                finish();
            }
        });
    }


}
