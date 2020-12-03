package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import utbm.lepysidawy.code_p25.database.AppDatabase;
import utbm.lepysidawy.code_p25.entity.Runner;

/**
 * Main screen of the application.
 * Allows the user to create a race, a runner, display the stats or leave the app
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getInstance(this);
        Log.d("App","Running");


        List<Runner> runners = db.runnerDAO().getAll();
        for(Runner r : runners){
            db.runnerDAO().delete(r);
        }

        Runner wonho = new Runner(1,"Lee","Ho-seok",80);
        Runner yeojin = new Runner(2,"Lim","Yeojin",40);
        db.runnerDAO().insertAll(wonho,yeojin);

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