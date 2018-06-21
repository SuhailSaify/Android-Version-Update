package com.example.pc.SystemUpdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.SystemUpdate.Adapter.RecyclerViewAdapter;

import java.util.List;

public class InstalledApps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installed_apps);
        Context context = InstalledApps.this;


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(InstalledApps.this));

        PackageManager packageManager = getPackageManager();


        List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(packageList, context, packageManager);


        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(InstalledApps.this,MainActivity.class));
        finish();
    }
}
