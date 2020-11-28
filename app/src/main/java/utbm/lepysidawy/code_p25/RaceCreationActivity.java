package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * In this activity, the user can create a race
 * by adding runners to it.
 */
public class RaceCreationActivity extends AppCompatActivity {

    private Spinner runners;
    private Spinner participants;
    private ArrayAdapter<CharSequence> runnersAdapter;
    private ArrayAdapter<CharSequence> participantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_creation);
        this.runners = (Spinner) findViewById(R.id.runners);
        this.participants = (Spinner) findViewById(R.id.participants);
        this.initializeSpinners();
    }

    /**
     * Method which initializes the runners spinner
     */
    public void initializeSpinners(){
        this.runnersAdapter = ArrayAdapter.createFromResource(this,
                R.array.loona, android.R.layout.simple_spinner_item);
        this.runnersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.runners.setAdapter(this.runnersAdapter);
    }

    /**
     * Method launched when the plus button is clicked
     */
    public void onPlusClick(View view) {
        String currentElement = runners.getSelectedItem().toString();
        Log.i("info", currentElement);
        if(this.participantsAdapter == null) {
            ArrayList<CharSequence> newList = new ArrayList<>();
            newList.add(currentElement);
            this.participantsAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    newList);
        } else {
            this.participantsAdapter.add(currentElement);
        }
        this.participantsAdapter.notifyDataSetChanged();
        /**this.runnersAdapter.remove(currentElement);
        this.runnersAdapter.notifyDataSetChanged();
        this.runners.setAdapter(this.runnersAdapter);
        this.participants.setAdapter(this.participantsAdapter);**/
    }

    /**
     * Method launched when the minus button is clicked
     */
    public void onMinusClick(View view){
        /**String currentElement = participants.getSelectedItem().toString();
        this.runnersAdapter.add(currentElement);
        this.runnersAdapter.notifyDataSetChanged();
        this.participantsAdapter.remove(currentElement);
        this.participantsAdapter.notifyDataSetChanged();
        this.runners.setAdapter(this.runnersAdapter);
        this.participants.setAdapter(this.participantsAdapter);**/
    }
}