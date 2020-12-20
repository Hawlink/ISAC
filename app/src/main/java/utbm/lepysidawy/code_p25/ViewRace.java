package utbm.lepysidawy.code_p25;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import utbm.lepysidawy.code_p25.entity.Race;

public class ViewRace extends LinearLayout implements View.OnClickListener {

    private Race race;

    public Race getRace(){
        return race;
    }

    public ViewRace(Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(attrs,context);
    }

    public ViewRace(Context context, Race race, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        this.race = race;
        init(attrs,context);
    }

    public ViewRace(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context,attrs,defStyleAttr);
        init(attrs,context);

    }

    private void init(@Nullable AttributeSet set, final Context context){

        LinearLayout globalLayout = new LinearLayout(getContext());
        globalLayout.setOrientation(LinearLayout.HORIZONTAL);
        globalLayout.setGravity(Gravity.CENTER);
        globalLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tvRaceName = new Button(new ContextThemeWrapper(getContext(), R.style.textView), null, 0);
        tvRaceName.setLayoutParams(new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.MATCH_PARENT));
        tvRaceName.setText(race.getName());
        tvRaceName.setGravity(Gravity.CENTER_VERTICAL);
        globalLayout.addView(tvRaceName);

        Button btnRace = new Button(new ContextThemeWrapper(getContext(), R.style.mainActivityButton), null, 0);
        btnRace.setLayoutParams(new LinearLayout.LayoutParams(175, 45));
        btnRace.setText(R.string.course_Stats);
        btnRace.setOnClickListener(this);
        btnRace.setTag(race.getIdRace());
        globalLayout.addView(btnRace);

        addView(globalLayout);
    }

    public void onClick(View v) {
        int raceId = Integer.parseInt(v.getTag().toString());
        Intent intent = new Intent(getContext(), StatsActivity.class);
        Bundle b = new Bundle();
        b.putInt("raceId", raceId);
        intent.putExtras(b);
        getContext().startActivity(intent);
    }

}
