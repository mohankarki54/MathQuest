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

public class scores extends AppCompatActivity {

    private TextView addsocre, addques, addlevel, adddate;
    private Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        addsocre = findViewById(R.id.addscore);
        addques = findViewById(R.id.addques);
        addlevel = findViewById(R.id.addlevel);
        adddate = findViewById(R.id.adddate);
        goHome = findViewById(R.id.goHome);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Homepage.class));
                finish();
            }
        });

        SharedPreferences addition_result = getSharedPreferences("Add", Context.MODE_PRIVATE);
        int score = addition_result.getInt("score", 0);
        int question = addition_result.getInt("question", 0);
        int level = addition_result.getInt("level", 0);
        String date = addition_result.getString("Date", "02-22-2020");


        addsocre.setText(String.valueOf(score));
        addques.setText(String.valueOf(question));
        addlevel.setText(String.valueOf(level));
        adddate.setText(date);

    }
}
