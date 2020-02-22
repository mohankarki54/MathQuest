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
    private ImageButton to_addition, to_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

       to_addition = findViewById(R.id.imageButton1);

       to_addition.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), Addition.class));
               finish();
           }
       });

       to_score = findViewById(R.id.imageButton7);
       to_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), scores.class));
                finish();
            }
        });

    }


}
