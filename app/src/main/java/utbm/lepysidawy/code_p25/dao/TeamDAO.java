package utbm.lepysidawy.code_p25.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import utbm.lepysidawy.code_p25.entity.Team;

@Dao
public interface TeamDAO {

    @Query("SELECT * FROM Team")
    List<Team> getAll();

    @Insert
    void insert(Team team);

    @Delete
    void delete(Team team);

}
