package utbm.lepysidawy.code_p25.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Race {

    @PrimaryKey
    private int idRace;

    @ColumnInfo(name = "NAME")
    private String name;

    public Race(int idRace, String name){
        this.idRace = idRace;
        this.name = name;
    }

    public int getIdRace(){
        return idRace;
    }

    public String getName(){
        return name;
    }

}
