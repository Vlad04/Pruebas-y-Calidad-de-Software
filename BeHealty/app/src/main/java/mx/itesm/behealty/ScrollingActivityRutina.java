package mx.itesm.behealty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

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
