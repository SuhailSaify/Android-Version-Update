package com.example.pc.SystemUpdate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Context context;
    CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    ImageView imageView;

    int i = 0;
    String MY_PREFS_NAME = "update";
    Boolean restoredText = false;
    SharedPreferences.Editor editor;
    String valid_until = "23/6/2018";
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);

        context = MainActivity.this;

        c1 = findViewById(R.id.card1);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        c4 = findViewById(R.id.card4);
        c5 = findViewById(R.id.card5);
        c6 = findViewById(R.id.card6);
        imageView = findViewById(R.id.image_installed_apps);
        c7 = findViewById(R.id.card7);
        c8 = findViewById(R.id.card8);
        c9 = findViewById(R.id.card9);
        c10 = findViewById(R.id.card10);

        loadimages();
        listner();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        checkconnection();



        /*
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date strDate = null;
        try {
            strDate = sdf.parse(valid_until);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (new Date().after(strDate)) {

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MainActivity.this);
            }
            builder.setTitle("Cannot Continue")
                    .setMessage("Contact Developer to Continue")
                    .setCancelable(false)
                    .setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                            closeapp();

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }
        */


        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        if (prefs != null) {
            restoredText = prefs.getBoolean("Updated", false);


        }


    }

    private void loadimages() {

        Context context = MainActivity.this;

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);


        Glide.with(context).load(getResources().getDrawable(R.mipmap.sam)).apply(requestOptions).into(image1);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.htc)).apply(requestOptions).into(image2);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.hawe)).apply(requestOptions).into(image3);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.nokia)).apply(requestOptions).into(image4);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.mi)).apply(requestOptions).into(image5);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.moto)).apply(requestOptions).into(image6);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.oneplus)).apply(requestOptions).into(image7);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.vivo)).apply(requestOptions).into(image8);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.oppo)).apply(requestOptions).into(image9);
        Glide.with(context).load(getResources().getDrawable(R.mipmap.other)).apply(requestOptions).into(image10);
          }

    private void listner() {


        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, InstalledApps.class));
                        finish();
                    }
                }
        );

        c1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 1);
                        startActivity(i);
                    }
                }
        );


        c2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 2);
                        startActivity(i);
                    }
                }
        );
        c3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 3);
                        startActivity(i);
                    }
                }
        );
        c4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 4);
                        startActivity(i);
                    }
                }
        );
        c5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 5);
                        startActivity(i);
                    }
                }
        );
        c6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 6);
                        startActivity(i);
                    }
                }
        );
        c7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 7);
                        startActivity(i);
                    }
                }
        );
        c8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 8);
                        startActivity(i);
                    }
                }
        );
        c9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 9);
                        startActivity(i);
                    }
                }
        );
        c10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, WebviewActivity.class);
                        i.putExtra("id", 10);
                        startActivity(i);
                    }
                }
        );


    }

    private void start() {
        startActivity(new Intent(MainActivity.this, ScanActivity.class));
        finish();
    }


    public void closeapp()

    {
        finish();
        this.finishAffinity();
    }


    @Override
    public void onBackPressed() {

        if (i > 0) {
            i = 0;
            finish();
            this.finishAffinity();
        } else {
            Toast.makeText(this, "Press again to quit", Toast.LENGTH_SHORT).show();
            i++;
        }
    }

    void log(String s, String s1) {
        Log.d(s, s1);

    }


    public void checkconnection() {

        Boolean isConnected;
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            startActivity(new Intent(MainActivity.this, NoConnectionActivity.class));
        } else {
            //nothing
            // Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_SHORT).show();
        }
    }

}

