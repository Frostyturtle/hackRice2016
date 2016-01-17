package hackricesquad.hackrice2016;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by katherinebruton on 1/16/16.
 */

@ParseClassName("AgendaItem")
public class AgendaItem extends ParseObject {

    public AgendaItem() { }

    public void setTitle(String title){
        put("title", title);
    }

    public void setLocation(int location){
        put("location", location);
    }

    public void setRadius(int radius){
        put("radius", radius);
    }

    public void setOwner(ParseUser user){
        put("owner", user);
    }

    public void setLatitude(double latitude) {
        put("latitude", latitude);
    }

    public void setLongitude(double longitude) {
        put("longitude", longitude);
    }

    public double getLatitude() {
        return getDouble("latitude");
    }

    public double getLongitude() {
        return getDouble("longitude");
    }

}
