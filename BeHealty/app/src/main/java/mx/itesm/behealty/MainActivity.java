package mx.itesm.behealty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    Button generate_plan, done_button;
    private String[] arraySpinner;
    Intent i;
    TextView peso;
    TextView edad;
    TextView estatura;
    TextView get_peso,get_edad,get_estatura;



    TextView getCalentamiento;
    TextView getExercise, getExercise2, getExercise3, getExercise4;
    TextView getMuscle;
    TextView getPeso_de_calentamiento;
    TextView getRepetitions;
    TextView getSeries;
    TextView getWeight;


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

        peso=(TextView)findViewById(R.id.peso_textview);
        edad=(TextView)findViewById(R.id.edad_textview);
        estatura=(TextView)findViewById(R.id.estatura_textview);
        get_peso=(TextView)findViewById(R.id.get_peso);
        get_edad=(TextView)findViewById(R.id.get_edad);
        get_estatura=(TextView)findViewById(R.id.get_estatura);
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
        textViewsName.add(peso);
        textViewsName.add(estatura);
        textViewsName.add(edad);



        textViewsVal = new ArrayList<TextView>();
        textViewsVal.add(get_edad);
        textViewsVal.add(get_peso);
        textViewsVal.add(get_estatura);
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

                    if (i < 10) {
                        textViewsName.get(i).setText(child.getKey());
                        textViewsVal.get(i).setText(child.getValue().toString());
                        Log.d("User key", child.getKey());
                        Log.d("User ref", child.getRef().toString());
                        Log.d("User val", child.getValue().toString());
                        i++;
                        Log.d("peso_graph",get_peso.getText().toString());
                        Log.d("estatura_graph",get_estatura.getText().toString());
                        Log.d("edad_graph",get_edad.getText().toString());
                        //IMC=(Float.parseFloat(get_peso.getText().toString())/((Float.parseFloat(get_estatura.getText().toString()))*(Float.parseFloat(get_estatura.getText().toString()))));

                    }


                }
                float peso_graph=Float.parseFloat(get_peso.getText().toString());
                float estatura_graph=Float.parseFloat(get_estatura.getText().toString());
                float edad_graph=Float.parseFloat(get_edad.getText().toString());
                Log.d("peso_graph_float",String.valueOf(peso_graph));
                Log.d("estatura_graph_float",String.valueOf(estatura_graph));
                Log.d("edad_graph_float",String.valueOf(edad_graph));
                IMC=((estatura_graph)/(peso_graph*peso_graph));
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













    }


}
