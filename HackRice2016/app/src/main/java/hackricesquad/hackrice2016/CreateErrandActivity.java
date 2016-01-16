package hackricesquad.hackrice2016;

import android.content.Intent;
import android.location.GpsStatus;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateErrandActivity extends FragmentActivity implements CreateErrandFragment.OnFragmentInteractionListener,
        TimePickerFragment.OnFragmentInteractionListener, CreateErrandFragment.Callback {


    private Button setLocation;
    private Button createEvent;

    private android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;
    private CreateErrandFragment.Callback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        setLocation = (Button) findViewById(R.id.set_location);
        createEvent = (Button) findViewById(R.id.create_event);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        CreateErrandFragment f = new CreateErrandFragment();
        final TimePickerFragment t = new TimePickerFragment();

        ft.add(R.id.fragment_container, f);

        ft.commit();



    }

    public void callback(){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        TimePickerFragment t = new TimePickerFragment();

        ft.replace(R.id.fragment_container, t);
        ft.commit();
    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }




}
