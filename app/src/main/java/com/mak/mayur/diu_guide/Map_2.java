package com.mak.mayur.diu_guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import android.content.Context;

import android.location.Location;
import android.location.LocationManager;
import com.google.android.gms.common.ConnectionResult;
import android.graphics.Color;
//import com.google.android.gms.maps.model.CircleOptions;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;




public class Map_2 extends Fragment {


    MapView mapView;
    GoogleMap map;
    LatLng CENTER = null;

    public LocationManager locationManager;

    double longitudeDouble;
    double latitudeDouble;

    String snippet;
    String title;
    Location location;
    String myAddress;

    String LocationId;
    String CityName;
    String imageURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater
                .inflate(R.layout.fragment_map_2, container, false);

        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        setMapView();

        return view;
    }

    private void setMapView() {
        try {
            MapsInitializer.initialize(getActivity());

            switch (GooglePlayServicesUtil
                    .isGooglePlayServicesAvailable(getActivity())) {
                case ConnectionResult.SUCCESS:
                    // Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT)
                    // .show();

                    // Gets to GoogleMap from the MapView and does initialization
                    // stuff
                    if (mapView != null) {

                        locationManager = ((LocationManager) getActivity()
                                .getSystemService(Context.LOCATION_SERVICE));

                        Boolean localBoolean = Boolean.valueOf(locationManager
                                .isProviderEnabled("network"));

                        if (localBoolean.booleanValue()) {
                            double latitude = 17.385044;
                            double longitude = 78.486671;

                            CENTER = new LatLng(latitude, longitude);

                        } else {

                        }
                        map = mapView.getMap();
                        if (map == null) {

                            Log.d("", "Map Fragment Not Found or no Map in it!!");

                        }

                        map.clear();
                  /*      try {
                            map.addMarker(new MarkerOptions().position(CENTER)
                                    .title(CityName).snippet(""));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
*/
                        map.setIndoorEnabled(true);
                        map.setMyLocationEnabled(true);
                        map.moveCamera(CameraUpdateFactory.zoomTo(5));
                        if (CENTER != null) {
                            map.animateCamera(
                                    CameraUpdateFactory.newLatLng(CENTER), 1750,
                                    null);
                        }
                        // add circle
                        CircleOptions circle = new CircleOptions();
                        circle.center(CENTER).fillColor(Color.BLUE).radius(10);
                        map.addCircle(circle);
                        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    }
                    break;
                case ConnectionResult.SERVICE_MISSING:

                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:

                    break;
                default:

            }
        } catch (Exception e) {

        }

    }
}