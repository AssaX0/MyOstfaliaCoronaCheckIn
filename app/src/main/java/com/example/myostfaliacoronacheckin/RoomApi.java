package com.example.myostfaliacoronacheckin;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

public class RoomApi {
    public static void getPeopleCount(Context context, String pin, RoomApiInterface handler){
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "https://qr.sonia.de/room?p=" + pin, null, response -> {
                    try {
                        handler.onDataReceived(response.get("attendeesCount").toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    Log.e("Error", error.toString());
                });

       queue.add(jsonObjectRequest);
    }

    public interface RoomApiInterface {
        void onDataReceived(String data);
    }
}