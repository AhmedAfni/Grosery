package com.designproject.onlinegrocery.Location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.designproject.onlinegrocery.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                        mMap=googleMap;
                        LatLng location = new LatLng(7.683647252334101, 81.72710164256371);
                        mMap.addMarker(new MarkerOptions().position(location).title("Online Grocery, Kattankudy Branch"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,18.0f));
                        mMap.getUiSettings().setZoomControlsEnabled(true);

                };

        });
        return view;
    }
}