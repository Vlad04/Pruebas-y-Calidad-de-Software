package mx.itesm.behealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Rutina_example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_example);
        Intent intent = getIntent();
        final String image_opcion = intent.getStringExtra("image_opcion");
        final String posicion_see_more_counter = intent.getStringExtra("posicion_see_more_counter");
        GifImageView actual_gif=(GifImageView)findViewById(R.id.example_exercise_image);

        if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.remoindividual);
        }
        else if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.remopiso);

        }
        else if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.remosentado);

        }
        else if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.backab);

        }
        else if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.backreverencias);

        }
        else if((image_opcion.equals("1")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.dipchinasssist);

        }

        //////////////////////////////////////

        if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.copa);

        }
        else if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.fondos);

        }
        else if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.francesacostado);

        }
        else if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.tricepsextension);

        }
        else if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.tricepspushdown);

        }
        else if((image_opcion.equals("2")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.tricepspressinclined);

        }

        /////////////////////////////////////

        if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.chest_press);

        }
        else if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.chest_fly);

        }
        else if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.chest_precc_incline);

        }
        else if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.push_up);

        }
        else if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.chestpress);

        }
        else if((image_opcion.equals("3")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.chestlatpull);

        }

        //////////////////////////////////////////////////////////

        if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.cable_biceps);

        }
        else if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.concentrado);

        }
        else if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.martillo);

        }
        else if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.predicadorbiceps);

        }
        else if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.fondosbiceps);

        }
        else if((image_opcion.equals("4")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.bicepseagle);

        }

        ///////////////////////////////////////////////////////

        if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.desplantes);

        }
        else if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.legpress);

        }
        else if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.legpressolimpico);

        }
        else if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.seatedlegextension);

        }
        else if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.sentadilla);

        }
        else if((image_opcion.equals("5")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.costurera);

        }

        ////////////////////////////////////////


        if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("1")))
        {
            actual_gif.setGifImageResource(R.drawable.ab);

        }
        else if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("2")))
        {
            actual_gif.setGifImageResource(R.drawable.abdomen);

        }
        else if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("3")))
        {
            actual_gif.setGifImageResource(R.drawable.crunch);

        }
        else if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("4")))
        {
            actual_gif.setGifImageResource(R.drawable.escalar);

        }
        else if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("5")))
        {
            actual_gif.setGifImageResource(R.drawable.abdomendeclined);

        }
        else if((image_opcion.equals("6")) && (posicion_see_more_counter.equals("6")))
        {
            actual_gif.setGifImageResource(R.drawable.jump);

        }
    }
}