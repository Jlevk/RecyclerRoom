package by.Jlevk.sqliteapp.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    public int userId;

    public String username;


    public UserModel(String username) {
        this.username = username;

    }

    @NonNull
    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +

                '}';
    }
}