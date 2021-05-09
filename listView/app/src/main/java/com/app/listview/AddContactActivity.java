package com.app.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.listview.model.Contact;

public class AddContactActivity extends AppCompatActivity {

    private EditText mNom;
    private EditText mNum;
    private EditText mMail;
    private EditText mWeb;
    private Button addBtn;


    public static String EXTRA_CONTACT = "contact";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        mNom = findViewById(R.id.et_nom);
        mNum = findViewById(R.id.et_num);
        mMail = findViewById(R.id.et_mail);
        mWeb = findViewById(R.id.et_website);



        addBtn = findViewById(R.id.add_contact_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);

                getSupportActionBar().setTitle("Ajouter contact");
                String nom = mNom.getText().toString();
                String num = mNum.getText().toString();
                String mail = mMail.getText().toString() ;
                String web = mWeb.getText().toString();

                Contact contact = new Contact(nom,num,mail,web);
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_CONTACT,contact);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}