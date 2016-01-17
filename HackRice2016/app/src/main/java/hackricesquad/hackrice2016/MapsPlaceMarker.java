package hackricesquad.hackrice2016;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPlaceMarker extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static LatLng coordinates = new LatLng(0,0);

    public static LatLng getCoordinates(){
        return coordinates;
    }

    private class OMCL implements GoogleMap.OnMapClickListener{
        @Override
        public void onMapClick(LatLng latLng) {

            coordinates = latLng;
Log.d("test", "coordinates: " + coordinates);
            // Creating a marker
            MarkerOptions markerOptions = new MarkerOptions();

            // Setting the position for the marker
            markerOptions.position(latLng);

            // Setting the title for the marker.
            // This will be displayed on tapping the marker
            markerOptions.title("LINK WITH REMINDER?");

            // Clears the previously touched position
            mMap.clear();

            // Animating to the touched position
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

            // Placing a marker on the touched position
            mMap.addMarker(markerOptions);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_place_marker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

 /*   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

            Intent i = new Intent(getApplicationContext(), CreateErrandFragment.class);
            i.putExtra("latitude", coordinates.latitude);
            i.putExtra("longitude", coordinates.longitude);
            startActivity(i);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
  */
/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Log.d("CDA", "onBackPressed Called");
        Intent i = new Intent(getApplicationContext(), CreateErrandFragment.class);
        i.putExtra("latitude", coordinates.latitude);
        i.putExtra("longitude", coordinates.longitude);

    }
*/
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Setting a click event handler for the map
        mMap.setOnMapClickListener(new OMCL());
    }
}
