package com.example.magalakshmi.present_maam;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class stafflogin extends AppCompatActivity {
    Button d1;
    EditText t3, t4;
    Presentdb pp;
    Cursor rp;
    String r1;
    String r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);
        t3 = (EditText) findViewById(R.id.editText);
        t4 = (EditText) findViewById(R.id.editText2);


         r1=t3.getText().toString();
         r2=t4.getText().toString();
        d1=(Button)findViewById(R.id.button3);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pp=new Presentdb(getApplicationContext());
                 pp.Retrive(r1);
                if (rp.moveToNext()) {
                    if (r1.equals(rp.getString(0)) && r2.equals(rp.getString(1))) {
                        Toast.makeText(getApplicationContext(), "Welcome User", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Staffs.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "INVALID USER", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    }
