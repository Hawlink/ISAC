package utbm.lepysidawy.code_p25.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"ID_RUNNER","ID_TEAM"})
public class BelongToTeam {

    @ColumnInfo(name = "ID_RUNNER")
    private int idRunner;
    @ColumnInfo(name = "ID_TEAM")
    private int idTeam;
    @ColumnInfo(name = "RUNNING_ORDER")
    private int runningOrder;

    public BelongToTeam(int idRunner, int idTeam, int runningOrder) {
        this.idRunner = idRunner;
        this.idTeam = idTeam;
        this.runningOrder = runningOrder;
    }

    public int getRunningOrder() {
        return runningOrder;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public int getIdRunner() {
        return idRunner;
    }
}
