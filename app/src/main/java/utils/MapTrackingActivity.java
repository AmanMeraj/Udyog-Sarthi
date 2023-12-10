package utils;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class MapTrackingActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    protected LocationRequest mLocationRequest;
    protected GoogleApiClient mGoogleApiClient;
    protected Marker mCurrLocationMarker;
    protected Location mLastLocation;
    protected GoogleMap mGoogleMap;
    protected static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;


    protected List<Marker> originMarkers = new ArrayList<>();
    protected List<Marker> destinationMarkers = new ArrayList<>();
    protected List<Polyline> polylinePaths = new ArrayList<>();
    protected ArrayList<Polyline> l_polyLine = new ArrayList<>();
    Context c;



    protected synchronized void buildGoogleApiClient() {

        Log.d("jwd", "buildGoogleApiClient: ");


        int status =getPackageManager().checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,
                getPackageName());

        if (status == PackageManager.PERMISSION_GRANTED) {

                mGoogleApiClient = new GoogleApiClient.Builder(this)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();
                mGoogleApiClient.connect();

        }
    }


//    protected void requestLocation(){
//        Log.d("jwd", "requestLocation: ");
//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(1000);
//        mLocationRequest.setFastestInterval(16);
//        //mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
//
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            //LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//
//            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//
//
//           // LocationServices.getFusedLocationProviderClient(getActivity()).requestLocationUpdates(mLocationRequest,this,null);
//        }
//    }

        protected void requestLocation(final Activity activity, final LocationCallback callback){
            Log.d("jwd", "requestLocation: ");
            mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(1000);
            mLocationRequest.setFastestInterval(16);
            //mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);



            // Create LocationSettingsRequest object using location request
            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
            builder.addLocationRequest(mLocationRequest);
            LocationSettingsRequest locationSettingsRequest = builder.build();

            // Check whether location settings are satisfied
            // https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient
            SettingsClient settingsClient = LocationServices.getSettingsClient(activity);
            Task<LocationSettingsResponse> result =settingsClient.checkLocationSettings(locationSettingsRequest);


            result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
                @Override
                public void onComplete(Task<LocationSettingsResponse> task) {
                    try {
                        LocationSettingsResponse response = task.getResult(ApiException.class);
                        // All location settings are satisfied. The client can initialize location
                        // requests here.

                        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                            //LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

                            //  LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);


                            LocationServices.getFusedLocationProviderClient(activity).requestLocationUpdates(mLocationRequest,callback,null);
                        }


                    } catch (ApiException exception) {
                        switch (exception.getStatusCode()) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                // Location settings are not satisfied. But could be fixed by showing the
                                // user a dialog.
                                try {
                                    // Cast to a resolvable exception.
                                    ResolvableApiException resolvable = (ResolvableApiException) exception;
                                    // Show the dialog by calling startResolutionForResult(),
                                    // and check the result in onActivityResult().
//                                resolvable.startResolutionForResult(
//                                        activity,
//                                        141);

                                    startIntentSenderForResult(resolvable.getResolution().getIntentSender(), 141, null, 0, 0, 0, null);
                                } catch (IntentSender.SendIntentException e) {
                                    // Ignore the error.
                                } catch (ClassCastException e) {
                                    // Ignore, should be an impossible error.
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                // Location settings are not satisfied. However, we have no way to fix the
                                // settings so we won't show the dialog.
                                break;
                        }
                    }
                }
            });



        }

//    protected void removeLocationUpdate(){
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,ca)
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,this);
//    }

        protected void removeLocationUpdate(Activity activity,LocationCallback callback){
            LocationServices.getFusedLocationProviderClient(activity).removeLocationUpdates(callback);

        }
//    public void setPickUp(double latitude, double longitude,TextView textView){
//
//        LatLng latLng=new LatLng(latitude,longitude);
//        String result="";
//
//        try {
//
//            textView.setText(new LongOperation().execute(latLng).get());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//       // return result;
//
//
//    }


    protected String getCountryCode(double latitude, double longitude){

        LatLng latLng=new LatLng(latitude,longitude);
        String result="";

        try {

            result = new LongOperationCountry().execute(latLng).get();
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public void onDestroy() {
            super.onDestroy();
       // mGoogleApiClient.disconnect();
    }


    public class LongOperationCountry extends AsyncTask<LatLng, Void, String> {

        @Override
        protected String doInBackground(LatLng... params) {

            String str_result = "";

            LatLng latLng=params[0];


            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(MapTrackingActivity.this, Locale.getDefault());

            try{
                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                str_result = addresses.get(0).getCountryCode();


            }catch (Exception e){
                Log.d(TAG+"error",e.toString());
            }

            return str_result;
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

    protected String getCityName(Context c, double latitude, double longitude){

        this.c=c;
        LatLng latLng=new LatLng(latitude,longitude);
        String result="";

        try {

            result = new LongOperationCity().execute(latLng).get();
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public class LongOperationCity extends AsyncTask<LatLng, Void, String> {

        @Override
        protected String doInBackground(LatLng... params) {

            String str_result = "";

            LatLng latLng=params[0];


            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(c, Locale.getDefault());

            try{
                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                str_result = addresses.get(0).getLocality();

                Log.d("city", "doInBackground: "+addresses);
                Log.d("city", "doInBackground: "+str_result);

            }catch (Exception e){
                Log.d(TAG+"error",e.toString());
            }

            return str_result;
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }



//    public class LongOperation extends AsyncTask<LatLng, Void, String> {
//
//        @Override
//        protected String doInBackground(LatLng... params) {
//
//            LatLng latLng=params[0];
//
//            String str_result = "";
//
//
//
//            try{
//                Geocoder geocoder;
//                List<Address> addresses;
//                geocoder = new Geocoder(getActivity(), Locale.getDefault());
//                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
//
//
//
//                Address returnedAddress = addresses.get(0);
//                StringBuilder strReturnedAddress = new StringBuilder("");
//
//                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
//                    if (i==returnedAddress.getMaxAddressLineIndex()){
//
//                        strReturnedAddress.append(returnedAddress.getAddressLine(i));
//
//                    }else {
//                        strReturnedAddress.append(returnedAddress.getAddressLine(i)).append(", ");
//                    }
//                }
//                str_result = strReturnedAddress.toString();
//
//
//            }catch (Exception e){
//                Log.d(TAG+"error",e.toString());
//            }
//
//
//
//
//
//            return str_result;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//        }
//
//        @Override
//        protected void onPreExecute() {}
//
//        @Override
//        protected void onProgressUpdate(Void... values) {}
//    }

    public class AsyncGeocoder extends AsyncTask<AsyncGeocoderObject, Void, List<Address>> {

        private TextView textView;

        @Override
        protected List<Address> doInBackground(AsyncGeocoderObject... asyncGeocoderObjects) {
            List<Address> addresses = null;
            AsyncGeocoderObject asyncGeocoderObject = asyncGeocoderObjects[0];
            textView = asyncGeocoderObject.textView;
            try {
                addresses = asyncGeocoderObject.geocoder.getFromLocation(asyncGeocoderObject.lat,
                        asyncGeocoderObject.lng, 1);

            } catch (Exception e) {
                e.printStackTrace();
            }


            return addresses;
        }

        @Override
        protected void onPostExecute(List<Address> addresses) {
            Log.v("onPostExecute", "location: " + addresses);
            String address = "";

            if (addresses != null && addresses.size() > 0) {

                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    if (i == returnedAddress.getMaxAddressLineIndex()) {

                        strReturnedAddress.append(returnedAddress.getAddressLine(i));

                    } else {
                        strReturnedAddress.append(returnedAddress.getAddressLine(i)).append(", ");
                    }

                    address = strReturnedAddress.toString();
                }
            }
            else
            {
                address ="not found";
            }
            textView.setText(address);

        }
    }

}

