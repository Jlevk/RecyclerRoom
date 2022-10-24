package by.Jlevk.sqliteapp.ui.about;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import by.Jlevk.sqliteapp.App;

import by.Jlevk.sqliteapp.R;
import by.Jlevk.sqliteapp.model.dao.UserDao;
import by.Jlevk.sqliteapp.ui.list.UserListActivity;

public class MoreActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText userAgeEditText;
    private Button updateUserButton;
    private Button seeUsersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        userNameEditText = findViewById(R.id.user_name_input);

        updateUserButton = findViewById(R.id.update_user_button);
        seeUsersButton = findViewById(R.id.see_users_button);

        int extraUserId = getIntent().getIntExtra("pos", 0) + 1;

        UserDao dao = App.getInstance().getUserDao();

        userNameEditText.setText(dao.getUserById(extraUserId).username);

        updateUserButton.setOnClickListener(view -> dao.updateUser(
                userNameEditText.getText().toString(),
                extraUserId
        ));

        seeUsersButton.setOnClickListener(view -> startActivity(new Intent(
                MoreActivity.this,
                UserListActivity.class)
        ));
    }

}