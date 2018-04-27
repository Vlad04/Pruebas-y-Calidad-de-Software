package mx.itesm.behealty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Cardeo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardeo);

        GifImageView exercise1 =(GifImageView)findViewById(R.id.ejerciciogif1);
        GifImageView exercise2 =(GifImageView)findViewById(R.id.ejerciciogif2);

        try {
            exercise1.setGifImageResource(R.drawable.cardeo_a);
            exercise2.setGifImageResource(R.drawable.cardeo_b);
        }catch (Exception e)
        {

        }
    }
}
