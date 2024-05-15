package com.ninda.tablayout_universitaskuningan;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();
        this.setNewTab(this, tabHost, "tab1", "Universitas Kuningan",
                R.drawable.ic_launcher_background, new Intent(this, TabUniversitas.class));
        this.setNewTab(this, tabHost, "tab2", "Fakultas",
                R.drawable.ic_launcher_background, new Intent(this, TabFakultas.class));
        this.setNewTab(this, tabHost, "tab3", "Program Studi",
                R.drawable.ic_launcher_background, new Intent(this, TabProdi.class));
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            if (tv != null) {
                tv.setTextAppearance(this, R.style.CustomTabText);
            }
        }
    }

    private void setNewTab(Context context, TabHost tabHost, String tag, String title, int icon, Intent intentid) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title, context.getResources().getDrawable(icon));
        tabSpec.setContent(intentid);
        tabHost.addTab(tabSpec);
    }
}