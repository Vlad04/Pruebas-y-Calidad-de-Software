package mx.itesm.behealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class GenerarPlan extends AppCompatActivity {
    int count=10;
    String musculo_opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_plan);

        Intent intent = getIntent();
        final String musculo1 = intent.getStringExtra("musculo1");
        final String musculo2 = intent.getStringExtra("musculo2");
        final String day = intent.getStringExtra("day");
        //final CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.progressBar_layout);

        Button musculo1_button=(Button)findViewById(R.id.Button_musculo1_layout);
        Button musculo2_button=(Button)findViewById(R.id.Button_musculo2_layout);
        Button ejercicios_cardeo1=(Button)findViewById(R.id.ejercicios_cardeovasculares_layout1);
        Button nutricion=(Button)findViewById(R.id.Button_nutrition_layout);
        Button map=(Button)findViewById(R.id.Button_map_layout);

        musculo1_button.setText(musculo1);
        musculo2_button.setText(musculo2);


        //MUSCULO 1
        musculo1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musculo_opcion="0";
                Intent intent = new Intent(GenerarPlan.this, ScrollingActivityRutina.class);
                intent.putExtra("musculo1", musculo1);
                intent.putExtra("musculo2", musculo2);
                intent.putExtra("musculo_opcion", musculo_opcion);

                startActivity(intent);
            }

        });

        //MUSCULO 2
        musculo2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musculo_opcion="1";
                Intent intent = new Intent(GenerarPlan.this, ScrollingActivityRutina.class);
                intent.putExtra("musculo1", musculo1);
                intent.putExtra("musculo2", musculo2);
                intent.putExtra("musculo_opcion", musculo_opcion);

                startActivity(intent);
            }

        });

        //EJERCICIOS CARDEO
        ejercicios_cardeo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(GenerarPlan.this, ScrollingActivityRutina.class);
                startActivity(intent);*/
            }

        });

        //NUTRICION
        nutricion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GenerarPlan.this, ScrollingActivityRutina.class);
                startActivity(intent);
            }

        });

        //MAPA
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GenerarPlan.this, MapsActivity.class);
                startActivity(intent);
            }

        });
    }
}
