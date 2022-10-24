package by.Jlevk.sqliteapp.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import by.Jlevk.sqliteapp.R;
import by.Jlevk.sqliteapp.adapters.UserAdapter;
import by.Jlevk.sqliteapp.ui.MainActivity;
import by.Jlevk.sqliteapp.ui.about.MoreActivity;

public class UserListActivity extends AppCompatActivity {

    private RecyclerView usersListRecyclerView;
    private FloatingActionButton addNewUserFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        by.Jlevk.sqliteapp.ui.list.UserListViewModel viewModel =
                new ViewModelProvider(this).get(by.Jlevk.sqliteapp.ui.list.UserListViewModel.class);
        UserAdapter.OnUserClickListener userClickListener = (user, position) -> {
            Intent intent = new Intent(UserListActivity.this, MoreActivity.class);
            intent.putExtra("pos", position);
            startActivity(intent);
        };
        UserAdapter adapter = new UserAdapter(this, viewModel.getUsers(), userClickListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        usersListRecyclerView = findViewById(R.id.users_recycler_view);
        addNewUserFloatingActionButton = findViewById(R.id.add_user_fab);

        usersListRecyclerView.setLayoutManager(layoutManager);
        usersListRecyclerView.setAdapter(adapter);

        addNewUserFloatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(UserListActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

}