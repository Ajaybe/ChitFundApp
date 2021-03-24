package com.example.cmfs1.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cmfs1.R;

public class BankDetails extends AppCompatActivity {
    EditText et_bd_bankName, et_bd_bankBranck, et_bd_bankIFSC, et_bd_accNo;
    Toolbar toolbar_bank_dtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

        et_bd_bankName = findViewById(R.id.et_bd_bankName);
        et_bd_bankBranck = findViewById(R.id.et_bd_bankBranck);
        et_bd_bankIFSC = findViewById(R.id.et_bd_bankIFSC);
        et_bd_accNo = findViewById(R.id.et_bd_accNo);
        toolbar_bank_dtl = findViewById(R.id.toolbar_bank_dtl);

        toolbar_bank_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });
    }
}