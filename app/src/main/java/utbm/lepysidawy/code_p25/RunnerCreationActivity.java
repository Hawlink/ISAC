package utbm.lepysidawy.code_p25;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

/**
 * In this activity, the user can create a runner by
 * entering its name, first name and level between 1 and 100
 */
public class RunnerCreationActivity extends AppCompatActivity {

    private NumberPicker levelPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_creation);
        this.levelPicker = findViewById(R.id.levelPicker);
        this.pickerInitialization();
    }

    /**
     * Method which initializes the picker
     */
    public void pickerInitialization() {
        this.levelPicker.setMaxValue(100);
        this.levelPicker.setMinValue(1);
    }
}