package com.example.cmfs1.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmfs1.R;

public class KYCSummary extends AppCompatActivity {

    TextView tv_name, tv_so_wo, tv_date_of_birth, tv_age, tv_emailId, tv_mobileNo, tv_altNo, tv_aadharNo, tv_panNo;
    Button btn_next;

    private String name = "", son_of_wife_of = "", date_of_birth = "", age = "", anniversaryDt ="";
    private String email_id = "", mobile_num = "", alternate_num = "" ;
    private String aadhar_num = "", pan_num = "", photo_path = "", sal_code = "", sal_name = "",
            marCode = "", marStatus = "";
    private String salCodeSelected = "", salutationSelected = "";
    private String marCodeSelected = "", maritalStatusSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_summary);

        Toolbar toolbar = findViewById(R.id.toolbar_new_member_summary);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });

        tv_name = findViewById(R.id.tv_name);
        tv_so_wo = findViewById(R.id.tv_so_wo);
        tv_date_of_birth = findViewById(R.id.tv_date_of_birth);
        tv_age = findViewById(R.id.tv_age);
        tv_emailId = findViewById(R.id.tv_emailId);
        tv_mobileNo = findViewById(R.id.tv_mobileNo);
        tv_altNo = findViewById(R.id.tv_altNo);
        tv_aadharNo = findViewById(R.id.tv_aadharNo);
        tv_panNo = findViewById(R.id.tv_panNo);

        btn_next = findViewById(R.id.btn_next);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("full_name");
        son_of_wife_of = bundle.getString("son_of_wife_of");
        date_of_birth = bundle.getString("date_birth");
        age = bundle.getString("age");
        marStatus = bundle.getString("martial_status");
        anniversaryDt = bundle.getString("anniversary");
        email_id = bundle.getString("email_id");
        mobile_num = bundle.getString("mobile_no");
        alternate_num = bundle.getString("alt_number");
        aadhar_num = bundle.getString("adhaar_no");
        pan_num = bundle.getString("pan_no");
        photo_path = bundle.getString("photo");

        tv_name.setText(name);
        tv_so_wo.setText("S/o, W/o, D/o :" +son_of_wife_of);
        tv_date_of_birth.setText("Date of Birth :" +date_of_birth);
        tv_age.setText("Age :" +age);
        tv_emailId.setText("Email Id :" +email_id);
        tv_mobileNo.setText("Mobile Number :" + mobile_num);
        tv_altNo.setText("Alternate Number :" + alternate_num);
        tv_aadharNo.setText("Aadhar Number :" + aadhar_num);
        tv_panNo.setText("Pan Number :" + pan_num);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalDetails.class);
                startActivity(intent);
                finish();
            }
        });
    }
}