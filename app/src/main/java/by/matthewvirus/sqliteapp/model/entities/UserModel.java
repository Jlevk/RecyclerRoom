package by.matthewvirus.sqliteapp.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    public int userId;

    public String username;

    public String age;

    public UserModel(String username, String age) {
        this.username = username;
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}