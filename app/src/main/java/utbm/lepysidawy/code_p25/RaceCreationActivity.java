package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import utbm.lepysidawy.code_p25.database.AppDatabase;
import utbm.lepysidawy.code_p25.entity.Runner;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * In this activity, the user can create a race
 * by adding runners to it.
 */
public class RaceCreationActivity extends AppCompatActivity {

    private Spinner runners;
    private Spinner participants;
    private EditText courseName;
    private ArrayAdapter<Runner> runnersAdapter;
    private ArrayAdapter<Runner> participantsAdapter;
    private ArrayList<Runner> runnersList;
    private ArrayList<Runner> participantsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_creation);
        this.runners = (Spinner) findViewById(R.id.runners);
        this.participants = (Spinner) findViewById(R.id.participants);
        this.courseName = (EditText) findViewById(R.id.courseName);
        this.runnersList = new ArrayList<>();
        this.participantsList = new ArrayList<>();
        AppDatabase db = AppDatabase.getInstance(this);
        List<Runner> runners = db.runnerDAO().getAll();
        this.runnersList.addAll(runners);
        this.initializeSpinners();
    }

    /**
     * Method which initializes the runners spinner
     */
    public void initializeSpinners(){
        this.runnersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.runnersList);
        this.runnersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.runners.setAdapter(this.runnersAdapter);
        this.participantsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.participantsList);
        this.participantsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.participants.setAdapter(this.participantsAdapter);
    }

    /**
     * Method launched when the plus button is clicked
     * CAN BE IMPROVED BY USING A CUSTOM SUBCLASS OF ARRAYADAPTER TO STORE THE LIST
     */
    public void onPlusClick(View view) {
        Runner currentElement = (Runner)runners.getSelectedItem();
        this.participantsList.add(currentElement);
        this.participantsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.participantsList);
        this.participants.setAdapter(this.participantsAdapter);
        this.runnersList.remove(currentElement);
        this.runnersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.runnersList);
        this.runners.setAdapter(this.runnersAdapter);
    }

    /**
     * Method launched when the minus button is clicked
     */
    public void onMinusClick(View view){
        Runner currentElement = (Runner)participants.getSelectedItem();
        this.runnersList.add(currentElement);
        this.runnersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.runnersList);
        this.runners.setAdapter(this.runnersAdapter);
        this.participantsList.remove(currentElement);
        this.participantsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.participantsList);
        this.participants.setAdapter(this.participantsAdapter);
    }

    /**
     * Method used to a validate a race
     * The user must pick a number of runners which is a multiple of 3
     * and is <= 36
     * @param view
     */
    public void validateRace(View view) {
        if(this.participantsList.size()%3 == 0 && this.participantsList.size() <= 36) {
            //this.createRace(1, this.courseName.getText().toString());
            //this.createTeams();
        } else {
            this.showErrorMessage();
        }
    }

    /**
     * Method used to launch an error message in case
     * the user chooses the wrong number of runners
     */
    public void showErrorMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Attention !");
        alertDialog.setMessage("Le nombre de coureurs que vous avez sélectionné est incorrect. Veuillez sélectionner suffisamment de coureurs" +
                        " pour remplir de une à douze équipes de trois.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alertDialog.show();
    }

    /**
     * Method used to create the different teams
     */
    public void createTeams() {
        /**ArrayList<Team> teams = new ArrayList<>();
        for(int i = 0; i < this.participantsList.size()/3; i++) {
            Team newTeam = new Team(i, 1);
            for(int j = 0; j < 3; j++) {
                Runner selected = this.participantsList.get(new Random().nextInt(this.participantsList.size()));
            }
        }**/
    }

    /**
     * Method used to create the race and insert it in the database
     * Returns the race ID
     */
    public void createRace(int raceId, String raceName) {
        /**AppDatabase db = AppDatabase.getInstance(this);
        db.raceDAO().insert(new Race(raceId, raceName));**/
    }


}