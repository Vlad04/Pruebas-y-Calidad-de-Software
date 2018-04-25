package mx.itesm.behealty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import pl.droidsonroids.gif.GifDrawable;

public class ScrollingActivityRutina extends AppCompatActivity {
    int count=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_rutina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.progressBar_layout);

        TextView seeExample=(TextView)findViewById(R.id.SeeExample_exercise1_layout);
        TextView progress = (TextView)findViewById(R.id.Progress_textview);
        GifImageView exercise1 =(GifImageView)findViewById(R.id.ejerciciogif1);
        GifImageView exercise2 =(GifImageView)findViewById(R.id.ejerciciogif2);
        GifImageView exercise3 =(GifImageView)findViewById(R.id.ejerciciogif3);
        GifImageView exercise4 =(GifImageView)findViewById(R.id.ejerciciogif4);
        GifImageView exercise5 =(GifImageView)findViewById(R.id.ejerciciogif5);
        GifImageView exercise6 =(GifImageView)findViewById(R.id.ejerciciogif6);

        TextView exercise1_textview = (TextView)findViewById(R.id.ExerciseName_layout);
        TextView exercise2_textview = (TextView)findViewById(R.id.ExerciseName_layout2);
        TextView exercise3_textview = (TextView)findViewById(R.id.ExerciseName_layout3);
        TextView exercise4_textview = (TextView)findViewById(R.id.ExerciseName_layout5);
        TextView exercise5_textview = (TextView)findViewById(R.id.ExerciseName_layout6);
        TextView exercise6_textview = (TextView)findViewById(R.id.ExerciseName_layout7);

        Intent intent = getIntent();
        final String musculo1 = intent.getStringExtra("musculo1");
        final String musculo2 = intent.getStringExtra("musculo2");
        final String musculo_opcion = intent.getStringExtra("musculo_opcion");


        Toast.makeText(getApplicationContext(),musculo1,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),musculo2,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),musculo_opcion,Toast.LENGTH_LONG).show();


        //Back
        if((musculo1.equals("Back") && musculo2 .equals("Triceps"))&&(musculo_opcion.equals("0")))
        {

            exercise1.setGifImageResource(R.drawable.remoindividual);
            exercise2.setGifImageResource(R.drawable.remopiso);
            exercise3.setGifImageResource(R.drawable.remosentado);
            exercise4.setGifImageResource(R.drawable.backab);
            exercise5.setGifImageResource(R.drawable.backreverencias);
            exercise6.setGifImageResource(R.drawable.dipchinasssist);

            exercise1_textview.setText("Dumbbell rows");
            exercise2_textview.setText("Heavy row");
            exercise3_textview.setText("Seared rows");
            exercise4_textview.setText("Romanian deadlifts");
            exercise5_textview.setText("Back reverence");
            exercise6_textview.setText("Dip chin assist");




        }
        //Triceps
        else if((musculo1.equals("Back") && musculo2 .equals("Triceps"))&&(musculo_opcion.equals("1"))) {
            exercise1.setGifImageResource(R.drawable.copa);
            exercise2.setGifImageResource(R.drawable.fondos);
            exercise3.setGifImageResource(R.drawable.francesacostado);
            exercise4.setGifImageResource(R.drawable.tricepsextension);
            exercise5.setGifImageResource(R.drawable.tricepspushdown);
            exercise6.setGifImageResource(R.drawable.tricepspressinclined);

            exercise1_textview.setText("French presses");
            exercise2_textview.setText("Triceps dips");
            exercise3_textview.setText("Nose crushes");
            exercise4_textview.setText("Triceps extension");
            exercise5_textview.setText("Push down");
            exercise6_textview.setText("Triceps press inclined");
        }
        //Triceps
        else if((musculo1.equals("Chest") && musculo2.equals("Biceps"))&&(musculo_opcion.equals("0"))) {
            exercise1.setGifImageResource(R.drawable.chest_press);
            exercise2.setGifImageResource(R.drawable.chest_fly);
            exercise3.setGifImageResource(R.drawable.chest_precc_incline);
            exercise4.setGifImageResource(R.drawable.push_up);
            exercise5.setGifImageResource(R.drawable.chestpress);
            exercise6.setGifImageResource(R.drawable.chestlatpull);

            exercise1_textview.setText("Chest press");
            exercise2_textview.setText("Chest fly");
            exercise3_textview.setText("Chest press incline");
            exercise4_textview.setText("Push up");
            exercise5_textview.setText("Chest press");
            exercise6_textview.setText("Chest latpull");
        }
        //Biceps
        else if((musculo1.equals("Chest") && musculo2 .equals("Biceps"))&&(musculo_opcion.equals("1"))) {
            exercise1.setGifImageResource(R.drawable.cable_biceps);
            exercise2.setGifImageResource(R.drawable.concentrado);
            exercise3.setGifImageResource(R.drawable.martillo);
            exercise4.setGifImageResource(R.drawable.predicadorbiceps);
            exercise5.setGifImageResource(R.drawable.fondosbiceps);
            exercise6.setGifImageResource(R.drawable.bicepseagle);

            exercise1_textview.setText("Biceps crossover");
            exercise2_textview.setText("Concentration curls");
            exercise3_textview.setText("Hammer");
            exercise4_textview.setText("Barbell curl");
            exercise5_textview.setText("Biceps dips");
            exercise6_textview.setText("Biceps press");
        }
        //Leg
        else if((musculo1.equals("Leg") && musculo2 .equals("Abdomen"))&&(musculo_opcion.equals("0"))) {
            exercise1.setGifImageResource(R.drawable.desplantes);
            exercise2.setGifImageResource(R.drawable.legpress);
            exercise3.setGifImageResource(R.drawable.legpressolimpico);
            exercise4.setGifImageResource(R.drawable.seatedlegextension);
            exercise5.setGifImageResource(R.drawable.sentadilla);
            exercise6.setGifImageResource(R.drawable.costurera);

            exercise1_textview.setText("Squat and press");
            exercise2_textview.setText("LegPress");
            exercise3_textview.setText("Olympic Leg Press");
            exercise4_textview.setText("Seated Leg Extension");
            exercise5_textview.setText("Squat");
            exercise6_textview.setText("Seamstress");
        }
        //Abdomen
        else if((musculo1.equals("Leg") && musculo2 .equals("Abdomen"))&&(musculo_opcion.equals("1"))) {
            exercise1.setGifImageResource(R.drawable.ab);
            exercise2.setGifImageResource(R.drawable.abdomen);
            exercise3.setGifImageResource(R.drawable.crunch);
            exercise4.setGifImageResource(R.drawable.escalar);
            exercise5.setGifImageResource(R.drawable.abdomendeclined);
            exercise6.setGifImageResource(R.drawable.jump);

            exercise1_textview.setText("Squat and press");
            exercise2_textview.setText("Russian Twist");
            exercise3_textview.setText("Crunch");
            exercise4_textview.setText("Seated Leg Extension");
            exercise5_textview.setText("Abs declined");
            exercise6_textview.setText("Jump");
        }

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularProgressBar.setProgressWithAnimation(count);
                count=count+10;
            }
        });
        seeExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollingActivityRutina.this, Rutina_example.class);
                startActivity(intent);
            }
        });


        /*
        circularProgressBar.setProgressWithAnimation(count);
                count=count+10;
         */


    }
}
