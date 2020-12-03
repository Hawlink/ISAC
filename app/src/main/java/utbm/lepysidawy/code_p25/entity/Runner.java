package utbm.lepysidawy.code_p25.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Runner {

    @PrimaryKey
    private int idPlayer;

    @ColumnInfo(name = "FIRST_NAME")
    private String firstName;

    @ColumnInfo(name = "LAST_NAME")
    private String lastName;

    @ColumnInfo(name = "LEVEL")
    private int niveau;

    public Runner(int idPlayer, String firstName, String lastName, int niveau){
        this.idPlayer = idPlayer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.niveau = niveau;
    }

    public int getIdPlayer(){
        return idPlayer;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getNiveau(){
        return niveau;
    }



}
