package com.example.tp1dispmov;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ModoAvionCambio modoAvion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modoAvion=new ModoAvionCambio();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(modoAvion,new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(modoAvion);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(modoAvion);
    }
}