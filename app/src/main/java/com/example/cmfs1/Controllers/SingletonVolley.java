package com.example.cmfs1.Controllers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonVolley {

    //1.    creating required variables
    private static SingletonVolley volleyInstance;
    private RequestQueue requestQueue;
    private static Context volleyContext;

    //2.    create Constructor of the singleton class

    private SingletonVolley(Context context) {
        volleyContext = context;
        this.requestQueue = getRequestQueue();
    }

    //3.    create instance of singleton class and create an object of it
    public static synchronized SingletonVolley getInstance(Context context) {
        if (volleyInstance == null) {
            volleyInstance = new SingletonVolley(context);
        }
        return volleyInstance;
    }

    //4.    create a custom method and initialize RequestQueue in it
    public RequestQueue getRequestQueue(){
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(volleyContext.getApplicationContext());
        }
        return requestQueue;
    }

    //5.    create a custom method and add request to the Requestquest by the getRequestQueue() custom method
    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object object){
        if (requestQueue != null){
            requestQueue.cancelAll(object);
        }

    }
}
