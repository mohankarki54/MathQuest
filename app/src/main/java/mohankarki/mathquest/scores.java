package mohankarki.mathquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class scores extends AppCompatActivity {

    private TextView addname, addsocre, addques, addlevel, adddate;
    private Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        addname = findViewById(R.id.addname);
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

        addname.setText("Demo");
        addsocre.setText("0");
        addques.setText("1");
        addlevel.setText("1");
        adddate.setText("02-20-2020");

    }
}
