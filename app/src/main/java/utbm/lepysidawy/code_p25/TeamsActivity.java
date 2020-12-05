package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;
import utbm.lepysidawy.code_p25.entity.Team;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * This activity allows the user to see all teams
 * for a race and consult the order of the participants
 */
public class TeamsActivity extends AppCompatActivity {

    private Spinner teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        this.teams = (Spinner) findViewById(R.id.runners);
        this.initializeTeams();
    }

    /**
     * Method used to initialize the different teams of the race
     */
    public void initializeTeams() {
        ArrayList<CharSequence> teams = new ArrayList<>();
    }
}