package com.example.tp1dispmov;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvionCambio extends BroadcastReceiver {
    private boolean modoAvionActivado;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
             modoAvionActivado = intent.getBooleanExtra("state", false);

            if (modoAvionActivado) {
                Toast.makeText(context, "Modo Avión ACTIVADO", Toast.LENGTH_SHORT).show();


                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2664553747"));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            } else {
                Toast.makeText(context, "Modo Avión DESACTIVADO", Toast.LENGTH_SHORT).show();
            }
        }
    }


}