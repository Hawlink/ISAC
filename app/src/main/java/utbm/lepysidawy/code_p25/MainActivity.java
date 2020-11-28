package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Main screen of the application.
 * Allows the user to create a race, a runner, display the stats or leave the app
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRaceCreationClick(View view) {
        Intent intent = new Intent(this, RaceCreationActivity.class);
        startActivity(intent);
    }

    public void onRunnerCreationClick(View view) {
        Intent intent = new Intent(this, RunnerCreationActivity.class);
        startActivity(intent);
    }

    public void closeApp(View view) {
        this.finishAndRemoveTask();
    }


}