package com.app.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView intentListView = (ListView) findViewById(R.id.listView1);

        final ArrayList<ContactObject> list = new ArrayList<ContactObject>();

        list.add(new ContactObject("Epi-Tec", "73296060", "contact@episousse.com", "http://whatever"));
        list.add(new ContactObject("Epi-MA", "73296060", "contact@episousse.com", "http://whatever_again"));

        List<String> listName = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            listName.add(list.get(i).getName());
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listName);
        intentListView.setAdapter(adapter);


        intentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ContactIntentAcivity.class);
                i.putExtra("Object", list.get(position));
                startActivityForResult(i, 0);
            }
        });

    }
}