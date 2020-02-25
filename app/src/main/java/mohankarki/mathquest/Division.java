package mohankarki.mathquest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Division extends AppCompatActivity {

    Calculation calculation;

    SharedPreferences sharedPreferencesinAddition;
    int level_status = 1;
    int score;
    int numberOfQuestions = 0;

    int clicked = 0;
    CountDownTimer start, end;

    String date;

    long full, half;
    int time, time1;
    long afterfulltime, afterhalftime;

    int locationOFCorrect;
    ArrayList<Integer> answers = new ArrayList<Integer>();

    private ImageView clock;
    private ProgressBar progressBar;
    private TextView timer, result, point, questionNo, level, sum;
    private Button button2, button3, button4, button5, skip;

    //To set the result in Score
    TextView addname, addscore, addques,adddate;
    Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        timer = (TextView) findViewById(R.id.time);
        point= (TextView) findViewById(R.id.point);
        sum = (TextView) findViewById(R.id.sum);
        skip = (Button) findViewById(R.id.skip);
        result = (TextView) findViewById(R.id.result);
        questionNo = (TextView)findViewById(R.id.questionNo);
        progressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        clock = (ImageView)findViewById(R.id.imageView1);
        level = (TextView)findViewById(R.id.level);

        clock.setImageResource(R.drawable.stopwatch);

        date = getCurrentDate(); //Gets the current date.
        full = 90000;
        half =10000;
        playAgain();
    }

    public void playAgain(){
        //This will initizile all the variable when the quiz is started.
        score = 0;
        numberOfQuestions = 0;
        point.setText("0");
        timer.setText("30s");
        questionNo.setText(String.valueOf(numberOfQuestions));
        result.setText("");
        level.setText("Level: " + String.valueOf(level_status));

        generateQuestion();


        end = new CountDownTimer(full,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time1 = (Integer)(int)millisUntilFinished/1000;
                afterfulltime = millisUntilFinished;
                progressBar.setProgress(time1);
            }

            @Override
            public void onFinish() {
                full = 0;
                half = 0;
                start.cancel();
                setButtonCancel();
                alertForDone();
            }
        }.start();

        start = new CountDownTimer(half, 1000) {
            @Override
            public void onTick(long millisUntilFinished1) {
                time = (Integer)(int)millisUntilFinished1/1000;
                afterhalftime = millisUntilFinished1;
                timer.setText(String.valueOf(millisUntilFinished1 / 1000) + "s");
            }
            @Override
            public void onFinish() {
                start.cancel();
                end.cancel();
                full = 0;
                half = 0;
                timer.setText("0s");
                setButtonCancel();
                alertForDone();
            }
        }.start();
    }

    public void generateQuestion(){

        //This function will generate the question, answer, and set to the UI.

        defaultColor();
        setButtonClick();

        numberOfQuestions++;
        questionNo.setText(String.valueOf(numberOfQuestions));
        clicked = 0;

        Random rand = new Random();
        int a, b;
        a = calculation.get_random_number(21);
        b = calculation.get_random_number1(11,1);


        while( a % b != 0){
            a = calculation.get_random_number(21);
            b = calculation.get_random_number1(11,1);
        }

        sum.setText(String.valueOf(a) + " ÷ " + String.valueOf(b)+ "=");

        locationOFCorrect = calculation.get_random_number(4);
        answers.clear();

        int divide_answer = calculation.division_result(a,b);

        int incorrectAnswer;
        for(int i = 0; i<4; i++){
            if(i == locationOFCorrect){
                answers.add(divide_answer);

            } else {
                incorrectAnswer = calculation.get_random_number(21);
                while(incorrectAnswer == divide_answer){
                    incorrectAnswer = calculation.get_random_number(21);
                }
                answers.add(incorrectAnswer);
            }
        }

        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));

    }


    public void chooseAnswer(View view){
        //It will validate the answer that the user will select.
        if(view.getTag().toString().equals(Integer.toString(locationOFCorrect))){

            result.setText("!!! Correct !!!");
            result.setTextColor(Color.CYAN);
            view.setBackgroundColor(Color.GREEN);
            if(clicked == 0){
                score++;
                clicked++;
            }
            setButtonCancel();
            start.cancel();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    start.start();
                    callQuestion();
                }
            }, 1000);

        }
        else{

            view.setBackgroundColor(Color.RED);
            result.setText("!!! Wrong !!!");
            result.setTextColor(Color.RED);


            clicked++;
            setButtonCancel();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(button2.getTag().toString().equals(Integer.toString(locationOFCorrect))){
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    else if(button3.getTag().toString().equals(Integer.toString(locationOFCorrect))){
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    else if(button4.getTag().toString().equals(Integer.toString(locationOFCorrect))){
                        button4.setBackgroundColor(Color.GREEN);
                    }
                    else if(button5.getTag().toString().equals(Integer.toString(locationOFCorrect))){
                        button5.setBackgroundColor(Color.GREEN);
                    }
                }
            }, 600);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    start.start();
                    callQuestion();
                }
            }, 1000);
        }
        point.setText(Integer.toString(score));
    }

    public void nextQuestion(View view){
        //It is used to skip the question.
        callQuestion();
    }

    public void callQuestion(){
        int flag;

        if(score == 13) {
            flag = 1;
        }
        else if(score ==25){
            flag = 1;
        }
        else if(score ==30){
            flag  = 1;
        }
        else if(score==36){
            flag = 1;
        }
        else if(score > 45){
            flag = 1;
        }
        else{
            flag = 0;
        }

        if(flag == 1){
            level_status = level_status + 1;
        }

        level.setText("Level: " + String.valueOf(level_status));

        if(score<=13) {
            generateQuestion();
        }
        else if(score>13 && score <=25){
            generateQuestion();
        }
        else if(score>25&& score<=30){
            generateQuestion();
        }
        else if(score>30 && score<=36){
            generateQuestion();
        }
        else if(score>36 && score<=40){
            generateQuestion();
        }
        else{
            generateQuestion();
        }
    }


    public void setButtonCancel(){
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
    }

    public void setButtonClick(){
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);

    }

    public void defaultColor(){
        button2.setBackgroundResource(R.drawable.button);
        button3.setBackgroundResource(R.drawable.button);
        button4.setBackgroundResource(R.drawable.button);
        button5.setBackgroundResource(R.drawable.button);
    }


    public void alertForDone(){
        //It will be called when the time is finished.
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View mView = null;
        mView = (View) getLayoutInflater().inflate(R.layout.time_up,null);
        final Button show= (Button) mView.findViewById(R.id.result);
        alertDialog.setView(mView);
        final AlertDialog dialog = alertDialog.create();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.cancel();
                end.cancel();
                alertBox();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

    }

    public void  alertBox() {
        //It will display the result of the quiz, and promt to user what they want to do either try again or go home.
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        View mView = null;
        mView = (View) getLayoutInflater().inflate(R.layout.mathfinalscore,null);
        //final EditText username = (EditText) mView.findViewById(R.id.edit1);
        goHome = (Button) mView.findViewById(R.id.goHome);
        final Button tryagain = (Button)mView.findViewById(R.id.play);
        addname = (TextView)mView.findViewById(R.id.addname);
        addscore = (TextView)mView.findViewById(R.id.addscore);
        addques = (TextView)mView.findViewById(R.id.addques);
        adddate = (TextView)mView.findViewById(R.id.adddate);
        final TextView addlevel = (TextView) mView.findViewById(R.id.addlevel);

        //Setting label
        addname.setText("Demo");
        addscore.setText(String.valueOf(score));
        addques.setText(String.valueOf(numberOfQuestions));
        adddate.setText(date);
        addlevel.setText(String.valueOf(level_status));
        //final MediaPlayer for_button = MediaPlayer.create(this, R.raw.butt);
        alertDialog.setView(mView);
        final AlertDialog dialog = alertDialog.create();

        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                full = 90000;
                half =10000;
                playAgain();
                dialog.cancel();
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);
                finish();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
    }

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd ");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }

    public void exit(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View mView = null;
        mView = (View) getLayoutInflater().inflate(R.layout.forexit,null);
        final Button done= (Button)mView.findViewById(R.id.done);
        final Button cancel = (Button) mView.findViewById(R.id.can);
        alertDialog.setView(mView);
        final AlertDialog dialog = alertDialog.create();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                end.cancel();
                start.cancel();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
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
        exit();
    }

}
