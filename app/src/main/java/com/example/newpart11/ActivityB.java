package com.example.newpart11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        button=findViewById(R.id.button2);
        Bundle bundle1=getIntent().getExtras();
        Toast.makeText(ActivityB.this,bundle1.getString("string1"),Toast.LENGTH_LONG).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText=findViewById(R.id.editText2);
                String string=editText.getText().toString();
                Intent intent=new Intent();
                Bundle bundle2=new Bundle();
                bundle2.putString("string2",string);
                intent.putExtras(bundle2);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}