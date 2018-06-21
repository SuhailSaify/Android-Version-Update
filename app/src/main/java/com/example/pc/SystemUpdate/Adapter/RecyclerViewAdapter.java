package com.example.pc.SystemUpdate.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pc.SystemUpdate.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<PackageInfo> list;
    Context context;
    int size;
    PackageManager packageManager;


    @SuppressLint("SimpleDateFormat")
    private String setDateFormat(long time) {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = formatter.format(date);
        return strDate;
    }

    public RecyclerViewAdapter(List<PackageInfo> list, Context context, PackageManager packageManager) {
        this.list = list;
        this.context = context;
        size = list.size();
        this.packageManager = packageManager;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recyclerview, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, final int position) {


        Glide.with(context).load(packageManager.getApplicationIcon(list.get(position).applicationInfo)).into(holder.imageView);
        holder.title.setText(packageManager.getApplicationLabel(list.get(position).applicationInfo));
        holder.version.setText(list.get(position).versionName);
        holder.intalledOn.setText(setDateFormat(list.get(position).firstInstallTime));
        holder.update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        final String appPackageName = list.get(position).packageName; // getPackageName() from Context or Activity object
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }


                    }
                }
        );


    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, update;
        TextView title, version, intalledOn;


        public MyViewHolder(View itemView) {
            super(itemView);

            update = itemView.findViewById(R.id.update);
            imageView = itemView.findViewById(R.id.appimage);
            title = itemView.findViewById(R.id.title_R);
            version = itemView.findViewById(R.id.version_R);
            intalledOn = itemView.findViewById(R.id.installedOn_R);
        }
    }


}
