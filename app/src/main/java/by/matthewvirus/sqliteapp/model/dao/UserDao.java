package by.matthewvirus.sqliteapp.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import by.matthewvirus.sqliteapp.model.entities.UserModel;

@Dao
public interface UserDao {

    @Query("SELECT * FROM usermodel")
    List<UserModel> getAllUsers();

    @Query("SELECT * FROM usermodel WHERE userId=:id")
    UserModel getUserById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserModel user);

    @Query("UPDATE usermodel SET username = :userName WHERE userId = :userId ")
    void updateUser(String userName, int userId);


}