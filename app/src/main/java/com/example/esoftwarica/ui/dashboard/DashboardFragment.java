package com.example.esoftwarica.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.R;
import com.example.esoftwarica.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    EditText etName,etAge,etAddress;
    RadioGroup rdog;
    Button btnSave;
    String gender, Name, Age, Address;
    public static List<StudentInfo> studentInfoArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        etName = root.findViewById(R.id.etFullN);
        etAddress = root.findViewById(R.id.etAddress);
        etAge = root.findViewById(R.id.etAge);
        rdog = root.findViewById(R.id.rdogrp);
        btnSave = root.findViewById(R.id.btnSave);

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {


                rdog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.rdoMale){
                            gender = "Male";
                        }
                        else if (checkedId == R.id.rdoFemale){
                            gender = "Female";
                        }
                        else if (checkedId == R.id.rdoOthers){
                            gender = "Others";
                        }
                    }
                });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Name = etName.getText().toString();
                        Age = etAge.getText().toString();
                        Address = etAddress.getText().toString();

                        if (TextUtils.isEmpty(Name)) {
                            etName.setError("Enter your FullName");
                            etName.requestFocus();
                            return ;
                        }
                        else if (TextUtils.isEmpty(Age)) {
                            etAge.setError("Enter your Age");
                            etAge.requestFocus();
                            return ;
                        }
                        else if (TextUtils.isEmpty(Address)) {
                            etAddress.setError("Enter your Address");
                            etAddress.requestFocus();
                            return ;
                        }
                        else if (TextUtils.isEmpty(gender)) {
                            Toast.makeText(getContext(), " Select your Gender ", Toast.LENGTH_SHORT).show();
                            return ;
                        }

                        studentInfoArrayList.add(new StudentInfo(Name, Age, Address, gender, R.drawable.ic_launcher_background));
                        Toast.makeText(getContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();

                        etName.setText(null);
                        etAddress.setText(null);
                        etAge.setText(null);
                    }
                });

            }
        });

        return root;
    }
}