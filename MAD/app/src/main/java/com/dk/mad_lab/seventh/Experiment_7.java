package com.dk.mad_lab.seventh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.*;
import com.google.android.gms.tasks.*;
import com.dk.mad_lab.R;

public class Experiment_7 extends AppCompatActivity implements LocationListener {
    LocationManager manager;
    private TextView latitude, longitude;
    @Override
    public void onFlushComplete(int requestCode) {
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
    }

    String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment7);

        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        Button getLocation = findViewById(R.id.getLocation);

        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLocationPermission(permissions, 100);
                locationRequest();}});
    }

    private void checkLocationPermission(String[] locationPermission, int i) {
        if ((ContextCompat.checkSelfPermission(Experiment_7.this, locationPermission[0]) == PackageManager.PERMISSION_DENIED) &&
                (ContextCompat.checkSelfPermission(Experiment_7.this, locationPermission[1]) == PackageManager.PERMISSION_DENIED)) {
            ActivityCompat.requestPermissions(Experiment_7.this, locationPermission, i);}
    }

    private void locationRequest() {
        manager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(request);

        SettingsClient settingsClient = LocationServices.getSettingsClient(Experiment_7.this);
        checkLocationPermission(permissions, 100);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, (LocationListener) Experiment_7.this);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, (LocationListener) Experiment_7.this);

        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());
        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException){
                    try{
                        ResolvableApiException exception = (ResolvableApiException) e;
                        exception.startResolutionForResult(Experiment_7.this, 0x1);
                    } catch (Exception e1){e1.printStackTrace();}}}});
        Toast.makeText(this, "Please Wait.! Until the location will appear.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        try{
            latitude.setText(String.valueOf(location.getLatitude()));
            latitude.setTextColor(Color.RED);
            longitude.setText(String.valueOf(location.getLongitude()));
            longitude.setTextColor(Color.RED);} catch(Exception e){e.printStackTrace();}
    }
}