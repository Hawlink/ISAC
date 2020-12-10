package utbm.lepysidawy.code_p25.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import utbm.lepysidawy.code_p25.entity.Race;

@Dao
public interface RaceDAO {

    @Query("SELECT * FROM Race")
    List<Race> getAll();

    @Query("SELECT RACE.NAME FROM Race WHERE RACE.idRace = :raceId")
    String getRaceName(int raceId);

    @Insert
    void insert(Race race);

    @Delete
    void delete(Race race);

}
