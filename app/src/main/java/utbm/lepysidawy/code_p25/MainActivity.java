package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utbm.lepysidawy.code_p25.database.AppDatabase;
import utbm.lepysidawy.code_p25.entity.ParticipateRace;
import utbm.lepysidawy.code_p25.entity.Race;
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

        List<ParticipateRace> participations = db.participateRaceDAO().getAll();
        for(ParticipateRace p : participations){
            db.participateRaceDAO().delete(p);
        }

        List<Runner> runners = db.runnerDAO().getAll();
        for(Runner r : runners){
            db.runnerDAO().delete(r);
        }

        List<Race> races = db.raceDAO().getAll();
        for(Race r : races){
            db.raceDAO().delete(r);
        }

        Runner wonho = new Runner("Lee","Ho-seok",80);
        Runner yeojin = new Runner("Lim","Yeojin",40);
        Runner heejin = new Runner("Jeon","Heejin",90);
        Runner hyunjin = new Runner("Kim","Hyunjin",95);
        Runner haseul = new Runner("Cho","Haseul",70);
        Runner vivi = new Runner("Wong","Ka-Hei",90);
        Runner yves = new Runner("Ha","Soo Young",75);
        Runner chuu = new Runner("Kim","Jiwoo",80);
        Runner choerry = new Runner("Choi","Yerim",78);


        long[] runnerIds = db.runnerDAO().insertAll(wonho,yeojin,heejin, hyunjin, haseul, vivi, yves, chuu, choerry);
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