package mohankarki.mathquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Scores extends AppCompatActivity {

    private TextView addsocre, addques, addlevel, adddate; //These textview are for addition mode.

    private TextView subscore, subques, sublevel, subdate; //These textview are for subtraction mode.

    private TextView mulscore, mulques, mullevel, muldate; //These textview are for multiplication mode.

    private TextView divscore, divques, divlevel, divdate; //These textview are for division mode.

    private TextView mixscore,mixques, mixlevel, mixdate; //These textview are for mixed quiz mode.


    private Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        goHome = findViewById(R.id.goHome);
        //It will take the user to the Homepage
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Homepage.class));
                finish();
            }
        });

        //This is to set the last score of the User every time they play.
        addsocre = findViewById(R.id.addscore);
        addques = findViewById(R.id.addques);
        addlevel = findViewById(R.id.addlevel);
        adddate = findViewById(R.id.adddate);

        SharedPreferences addition_result = getSharedPreferences("Add", Context.MODE_PRIVATE);
        int score = addition_result.getInt("score", 0);
        int question = addition_result.getInt("question", 0);
        int level = addition_result.getInt("level", 0);
        String date = addition_result.getString("Date", "02-22-2020");

        addsocre.setText(String.valueOf(score));
        addques.setText(String.valueOf(question));
        addlevel.setText(String.valueOf(level));
        adddate.setText(date);


        //This is to set the last score of the User every time they play for Subtraction
        subscore = findViewById(R.id.subscore);
        subques = findViewById(R.id.subques);
        sublevel = findViewById(R.id.sublevel);
        subdate = findViewById(R.id.subdate);

        SharedPreferences subtraction_result = getSharedPreferences("Sub", Context.MODE_PRIVATE);
        int sub_score = subtraction_result.getInt("score", 0);
        int sub_question = subtraction_result.getInt("question", 0);
        int sub_level = subtraction_result.getInt("level", 0);
        String sub_date = subtraction_result.getString("Date", "02-22-2020");

        subscore.setText(String.valueOf(sub_score));
        subques.setText(String.valueOf(sub_question));
        sublevel.setText(String.valueOf(sub_level));
        subdate.setText(sub_date);

//This is to set the last score of the User every time they play for divison
        divscore = findViewById(R.id.divscore);
        divques = findViewById(R.id.divques);
        divlevel = findViewById(R.id.divlevel);
        divdate = findViewById(R.id.divdate);

        SharedPreferences divison_result = getSharedPreferences("divison", Context.MODE_PRIVATE);
        int div_score = divison_result.getInt("score", 0);
        int div_question = divison_result.getInt("question", 0);
        int div_level = divison_result.getInt("level", 0);
        String div_date = divison_result.getString("Date", "02-22-2020");

        divscore.setText(String.valueOf(div_score));
        divques.setText(String.valueOf(div_question));
        divlevel.setText(String.valueOf(div_level));
        divdate.setText(div_date);


//This is to set the last score of the User every time they play for Multiplication
        mulscore = findViewById(R.id.mulscore);
        mulques = findViewById(R.id.mulques);
        mullevel = findViewById(R.id.mullevel);
        muldate = findViewById(R.id.muldate);

        SharedPreferences multiplication_result = getSharedPreferences("mul", Context.MODE_PRIVATE);
        int mul_score = multiplication_result.getInt("score", 0);
        int mul_question = multiplication_result.getInt("question", 0);
        int mul_level = multiplication_result.getInt("level", 0);
        String mul_date = multiplication_result.getString("Date", "02-22-2020");

        mulscore.setText(String.valueOf(mul_score));
        mulques.setText(String.valueOf(mul_question));
        mullevel.setText(String.valueOf(mul_level));
        muldate.setText(mul_date);

//This is to set the last score of the User every time they play for Mixed Quiz
        mixscore = findViewById(R.id.mixscore);
        mixques = findViewById(R.id.mixques);
        mixlevel = findViewById(R.id.mixlevel);
        mixdate = findViewById(R.id.mixdate);

        SharedPreferences mixed_result = getSharedPreferences("mix", Context.MODE_PRIVATE);
        int mix_score =  mixed_result.getInt("score", 0);
        int mix_question = mixed_result.getInt("question", 0);
        int mix_level = mixed_result.getInt("level", 0);
        String mix_date = mixed_result.getString("Date", "02-22-2020");

        mixscore.setText(String.valueOf(mix_score));
        mixques.setText(String.valueOf(mix_question));
        mixlevel.setText(String.valueOf(mix_level));
        mixdate.setText(mix_date);


    }

    @Override
    public void onBackPressed() {
        //It will execute if the user press the back button and takes to Homepage.
        Intent intent = new Intent(getApplicationContext(), Homepage.class);
        startActivity(intent);
        finish();
    }
}
