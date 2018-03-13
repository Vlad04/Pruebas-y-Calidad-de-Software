package mx.itesm.behealty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    Button generate_plan, Calendario_button;
    private String[] arraySpinner;
    Intent i;
    TextView peso;
    TextView edad;
    TextView estatura;
    TextView get_peso,get_edad,get_estatura;
    TextView sexo;
    TextView tiempo_inactivo;
    TextView objetivo;
    TextView nombre_usuario;



    TextView getCalentamiento;
    TextView getExercise, getExercise2, getExercise3, getExercise4;
    TextView getMuscle;
    TextView getPeso_de_calentamiento;
    TextView getRepetitions;
    TextView getSeries;
    TextView getWeight;
    TextView getSexo;
    TextView getTiempo_inactivo;
    TextView getObjetivo;
    TextView getNombre_usuario;



    ArrayList<TextView> textViewsVal;
    ArrayList<TextView> textViewsName;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent();

        nombre_usuario=(TextView)findViewById(R.id.user_textview_layout);
        peso=(TextView)findViewById(R.id.peso_textview_layout);
        edad=(TextView)findViewById(R.id.edad_textview_layout);
        estatura=(TextView)findViewById(R.id.estatura_textview_layout);
        sexo=(TextView)findViewById(R.id.sexo_textview_layout);
        tiempo_inactivo=(TextView)findViewById(R.id.tiempoInactivo_layout);
        objetivo=(TextView)findViewById(R.id.Objetivo_textview_layout);

        getNombre_usuario=(TextView)findViewById(R.id.getUsuario_layout);
        get_peso=(TextView)findViewById(R.id.get_peso_layout);
        get_edad=(TextView)findViewById(R.id.get_edad_layout);
        get_estatura=(TextView)findViewById(R.id.get_estatura_layout);
        getTiempo_inactivo=(TextView)findViewById(R.id.getTiempo_Inactivo_layout);
        getSexo=(TextView)findViewById(R.id.getSexo_layout);
        getObjetivo=(TextView)findViewById(R.id.getObjetivo_layout);

        Calendario_button=(Button)findViewById(R.id.Calendario_Button);
        final GraphView graph = (GraphView) findViewById(R.id.graph);


        /*getCalentamiento=(TextView)findViewById(R.id.calentamiento_valor);
        getExercise=(TextView)findViewById(R.id.exercise_valor);
        getExercise2=(TextView)findViewById(R.id.Exercise_2_valor);
        getExercise3=(TextView)findViewById(R.id.Exercise_3_valor);
        getExercise4=(TextView)findViewById(R.id.Exercise_4_Value);

        getMuscle=(TextView)findViewById(R.id.muscle_valor);
        getPeso_de_calentamiento=(TextView)findViewById(R.id.peso_calentaiento_valor);
        getRepetitions=(TextView)findViewById(R.id.repetitions_valor);
        getSeries=(TextView)findViewById(R.id.series_valor);
        getWeight=(TextView)findViewById(R.id.weight_valor);
        */


        textViewsName = new ArrayList<TextView>();
        textViewsName.add(nombre_usuario);
        textViewsName.add(peso);
        textViewsName.add(estatura);
        textViewsName.add(edad);
        textViewsName.add(sexo);
        textViewsName.add(tiempo_inactivo);
        textViewsName.add(objetivo);




        textViewsVal = new ArrayList<TextView>();
        textViewsVal.add(getNombre_usuario);
        textViewsVal.add(get_peso);
        textViewsVal.add(get_estatura);
        textViewsVal.add(get_edad);
        textViewsVal.add(getSexo);
        textViewsVal.add(getTiempo_inactivo);
        textViewsVal.add(getObjetivo);


        /*
        textViewsVal.add(getExercise3);
        textViewsVal.add(getExercise4);
        textViewsVal.add(getMuscle);
        textViewsVal.add(getPeso_de_calentamiento);
        textViewsVal.add(getRepetitions);
        textViewsVal.add(getSeries);
        textViewsVal.add(getWeight);
*/



        //String user=fragmentWithButton.routine_name;
        //Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();

        /*
        this.arraySpinner = new String[] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
        */




        reference = database.getReference("Usuario "+user);



        reference.addValueEventListener(new ValueEventListener() {

            float IMC=0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 0;
                Log.d("number of childs",""+dataSnapshot.getChildrenCount());

                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    if (i < 15) {
                        textViewsName.get(i).setText(child.getKey());
                        textViewsVal.get(i).setText(child.getValue().toString());
                        Log.d("User key", child.getKey());
                        Log.d("User ref", child.getRef().toString());
                        Log.d("User val", child.getValue().toString());
                        i++;
                        Log.d("peso_graph",get_peso.getText().toString());
                        Log.d("estatura_graph",get_estatura.getText().toString());
                        Log.d("edad_graph",get_edad.getText().toString());
                        Log.d("Nombre",getNombre_usuario.getText().toString());
                        Log.d("sexo",getSexo.getText().toString());
                        Log.d("tiempo inactivo",getTiempo_inactivo.getText().toString());
                        Log.d("Objetivo",getObjetivo.getText().toString());

                        //IMC=(Float.parseFloat(get_peso.getText().toString())/((Float.parseFloat(get_estatura.getText().toString()))*(Float.parseFloat(get_estatura.getText().toString()))));

                    }


                }
                float peso_graph=Float.parseFloat(getSexo.getText().toString());
                float estatura_graph=Float.parseFloat(get_peso.getText().toString());
                float edad_graph=Float.parseFloat(getNombre_usuario.getText().toString());
                Log.d("peso_graph_float",String.valueOf(peso_graph));
                Log.d("estatura_graph_float",String.valueOf(estatura_graph));
                Log.d("edad_graph_float",String.valueOf(edad_graph));
                IMC=((peso_graph)/(estatura_graph*estatura_graph));
                Log.d("IMC", String.valueOf(IMC));

                BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {



                        new DataPoint(0, IMC),
                        new DataPoint(1, 14),
                        new DataPoint(2, 15)

                });

                /*Log.d("peso_graph",get_peso.getText().toString());
                Log.d("estatura_graph",get_estatura.getText().toString());
                Log.d("edad_graph",get_edad.getText().toString());*/
                //Log.d("IMC", String.valueOf(IMC));

                graph.addSeries(series);

// styling
                series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                    @Override
                    public int get(DataPoint data) {
                        return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                    }
                });

                series.setSpacing(50);

// draw values on top
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        Calendario_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calendario.class);
                startActivity(intent);
            }
        });









    }


}
