package utbm.lepysidawy.code_p25.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {

    @PrimaryKey
    private int idTeam;

    @ColumnInfo(name = "ID_RACE")
    private int idRace;

    public Team(int idTeam, int idRace){
        this.idTeam = idTeam;
        this.idRace = idRace;
    }

    public int getIdTeam(){
        return idTeam;
    }

    public int getIdRace() {
        return idRace;
    }
}
