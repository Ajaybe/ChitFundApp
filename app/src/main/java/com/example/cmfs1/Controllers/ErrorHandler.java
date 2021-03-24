package com.example.cmfs1.Controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;

public class ErrorHandler {

    public static void callErrorHandler(Object error, Context context) {

        String errorResponse;
        if (error instanceof ClientError) {
            errorResponse = "Client Error. Enter correct details";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        } else if (error instanceof NoConnectionError) {
            errorResponse = "No internet connection";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        } else if (error instanceof TimeoutError) {
            errorResponse = "Server timed out. Try again later";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        } else if (error instanceof AuthFailureError) {
            errorResponse = "Authentication failure.";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        } else if (error instanceof ServerError) {
            errorResponse = "Server didn't respond for the request. Please try later.";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        }else if(error instanceof ParseError){
            errorResponse = "Parse error. Please try later.";
            Toast.makeText(context, errorResponse, Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        } else {
            errorResponse = error.toString();
            Toast.makeText(context, "Unable to fetch the result", Toast.LENGTH_SHORT).show();
            Log.d(Constants.TAG, errorResponse);
        }
    }
}
