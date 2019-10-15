package com.example.sqlitedatabase13.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.sqlitedatabase13.R;
import com.example.sqlitedatabase13.adapter.UserAdapter;
import com.example.sqlitedatabase13.database.SqliteHelper;
import com.example.sqlitedatabase13.model_class.User;

import java.util.ArrayList;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private SqliteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        init();

        showData();
    }

    private void showData() {
        Cursor cursor = helper.showdata();

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));

            userList.add(new User(id,name,age));
            adapter.notifyDataSetChanged();
        }
    }

    private void init() {
        userList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        helper = new SqliteHelper(this);
    }
}
