package hackricesquad.hackrice2016;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class LoginActivity extends FragmentActivity implements LoginFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.login_fragment_container, new LoginFragment());
        ft.commit();

        // init parse
        ParseObject.registerSubclass(AgendaItem.class);
        Parse.initialize(this, "MyJy9JASAUPNcwsLW0vRq94jYN7f6THOlfkpwi0D", "YMfyT75RpJVb9QWoTOqVxFjLqXBG9PDJcprt9iPa");
        ParseFacebookUtils.initialize(getApplicationContext());

        ParseUser currentUser = ParseUser.getCurrentUser();
        // if the user is already logged in, skip the login screen and go to the main activity
        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this, AgendaListActivity.class);
            startActivity(intent);
            finish();
        }


    }


    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }


}
