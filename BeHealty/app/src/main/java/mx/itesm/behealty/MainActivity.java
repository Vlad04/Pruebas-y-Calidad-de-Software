package mx.itesm.behealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


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

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("hey guy","im here");
                int i = 0;
                Log.d("number of childs",""+dataSnapshot.getChildrenCount());

                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    if (i < 10) {
                        Log.d("hey guy","im here 2");
                        textViewsName.get(i).setText(child.getKey());
                        textViewsVal.get(i).setText(child.getValue().toString());
                        Log.d("User key", child.getKey());
                        Log.d("User ref", child.getRef().toString());
                        Log.d("User val", child.getValue().toString());
                        i++;
                    }

                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
