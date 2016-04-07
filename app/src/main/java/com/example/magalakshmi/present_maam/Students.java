package com.example.magalakshmi.present_maam;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Students extends AppCompatActivity {
    Button b1, b2, b3, b4;
    EditText st1;
    int count = 0, count1 = 0;
    Presentdb pp;
    Cursor rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b1 = (Button) findViewById(R.id.button9);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button7);
        b4 = (Button) findViewById(R.id.button8);
        pp = new Presentdb(this);
        //st1=(EditText)findViewById(R.id.editText3);
        String r1 = st1.getText().toString();
        rs = pp.Retrive(r1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_COARSE);
                criteria.setPowerRequirement(Criteria.POWER_LOW);
                Context context = null;
                LocationManager locManager =
                        (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                if (locManager.getBestProvider(criteria, true) != null) {
                    if ((ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                        if ((ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                    }
                    Location myLocation = locManager.getLastKnownLocation(locManager.getBestProvider(criteria, true));
                    String latitude = Double.toString(myLocation.getLatitude());
                    String longitude = Double.toString(myLocation.getLongitude());
                    String altitude = Double.toString(myLocation.getAltitude());
                    pp.Store1(latitude,longitude);
                    count++;

                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_COARSE);
                criteria.setPowerRequirement(Criteria.POWER_LOW);
                Context context = null;
                LocationManager locManager =
                        (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                if (locManager.getBestProvider(criteria, true) != null) {
                    if ((ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                        if ((ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                    }
                    Location myLocation = locManager.getLastKnownLocation(locManager.getBestProvider(criteria, true));
                    String latitude = Double.toString(myLocation.getLatitude());
                    String longitude = Double.toString(myLocation.getLongitude());
                    String altitude = Double.toString(myLocation.getAltitude());
                    pp.Store1(latitude,longitude);
                    int count = 0, count1 = 0;
                    count1++;
                }
            }
        });
            b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(rs.moveToNext()) {
                   String id = rs.getString(0);
                    int chin= rs.getInt(1);
                    int  chout=rs.getInt(2);
                    chin=count;
                    chout=count1;
                    int attper1= ((chin+chout)/2)*100;
                    pp.Store(id,chin,chout,attper1);
                    Toast.makeText(getApplicationContext(), "Attendance percentage="+attper1, Toast.LENGTH_LONG).show();
                }
            }
        });

        setContentView(R.layout.activity_students);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
