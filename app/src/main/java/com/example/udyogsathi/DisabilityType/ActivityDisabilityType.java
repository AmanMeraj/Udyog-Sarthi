package com.example.udyogsathi.DisabilityType;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.udyogsathi.Adapter.AdapterDisability;
import com.example.udyogsathi.Container.ContainerActivity;
import com.example.udyogsathi.Model.DisabilityType;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityDisabilityTypeBinding;

import java.util.ArrayList;

public class ActivityDisabilityType extends AppCompatActivity {
   ActivityDisabilityTypeBinding binding;
    ArrayList<DisabilityType> disabilityTypes;
    AdapterDisability adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDisabilityTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        disabilityTypes= new ArrayList<>();

        for (int i=0; i<3; i++){
            DisabilityType obj1=new DisabilityType("Mental Disability");
            disabilityTypes.add(obj1);
            DisabilityType obj2=new DisabilityType("Sensory Disability");
            disabilityTypes.add(obj2);
            DisabilityType obj3=new DisabilityType("Physical Disability");
            disabilityTypes.add(obj3);
        }
        adapter= new AdapterDisability(this,disabilityTypes);
        binding.disabilityRec.setAdapter(adapter);
binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(ActivityDisabilityType.this, ContainerActivity.class);
        startActivity(i);
    }
});
    }
}