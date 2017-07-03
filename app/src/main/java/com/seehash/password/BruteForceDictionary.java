package com.seehash.password;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.List;

public class BruteForceDictionary extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize()
    {
       // new LongOperation().execute("");

        scanWIFI();
    }

    private void scanWIFI()
    {
        WifiManager mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        List<ScanResult> mScanResults = mWifiManager.getScanResults();

        for (int x = 0; x<mScanResults.size(); x++)
        {
            HashMap<String, String> data = new HashMap<>();

            data.put("wifi_name",       "" + mScanResults.get(0).SSID);

            data.put("bssid",           "" + mScanResults.get(0).BSSID);

            data.put("capability",      "" + mScanResults.get(0).capabilities);

            data.put("level",           "" + mScanResults.get(0).level);

            data.put("frequency",       "" + mScanResults.get(0).frequency);

            data.put("timestamp",       "" + mScanResults.get(0).timestamp);

            Log.d("WIFI" + x, data.toString());
        }
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            for(long x = 0; x<1000000;x++)
            {
                System.out.println(x);
            }

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }
}
