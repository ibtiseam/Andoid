package com.app.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.app.listview.model.Contact;

public class ContactInfoAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        TextView contactName = (TextView) findViewById(R.id.contactName);
        TextView contactEmail = (TextView) findViewById(R.id.contactEmail);
        TextView contactPhone = (TextView) findViewById(R.id.contactPhone);
        TextView contactWebsite = (TextView) findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();
        if ( extras == null ) {
            return;
        }

        Contact co = (Contact) getIntent().getSerializableExtra("Object");
        contactName.setText("Name: "+ co.getName());
        contactEmail.setText("Email: "+ co.getEmail());
        contactPhone.setText("Phone: "+ co.getPhone());
        contactWebsite.setText("Website: "+ co.getWebsite());

    }
}