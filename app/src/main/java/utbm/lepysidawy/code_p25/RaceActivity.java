package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;
import utbm.lepysidawy.code_p25.database.AppDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Activity presenting the displaying of a race
 */
public class RaceActivity extends AppCompatActivity {

    private int seconds;
    private boolean running;
    private int raceId;
    private TextView counter;
    private TextView courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        this.seconds = 0;
        this.running = false;
        this.counter = (TextView)findViewById(R.id.counter);
        this.courseName = (TextView)findViewById(R.id.courseName);
        Bundle b = getIntent().getExtras();
        this.raceId = -1; // or other values
        if(b != null) {
            this.raceId = b.getInt("raceId");
        }
        this.initializeData();
        this.runTimer();
    }

    /**
     * Method used to initialize the different data used for the race
     */
    public void initializeData() {
        AppDatabase db = AppDatabase.getInstance(this);
        this.courseName.setText(db.raceDAO().getRaceName(this.raceId));
    }

    /**
     * Method called when the stopwatch is clicked
     */
    public void activateStopwatch(View view){
        this.running = !this.running;
    }

    /**
     * Method used to handle the stopwatch
     */
    private void runTimer() {
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

                counter.setText(time);

                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

}