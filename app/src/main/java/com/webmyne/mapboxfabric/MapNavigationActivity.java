package com.webmyne.mapboxfabric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.commons.models.Position;

public class MapNavigationActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.com_mapbox_mapboxsdk_accessToken));
        MapboxNavigation navigation = new MapboxNavigation(this, getString(R.string.com_mapbox_mapboxsdk_accessToken));
        setContentView(R.layout.activity_query_feature);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {
                Position origin = Position.fromCoordinates(-77.03613, 38.90992);
                Position destination = Position.fromCoordinates(-77.07458, 38.90894);

                // Pass in your Amazon Polly pool id for speech synthesis using Amazon Polly
                // Set to null to use the default Android speech synthesizer
                String awsPoolId = null;

                // This will animate the application to simulate a driver following the route
                boolean simulateRoute = true;

                // Call this method with Context from within an Activity
                 //NavigationLauncher.startNavigation(MapNavigationActivity.this, origin, destination, awsPoolId, simulateRoute);
            }
        });
    }

    // Add the mapView's own lifecycle methods to the activity's lifecycle methods
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
