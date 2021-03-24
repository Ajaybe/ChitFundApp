package com.example.cmfs1.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cmfs1.Controllers.Constants;
import com.example.cmfs1.Controllers.ErrorHandler;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.cmfs1.Controllers.SingletonVolley;
import com.example.cmfs1.Model.MaritalStatusSpinner;
import com.example.cmfs1.Model.SalutationSpinner;
import com.example.cmfs1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class UpdateKYCActivity extends AppCompatActivity {
    EditText et_name, et_relation, et_dob, et_anniversary,
            et_email, et_mobile, et_altMobile, et_aadhar, et_pan;
    Button btn_filePicker, btn_saveMemDtl;
    TextView tv_age, filePath;

    private String name = "", son_of_wife_of = "", date_of_birth = "", age = "", anniversaryDt ="";
    private String email_id = "", mobile_num = "", alternate_num = "" ;
    private String aadhar_num = "", pan_num = "", photo_path = "", sal_code = "", sal_name = "",
            mar_code = "", mar_status = "";
    private String salCodeSelected = "", salutationSelected = "";
    private String marCodeSelected = "", maritalStatusSelected = "";

    ArrayList<String> salSpinnerList = new ArrayList<>();
    ArrayList<String> marSpinnerList = new ArrayList<>();

    Spinner spinner, spinner_mar;
    Toolbar toolbar;
    LinearLayout layoutAnniversary;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_kyc);

        spinner = findViewById(R.id.spinner);
        et_name = findViewById(R.id.et_name);
        et_relation = findViewById(R.id.et_relation);
        et_dob = findViewById(R.id.et_dob);
        tv_age = findViewById(R.id.tv_age);
        spinner_mar = findViewById(R.id.spinner_mar);
        et_anniversary = findViewById(R.id.et_anniversary);
        et_email = findViewById(R.id.et_email);
        et_mobile = findViewById(R.id.et_mobile);
        et_altMobile = findViewById(R.id.et_altMobile);
        et_aadhar = findViewById(R.id.et_aadhar);
        et_pan = findViewById(R.id.et_pan);
        filePath = findViewById(R.id.filePath);
        btn_filePicker = findViewById(R.id.btn_filePicker);
        btn_saveMemDtl = findViewById(R.id.btn_saveMemDtl);
        toolbar = findViewById(R.id.toolbar_personal_dtl);
        layoutAnniversary = findViewById(R.id.layoutAnniversary);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });

//        SharedPreferences sharedPreferences = getSharedPreferences(Constants.preferenceFile, MODE_PRIVATE);
//        sal_code = sharedPreferences.getString(Constants.salCode, null);
//        sal_name = sharedPreferences.getString(Constants.salName, null);
//        mar_code = sharedPreferences.getString(Constants.marCode, null);
//        mar_status = sharedPreferences.getString(Constants.marStatus, null);
        fetchSalutation();
        fetchMaritalStatus();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                salutationSelected = spinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_mar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maritalStatusSelected = spinner_mar.getItemAtPosition(position).toString();
                mar_status = "UnMarried";
                layoutAnniversary.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        spinner_mar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mar_status = "UnMarried";
//                layoutAnniversary.setVisibility(View.GONE);
//            }
//        });

        final Calendar calendar =Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener dob = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDOB(calendar);
            }
        };

        et_dob.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateKYCActivity.this, dob,
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                    datePickerDialog.show();
                }
                return true;
            }
        });

        final DatePickerDialog.OnDateSetListener anniversary = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateAnniversary(calendar);
            }
        };

        et_anniversary.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateKYCActivity.this, anniversary,
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                    datePickerDialog.show();
                }
                return true;
            }
        });

        btn_saveMemDtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = et_name.getText().toString().trim();
                son_of_wife_of = et_relation.getText().toString().trim();
                date_of_birth = et_dob.getText().toString().trim();
                anniversaryDt = et_anniversary.getText().toString().trim();
                email_id = et_email.getText().toString().trim();
                mobile_num = et_mobile.getText().toString().trim();
                alternate_num = et_altMobile.getText().toString().trim();
                aadhar_num = et_aadhar.getText().toString().trim();
                pan_num = et_pan.getText().toString().trim();

                if (name.isEmpty() || son_of_wife_of.isEmpty() || date_of_birth.isEmpty() ||
                 mobile_num.isEmpty() || aadhar_num.isEmpty() || pan_num.isEmpty()) {
                    Toast.makeText(UpdateKYCActivity.this, "Required fields are mandatory", Toast.LENGTH_SHORT).show();
                } else if (salCodeSelected.equals("--Select--")) {
                    Toast.makeText(UpdateKYCActivity.this, "Please select Salutation", Toast.LENGTH_SHORT).show();
                }    else if (marCodeSelected.equals("--Select--")) {
                        Toast.makeText(UpdateKYCActivity.this, "Please select Marital Status", Toast.LENGTH_SHORT).show();
                } else {
                    saveNewMember();

                    Intent intent = new Intent(getApplicationContext(), KYCSummary.class);
                    startActivity(intent);
                }
            }
        });

        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                fileIntent.setType("*/*");
                startActivityForResult(fileIntent, 10);
            }
        });


    }

    private void updateDOB(Calendar calendar) {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        et_dob.setText(sdf.format(calendar.getTime()));

        tv_age.setText(Integer.toString(calculateAge(calendar.getTimeInMillis())));
    }

    int calculateAge(long date) {
        Calendar mDob = Calendar.getInstance();
        mDob.setTimeInMillis(date);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - mDob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_MONTH) < mDob.get(Calendar.DAY_OF_MONTH)) {
            age --;
        }
        return age;
    }

    private void updateAnniversary(Calendar calendar) {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        et_anniversary.setText(sdf.format(calendar.getTime()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    filePath.setText(path);
                }
                break;
        }

    }

    private void fetchSalutation() {
        String url = getResources().getString(R.string.staging_url) + "Members/Salutation";
        salSpinnerList.add("--Select Salutation--");

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String salut = object.getString("SALUT");

                        salSpinnerList.add(salut);
                        spinner.setAdapter(new ArrayAdapter<String>(UpdateKYCActivity.this, android.R.layout.simple_spinner_dropdown_item, salSpinnerList));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ErrorHandler.callErrorHandler(error, getApplicationContext());
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        SingletonVolley.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    private void fetchMaritalStatus() {
        String url = getResources().getString(R.string.staging_url) + "Members/MaritalStatus";
        marSpinnerList.add("--Select--");
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String marStatus = object.getString("MSTATUS");

                        marSpinnerList.add(marStatus);
                        spinner_mar.setAdapter(new ArrayAdapter<String>(UpdateKYCActivity.this, android.R.layout.simple_spinner_dropdown_item, marSpinnerList));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ErrorHandler.callErrorHandler(error, getApplicationContext());
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        SingletonVolley.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    private void saveNewMember() {

        String url = getResources().getString(R.string.staging_url) + "Members/MemberCreation/";

        HashMap<String, String> params = new HashMap<String, String>();

        params.put("salut", sal_name);
        params.put("full_name", name);
        params.put("son_of_wife_of", son_of_wife_of);
        params.put("date_birth", date_of_birth);
        params.put("age", age);
        params.put("martial_status", mar_status);
        params.put("anniversary", anniversaryDt);
        params.put("email_id", email_id);
        params.put("mobile_no", mobile_num);
        params.put("alt_number", alternate_num);
        params.put("adhaar_no", aadhar_num);
        params.put("pan_no", pan_num);
        params.put("photo", photo_path);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(Constants.TAG, "Response :: " + response.toString());

                Toast.makeText(UpdateKYCActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();

                SharedPreferences preferences = getSharedPreferences(Constants.preferenceFile, Context.MODE_PRIVATE);

                Intent intent = new Intent(getApplicationContext(), KYCSummary.class);
                intent.putExtra("full_name", name);
                intent.putExtra("son_of_wife_of", son_of_wife_of);
                intent.putExtra("date_birth", date_of_birth);
                intent.putExtra("age", age);
                intent.putExtra("martial_status", mar_status);
                intent.putExtra("anniversary", anniversaryDt);
                intent.putExtra("email_id", email_id);
                intent.putExtra("mobile_no", mobile_num);
                intent.putExtra("alt_number", alternate_num);
                intent.putExtra("adhaar_no", aadhar_num);
                intent.putExtra("pan_no", pan_num);
                intent.putExtra("photo", photo_path);
                startActivity(intent);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateKYCActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.d(Constants.TAG, "Error :: "+error.toString());
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(5000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        SingletonVolley.getInstance(getApplicationContext()).addToRequestQueue(request);

    }





}


