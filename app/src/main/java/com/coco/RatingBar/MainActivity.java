
package com.coco.RatingBar;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.coco.mystare.R;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity {

    Button feed;
    TextView titlerate,resultrate;
    ImageView charplace;
    RatingBar rateStat;
    String answerValue;
    Animation charanim,btt,texAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feed = findViewById(R.id.button);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);

        charplace = findViewById(R.id.icSprite);
        //Animation
        rateStat = findViewById(R.id.ratestar);
        charanim = AnimationUtils.loadAnimation(this,R.anim.charamin);
         charplace.startAnimation(charanim);

        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        feed.startAnimation(charanim);

        texAll = AnimationUtils.loadAnimation(this,R.anim.textall);
        resultrate.startAnimation(charanim);



        rateStat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                answerValue = String.valueOf((int)(rateStat.getRating()));

                if (answerValue.equals("1")){
                    charplace.setImageResource(R.drawable.i4);
                    charplace.startAnimation(charanim);
                    feed.startAnimation(charanim);
                    resultrate.startAnimation(charanim);
                    resultrate.setText("Bad");
                   // feed.startAnimation( btt);
                }else if (answerValue.equals("2")){
                    resultrate.setText("GOOD So So");
                    charplace.setImageResource(R.drawable.i1);
                    charplace.startAnimation(charanim);
                    feed.startAnimation(charanim);
                    resultrate.startAnimation(charanim);

                    // feed.startAnimation( btt);
                } else if (answerValue.equals("3")){
                    charplace.setImageResource(R.drawable.i2);
                    charplace.startAnimation(charanim);
                    feed.startAnimation(charanim);
                    resultrate.startAnimation(charanim);

                    resultrate.setText("Superb Hero");

                }else if (answerValue.equals("4")){
                    charplace.setImageResource(R.drawable.i3);
                    charplace.startAnimation(charanim);
                    feed.startAnimation(charanim);
                    resultrate.startAnimation(charanim);

                    resultrate.setText("Good Job");

                }else if (answerValue.equals("5")) {
                   charplace.setImageResource(R.drawable.i6);
                    charplace.startAnimation(charanim);
                    feed.startAnimation(charanim);
                    resultrate.startAnimation(charanim);
                    resultrate.setText("Awesome");

                }else {

                    Toast.makeText(getApplicationContext(), "No Point", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //font
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KaushanScript-Regular.otf");
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"fonts/Billionthine Personal Use Only.ttf");

        feed.setTypeface(typeface);
        titlerate.setTypeface(typeface);

        resultrate.setTypeface(typeface);
        
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thank You On Rating ", Toast.LENGTH_SHORT).show();
            }
        });










    }
}
