package com.example.hp.s_100;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference MyRefDB;

    public static final String EXTRA_WASHNO = "washNo";
    private String str_name_service;
    private EditText name;
    private EditText full_name;
    private EditText full_name_2;
    private EditText e_mail;
    private EditText phone;
    private EditText marka_model_auto;
    private Spinner type_engine;
    private Spinner capacity_engine;
    private Spinner type_body;
    private EditText name_service;
    private Spinner type_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        name = (EditText) findViewById(R.id.name);
        full_name = (EditText) findViewById(R.id.full_name);
        full_name_2 = (EditText) findViewById(R.id.full_name_2);
        e_mail = (EditText) findViewById(R.id.e_mail);
        phone = (EditText) findViewById(R.id.phone);
        marka_model_auto = (EditText) findViewById(R.id.marka_model_auto);
        type_engine = (Spinner) findViewById(R.id.type_engine);
        capacity_engine = (Spinner) findViewById(R.id.capacity_engine);
        type_body = (Spinner) findViewById(R.id.type_body);
        name_service = (EditText) findViewById(R.id.name_service);
        type_payment = (Spinner) findViewById(R.id.type_payment);

        Button btn_create_order = (Button) findViewById(R.id.btn_create_order);

        Intent intent = getIntent();
        str_name_service = intent.getStringExtra(EXTRA_WASHNO);
        name_service.setText(str_name_service);
        name_service.setRawInputType(0x00000000);

        MyRefDB = FirebaseDatabase.getInstance().getReference();

        btn_create_order.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы уверены, что ввели правильные данные?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Order order = new Order(name.getText().toString(),
                                full_name.getText().toString(),
                                full_name_2.getText().toString(),
                                e_mail.getText().toString(),
                                phone.getText().toString(),
                                marka_model_auto.getText().toString(),
                                type_engine.getSelectedItem().toString(),
                                capacity_engine.getSelectedItem().toString(),
                                type_body.getSelectedItem().toString(),
                                name_service.getText().toString(),
                                type_payment.getSelectedItem().toString());

                        MyRefDB.child("order").push().setValue(order);
                        Toast.makeText(getApplicationContext(), "Ваш заказ принят. Ожидайте", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
