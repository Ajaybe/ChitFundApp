package com.example.cmfs1.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cmfs1.Model.DistrictSpinner;
import com.example.cmfs1.Model.StateSpinner;
import com.example.cmfs1.R;

import java.util.ArrayList;
import java.util.List;

public class PersonalDetails extends AppCompatActivity {

    EditText et_pd_mobile, et_pd_pincode, et_pd_address;

    private List<StateSpinner> stateSpinnerList = new ArrayList<>();
    private StateSpinner stateSpinner;

    private List<DistrictSpinner> districtSpinnerList = new ArrayList<>();
    private DistrictSpinner districtSpinner;

    Spinner spinner_state, spinner_district;
    Button btn_nextToBankDtl;
    Toolbar toolbar_personal_dtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        et_pd_mobile = findViewById(R.id.et_pd_mobile);
        et_pd_pincode = findViewById(R.id.et_pd_pincode);
        et_pd_address = findViewById(R.id.et_pd_address);
        spinner_state = findViewById(R.id.spinner_state);
        spinner_district = findViewById(R.id.spinner_dist);
        btn_nextToBankDtl = findViewById(R.id.btn_nextToBankDtl);
        toolbar_personal_dtl = findViewById(R.id.toolbar_personal_dtl);

        toolbar_personal_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });

        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this, R.array.State, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_state.setAdapter(stateAdapter);

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String state = (String) spinner_state.getItemAtPosition(position);
                Toast.makeText(PersonalDetails.this, state, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_nextToBankDtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BankDetails.class);
                startActivity(intent);
            }
        });
    }
}