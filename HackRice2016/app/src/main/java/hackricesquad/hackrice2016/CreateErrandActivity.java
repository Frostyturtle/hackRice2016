package hackricesquad.hackrice2016;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;

public class CreateErrandActivity extends FragmentActivity implements CreateErrandFragment.OnFragmentInteractionListener {

    private Button pickTime;
    private Button pickDate;
    private Button createEvent;
    private android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        pickTime = (Button) findViewById(R.id.pick_time);
        pickDate = (Button) findViewById(R.id.pick_date);
        createEvent = (Button) findViewById(R.id.create_event);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        CreateErrandFragment f = new CreateErrandFragment();

        ft.add(R.id.fragment_container, f);

        ft.commit();

    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }



}
