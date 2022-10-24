package by.Jlevk.sqliteapp.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

import by.Jlevk.sqliteapp.App;
import by.Jlevk.sqliteapp.model.entities.UserModel;

public class UserListViewModel extends ViewModel {

    private List<UserModel> users = App.getInstance().getUserDao().getAllUsers();

    public List<UserModel> getUsers() {
        return users;
    }

}
