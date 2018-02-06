package mx.itesm.behealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FormularioActivity extends AppCompatActivity {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<String> categorias;
    //CategoriaAdapter categoriasAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button fragmen_button_db;
    EditText routine_name_db;
    EditText user_name;
    EditText user_age;
    EditText user_weight;
    Button beginner_button;
    Button medium_button;
    Button expert_button;
    public int user_level;
    String musculo_lunes;
    String musculo_martes;
    String musculo_miercoles;
    String musculo_jueves;
    String musculo_viernes;
    double weight_calentamiento;
    double weight;
    String exercise_1;
    String exercise_2;
    String exercise_3;
    String exercise_4;

    String exercise_1_martes;
    String exercise_2_martes;
    String exercise_3_martes;
    String exercise_4_martes;



    String exercise_1_miercoles;
    String exercise_2_miercoles;
    String exercise_3_miercoles;
    String exercise_4_miercoles;


    String exercise_1_jueves;
    String exercise_2_jueves;
    String exercise_3_jueves;
    String exercise_4_jueves;

    String exercise_1_viernes;
    String exercise_2_viernes;
    String exercise_3_viernes;
    String exercise_4_viernes;
    int series;
    String repeticiones;
    String calentamiento;


    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference Root_reference=firebaseDatabase.getReference();

    EditText peso;
    EditText edad;
    EditText estatura;
    private FirebaseAuth auth;                  //Este es un objeto de tipo FIrebase
    String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

    Button formulario_terminado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        formulario_terminado=(Button)findViewById(R.id.Formulario_terminado_button);
        peso=(EditText)findViewById(R.id.Peso_EditText);
        edad=(EditText)findViewById(R.id.Edad_TextView);
        estatura=(EditText)findViewById(R.id.Estatura_EditText);

        final String peso_usuario = peso.getText().toString();

        formulario_terminado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference peso_db = Root_reference.child("Usuario "+user).child("Peso ");
                DatabaseReference estatura_db = Root_reference.child("Usuario "+user).child("Estatura ");
                DatabaseReference edad_db = Root_reference.child("Usuario "+user).child("Edad ");

                peso_db.setValue(peso.getText().toString());
                estatura_db.setValue(estatura.getText().toString());
                edad_db.setValue(edad.getText().toString());

                //Toast.makeText(getApplicationContext(),"peso "+ peso.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
