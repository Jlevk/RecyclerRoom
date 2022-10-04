package by.matthewvirus.sqliteapp.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import by.matthewvirus.sqliteapp.model.dao.UserDao;
import by.matthewvirus.sqliteapp.model.entities.UserModel;

@Database(entities = {UserModel.class}, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

}
