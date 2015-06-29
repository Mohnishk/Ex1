package com.try1.mohnishkumar.ex1;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mohnish.kumar on 29-05-2015.
 */
public class SpeedView extends TextView {
    Context context;
    double spd1=0;

    public SpeedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpeedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public SpeedView(Context context) {
        super(context);
        this.context = context;

        LocationListener locationListener = new SpeedListener();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, locationListener);

    }

    private class SpeedListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            double spd2=location.getSpeed() * 3.6;
            SpeedView.this.setText(String.valueOf((int)spd2));
            ImageView imageView = (ImageView)findViewById(R.id.imageView2);
            imageView.setPivotX((float)0.498*2560);
            imageView.setPivotY((float)0.57*1440);
            imageView.setRotation((float) (1.27 * (spd2-spd1)));
            spd1=spd2;
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }

    }


}
