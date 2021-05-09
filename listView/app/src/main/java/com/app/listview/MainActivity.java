package com.app.listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.listview.model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> list = new ArrayList<Contact>();
    private List<String> listName = new ArrayList<>();
    public int LAUNCH_ADD_ACTIVITY = 1;
    private ListView listView;
    private FloatingActionButton addContactBtn;
    private SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences =  getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        listView = findViewById(R.id.listView1);
        addContactBtn = findViewById(R.id.add_contact);

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(i, LAUNCH_ADD_ACTIVITY);
            }
        });


        setAdapterToListView();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ContactInfoAcivity.class);
                i.putExtra("Object", list.get(position));
                startActivityForResult(i, 0);
            }
        });

    }

    private ArrayList<String> convertToListName(List<Contact> list ){
        ArrayList<String> contacts = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            contacts.add(list.get(i).getName());
        }
        return contacts;

    }

    private void setAdapterToListView() {
        ArrayAdapter<String> adapter;
        String res = sharedpreferences.getString("list",null);
        if (res!=null) {
            TypeToken<List<Contact>> token = new TypeToken<List<Contact>>() {};
            list = new Gson().fromJson(res, token.getType());
            adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, convertToListName(list));
            listView.setAdapter(adapter);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_ADD_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                Contact contact = (Contact) data.getSerializableExtra(AddContactActivity.EXTRA_CONTACT);
                list.add(contact);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("list", new Gson().toJson(list));
                editor.commit();
                setAdapterToListView();
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}