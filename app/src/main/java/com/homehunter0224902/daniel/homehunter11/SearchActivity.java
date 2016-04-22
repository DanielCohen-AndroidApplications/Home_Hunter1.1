package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Daniel on 4/21/2016.
 */
public class SearchActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {
    private GoogleMap map;
    SupportMapFragment fm;
    TextView textView2;
    String name, email, salaryString;
    Double latitude, longitude;
    Boolean usingGps;
    String strAdd;
    String location;
    HttpResponse response;
    String responseString;
    JSONObject locationInfo;
    ArrayList<Property> properties;
    int numProperties;
    int cardinalnumProperties;
    LatLng pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView2=(TextView) findViewById(R.id.textView2);
        try{
            name=getIntent().getStringExtra("name");
            email=getIntent().getStringExtra("email");
            salaryString=getIntent().getStringExtra("salary");
//            textView2.setText(name+"\n"+email+"\n"+salaryString);

            fm = (SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map);
            map = fm.getMap();
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setCompassEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.getUiSettings().setZoomGesturesEnabled(true);
            map.getUiSettings().setRotateGesturesEnabled(true);
            getCurrentLocation();
            properties = new ArrayList<Property>();
            Property prop1=new Property("125 W 21 Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_125w21st, null), 6700, "mo", 300000);
            prop1.setBeds(2.0);
            prop1.setBaths(2.0);
            properties.add(prop1);

            Property prop2 = new Property("620 E 20th Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_620e20th, null), 3348, "mo", 200000);

            prop2.setBeds(2.0);
            prop2.setBaths(2.0);
            properties.add(prop2);

            numProperties=2;
            textView2.setText(numProperties+" properties available near "+strAdd);
            CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.list_layout1,properties);
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            onMapReady(map);
        }catch (Exception e){
            textView2.setText(e.getMessage());
        }

    }

    public String[] getCurrentLocation(){
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);
        Location l = null;

        for(int i = 0; i < providers.size(); i++) {
            l = lm.getLastKnownLocation(providers.get(i));
            if (l != null) {
                latitude = l.getLatitude();
                longitude = l.getLongitude();
                usingGps=true;
                strAdd = getCompleteAddressString(latitude, longitude);
                location=strAdd.replace(",","").replace(" ", "+");
                if(!(strAdd.equals(""))) {

                }
                Log.v("_dan_location",location);
                break;
            }
        }

//        if(map != null){
//
//
//            onMapReady(map);
//        }
        // The method returns a String[] with three elements: lat, lng, and strAdd (string representions of the latitude, longitude, and the address)
        return new String[]{latitude+"",longitude+"",strAdd};
    }
    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<android.location.Address> addresses = geocoder
                    .getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                android.location.Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress
                            .append(returnedAddress.getAddressLine(i)).append(
                            "\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.w("My Current address",
                        "" + strReturnedAddress.toString());
            } else {
                Log.w("My Current address", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("My Current address", "Canont get Address!");
        }
        return strAdd;
    }
    @Override
    public void onConnected(Bundle bundle) {

    }
    @Override
    public void onConnectionSuspended(int i) {

    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public JSONObject getLatLong() {

        try {
            URI uri = new URI("https://maps.googleapis.com/maps/api/geocode/json?address=" +location+"&key=AIzaSyAOolIF3JIZfb-1PyotIkVYIV0LXNFW7fs");
            HttpGet request = new HttpGet(uri);
            HttpClient client = new DefaultHttpClient();
            response = client.execute(request);
            HttpEntity httpEntity = response.getEntity();
            responseString = EntityUtils.toString(httpEntity);
            locationInfo = new JSONObject(responseString);
//            locationObj = locationInfo.optJSONObject("results").optJSONObject("geometry").optJSONObject("location");
//            locationObj = locationInfo.optJSONObject("results");
        }catch(Exception e){
            Log.v("data_dan_latlng", "nil");
        }
        return locationInfo;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        for(cardinalnumProperties=0; cardinalnumProperties<numProperties; cardinalnumProperties++) {
            location=properties.get(cardinalnumProperties).getAddress().replace(",", "").replace(" ", "+");
            new LatLongTask().execute();
            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                @Override
                public View getInfoWindow(Marker arg0) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {

                    LinearLayout info = new LinearLayout(getApplication());
                    info.setOrientation(LinearLayout.VERTICAL);

                    TextView title = new TextView(getApplicationContext());
                    title.setTextColor(Color.BLACK);
                    title.setGravity(Gravity.CENTER);
                    title.setTypeface(null, Typeface.BOLD);
                    title.setText(marker.getTitle());

                    TextView snippet = new TextView(getBaseContext());
                    snippet.setTextColor(Color.GRAY);
                    snippet.setText(marker.getSnippet());

                    info.addView(title);
                    info.addView(snippet);

                    return info;
                }
            });
            try {
                Log.v("data_dan_JSON", getLatLong()+"");
            }catch(Exception e){
                Log.v("data_dan_JSON", "nil");
            }
        }




    }
    //Asynchronous task for retrieving latitude and longitude from Google Maps API based on a string representation of a location input by the user
    class LatLongTask extends AsyncTask<String,Integer,JSONObject> {
        @Override
        protected JSONObject doInBackground(String...params) {
            JSONObject latLong=new JSONObject();
            try {
                latLong=getLatLong();
                Log.v("JSON_result_dan",latLong.toString());
                Log.v("JSON_result_dan2", latLong.optJSONArray("results").toString());
                JSONArray resultJSONArray = latLong.optJSONArray("results");
                JSONObject locationJSONObj = resultJSONArray.getJSONObject(0).optJSONObject("geometry").optJSONObject("location");
                latitude=locationJSONObj.optDouble("lat");
                longitude=locationJSONObj.optDouble("lng");
                Log.v("_dan_loc",locationJSONObj.toString());
                Log.v("_dan_lat",latitude+"");
                Log.v("_dan_lng",longitude+"");
            }catch(Exception e){
                Log.v("_dan",e.getMessage());
            }
            return latLong;
        }
        @Override
        protected void onPostExecute(JSONObject result) {
//            onMapReady(map);
            pos = new LatLng(latitude, longitude);
            map.addMarker(new MarkerOptions().position(pos).title(location.replace("+", " ")).snippet("snippet here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            if(cardinalnumProperties==0){
                map.moveCamera(CameraUpdateFactory.newLatLng(pos));
                map.getMaxZoomLevel();
            }
        }
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onProgressUpdate(Integer... values) {

        }
    }
}
