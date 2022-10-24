package com.example.myapplication335;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication335.db.AppDatabase;
import com.example.myapplication335.db.Person;
import com.example.myapplication335.db.PersonDao;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<String> names = new ArrayList<>();
    private EditText nameEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "person-database").allowMainThreadQueries().build();

        nameEdit = findViewById(R.id.name_input);

        Button AddButton = findViewById(R.id.add_button);
        Button BackButton = findViewById(R.id.back_button);
        ListView nameList = findViewById(R.id.listView);
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, names);

        // устанавливаем для списка адаптер
        nameList.setAdapter(adapter);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v)  {

                Person jo = new Person("jonny silverhand");
                Person V = new Person("V");
                Person smasher = new Person("Adam Smasher");
                db.personDao().insertPerson(jo, V, smasher);
                List <Person> personList = db.personDao().getAllPersons();
                names.clear();
                for (Person list: personList) {
                    Log.d("who?", list.firstname);//вывод
                    names.add(" samurai: "+ list.firstname);
                }
                nameList.setVisibility(View.VISIBLE);
                nameEdit.setVisibility(View.GONE);

                AddButton.setVisibility(View.GONE);
                BackButton.setVisibility(View.VISIBLE);
            }
        };
        View.OnClickListener backBut = new View.OnClickListener() {
            @Override
            public void onClick(View v)  {

                nameList.setVisibility(View.GONE);
                nameEdit.setVisibility(View.VISIBLE);

                AddButton.setVisibility(View.VISIBLE);
                BackButton.setVisibility(View.GONE);
            }
        };

        // присвоим обработчик кнопке OK (btnOk)
        AddButton.setOnClickListener(oclBtnOk);
        BackButton.setOnClickListener(backBut);

    }


}