package mx.itesm.behealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;


public class Calendario extends AppCompatActivity {
    public String current_user_level;
    Button Done;
    CalendarView calendar;
    String day="";
    String musculo1, musculo2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        Done=(Button)findViewById(R.id.Done_button);


        calendar=(CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMont) {

                //Toast.makeText(getApplicationContext(),dayOfMont+"/"+month+"/"+year,Toast.LENGTH_LONG).show();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMont);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                //Toast.makeText(getApplicationContext(),dayOfWeek+"/",Toast.LENGTH_SHORT).show();
                //Log.d("day of week", String.valueOf(dayOfWeek));


                if(dayOfWeek==1)
                {
                    day="Sunday ";

                }
                else if(dayOfWeek==2)
                {
                    day="Monday ";
                    musculo1="Back";
                    musculo2="Triceps";
                }
                else if(dayOfWeek==3)
                {
                    day="Tuesday ";
                    musculo1="Chest";
                    musculo2="Biceps";
                }
                else if(dayOfWeek==4)
                {
                    day="Wednesday ";
                    musculo1="Leg";
                    musculo2="Abdomen";
                }
                else if(dayOfWeek==5)
                {
                    day="Thursday ";
                    musculo1="Back";
                    musculo2="Triceps";
                }
                else if(dayOfWeek==6)
                {
                    day="Friday ";
                    musculo1="Chest";
                    musculo2="Biceps";
                }
                else if(dayOfWeek==7)
                {
                    day="Saturday ";
                }
                Log.d("current date",day);

                if(dayOfWeek==7 || dayOfWeek==1)
                {
                    Toast.makeText(getApplicationContext(),"Rest for this day",Toast.LENGTH_SHORT).show();
                }
                else {


                    Intent intent = new Intent(Calendario.this, GenerarPlan.class);
                    intent.putExtra("musculo1", musculo1);
                    intent.putExtra("musculo2", musculo2);
                    intent.putExtra("day", day);
                    startActivity(intent);

                    try {
                        Intent user_level_intent = getIntent();

                        current_user_level = user_level_intent.getExtras().getString("current_user_level");
                        intent.putExtra("current_user_level_from_calendar", current_user_level);

                        //Log.d("Hey there!, from CALENDARIO the user level is", current_user_level);
                        startActivity(intent);
                    }
                    catch(Exception e)
                    {
                        Log.d("well","this is embarrasing");
                    }

                }
            }
        });
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Calendario.this, MainActivity.class);
                intent.putExtra("current_user_level_from_calendar_2", current_user_level);
                Toast.makeText(getApplicationContext(), day, Toast.LENGTH_SHORT).show();
                Log.d("day of week",day.toString());
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        // do nothing.
        Intent intent=new Intent(Calendario.this, LogInActivity.class);
        startActivity(intent);

        //Toast.makeText(getApplicationContext(), "Please select one day", Toast.LENGTH_SHORT).show();
    }


}