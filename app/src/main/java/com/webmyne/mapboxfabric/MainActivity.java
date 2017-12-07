package com.webmyne.mapboxfabric;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.mapboxsdk.Mapbox;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Button btnAddMarker;
    private Button btnSupportMap;
    private Button btnStylingMap;
    private Button btnMapCamera;
    private Button btnAnnotations;
    private Button btn3DExtrusions;
    private Button btnDataDrivenStyling;
    private Button btnOfflineMap;
    private Button btnQueryMap;
    private Button btnMapNavigation;
    private static final Integer LOCATION = 0x1;
    private Button btnGeoCodingMap;
    private Button btnDirection;
    private Button btnElection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this);
        Mapbox.getInstance(this, getString(R.string.com_mapbox_mapboxsdk_accessToken));
        setContentView(R.layout.activity_main);
        askForPermission(Manifest.permission.ACCESS_FINE_LOCATION,LOCATION);
        askForPermission(Manifest.permission.ACCESS_COARSE_LOCATION,LOCATION);
        init();
        actionListener();

    }

    private void init() {
        btnAddMarker = (Button) findViewById(R.id.btnAddMarker);
        btnSupportMap = (Button) findViewById(R.id.btnSupportMap);
        btnStylingMap = (Button) findViewById(R.id.btnStylingMap);
        btnMapCamera = (Button) findViewById(R.id.btnMapCamera);
        btnAnnotations = (Button) findViewById(R.id.btnAnnotations);
        btn3DExtrusions = (Button) findViewById(R.id.btn3DExtrusions);
        btnDataDrivenStyling = (Button) findViewById(R.id.btnDataDrivenStyling);
        btnOfflineMap = (Button) findViewById(R.id.btnOfflineMap);
        btnQueryMap = (Button) findViewById(R.id.btnQueryMap);
        btnMapNavigation = (Button) findViewById(R.id.btnMapNavigation);
        btnGeoCodingMap = (Button) findViewById(R.id.btnGeoCodingMap);
        btnDirection = (Button) findViewById(R.id.btnDirection);
        btnElection = (Button) findViewById(R.id.btnElection);
    }

    private void actionListener() {
        btnAddMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddMarker = new Intent(MainActivity.this, AddMarkerActivity.class);
                startActivity(intentAddMarker);
            }
        });

        btnSupportMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSupportMap = new Intent(MainActivity.this, SupportMapFragmentActivity.class);
                startActivity(intentSupportMap);
            }
        });

        btnStylingMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnMapCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnAnnotations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btn3DExtrusions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnDataDrivenStyling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnOfflineMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnQueryMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, StylingMapActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnMapNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, MapNavigationActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnGeoCodingMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, GeocodingActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, DirectionsActivity.class);
                startActivity(intentStylingMap);
            }
        });

        btnElection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStylingMap = new Intent(MainActivity.this, ReciptActivity.class);
                startActivity(intentStylingMap);
            }
        });


    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

}
