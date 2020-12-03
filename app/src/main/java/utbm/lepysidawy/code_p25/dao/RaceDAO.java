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

    @Insert
    void insert(Race race);

    @Delete
    void delete(Race race);

}
