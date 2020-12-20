package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import utbm.lepysidawy.code_p25.database.AppDatabase;
import utbm.lepysidawy.code_p25.entity.Race;

public class HistoryActivity extends AppCompatActivity {


    private void initializeView()
    {
        LinearLayout v = findViewById(R.id.history_layout);
        AppDatabase db = AppDatabase.getInstance(this);
        List<Race> races = db.raceDAO().getAll();

        for(Race r : races)
        {
            ViewRace vr = new ViewRace(getApplicationContext(),r, null);
            v.addView(vr);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initializeView();
    }

    /**
     * Method used to finish the activity and go back to the main screen
     * @param view
     */
    public void finish (View view) {
        super.finish();
    }

}