package com.designproject.onlinegrocery.Location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.designproject.onlinegrocery.R;

public class Gps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(isLocationPermissionGranted()){
            Fragment fragment=new GpsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.gps_layout,fragment).commit();
        }
        else {
            requestLocationPermission();
        }
    }
    //check the location permission granted or not
    private boolean isLocationPermissionGranted(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            return true;}
        else {
            return false;}
    }

    //request location permission
    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
    }
}