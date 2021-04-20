package com.app.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactIntentAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_intent_acivity);

        TextView contactName = (TextView) findViewById(R.id.contactName);
        TextView contactEmail = (TextView) findViewById(R.id.contactEmail);
        TextView contactPhone = (TextView) findViewById(R.id.contactPhone);
        TextView contactWebsite = (TextView) findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();
        if ( extras == null ) {
            return;
        }

        ContactObject co = (ContactObject) getIntent().getSerializableExtra("Object");
        contactName.setText("Name: "+ co.getName());
        contactEmail.setText("Email: "+ co.getEmail());
        contactPhone.setText("Phone: "+ co.getPhone());
        contactWebsite.setText("Website: "+ co.getWebsite());

    }
}