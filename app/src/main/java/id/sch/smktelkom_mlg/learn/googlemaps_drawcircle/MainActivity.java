package id.sch.smktelkom_mlg.learn.googlemaps_drawcircle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition PLACE = CameraPosition.builder()
            .target(new LatLng(48.8584, 2.2945))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    LatLng renton = new LatLng(-8.400375, 114.273540);
    LatLng kirkland = new LatLng(47.7301986, -122.1768858);
    LatLng everett = new LatLng(47.978748, -122.202001);
    LatLng lynwood = new LatLng(47.819533, -122.32288);
    LatLng montlake = new LatLng(47.7973733, -122.3281771);
    LatLng kent = new LatLng(47.385938, -122.258212);
    LatLng showare = new LatLng(47.38702, -122.23986);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map is Ready!", Toast.LENGTH_SHORT);
        toast.show();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(PLACE));
        //map.addPolyline(new PolylineOptions().geodesic(true).add(renton).add(kirkland).add(everett).add(lynnwood).add(montlake).add(kent).add(showare).add(renton));
        //map.addPolygon(new PolygonOptions().add(renton, kirkland, everett, lynnwood).fillColor(Color.GREEN));
        map.addCircle(new CircleOptions()
                .center(renton)
                .radius(200)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
