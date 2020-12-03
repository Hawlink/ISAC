package utbm.lepysidawy.code_p25.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"ID_RUNNER","ID_RACE"})
public class RunnerRace {

    @ColumnInfo(name = "ID_RUNNER")
    private int idRunner;
    @ColumnInfo(name = "ID_RACE")
    private int idRace;
    @ColumnInfo(name = "SPRINT1")
    private float sprint1;
    @ColumnInfo(name = "OBSTACLE1")
    private float obstacle1;
    @ColumnInfo(name = "PIT_STOP")
    private float pitStop;
    @ColumnInfo(name = "SPRINT2")
    private float sprint2;
    @ColumnInfo(name = "OBSTACLE2")
    private float obstacle2;

    public RunnerRace(int idRunner, int idRace, float sprint1, float obstacle1, float pitStop, float sprint2, float obstacle2) {
        this.idRunner = idRunner;
        this.idRace = idRace;
        this.sprint1 = sprint1;
        this.obstacle1 = obstacle1;
        this.pitStop = pitStop;
        this.sprint2 = sprint2;
        this.obstacle2 = obstacle2;
    }

    public float getObstacle2() {
        return obstacle2;
    }

    public float getSprint2() {
        return sprint2;
    }

    public float getPitStop() {
        return pitStop;
    }

    public float getObstacle1() {
        return obstacle1;
    }

    public float getSprint1() {
        return sprint1;
    }

    public int getIdRace() {
        return idRace;
    }

    public int getIdRunner() {
        return idRunner;
    }
}
