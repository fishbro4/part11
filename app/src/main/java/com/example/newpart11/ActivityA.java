package com.example.newpart11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity{

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText=findViewById(R.id.editText);
                String string=editText.getText().toString();
                Intent intent=new Intent(ActivityA.this,ActivityB.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("string1",string);
                intent.putExtras(bundle1);
                //startActivity(intent);
                startActivityForResult(intent,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(ActivityA.this,data.getExtras().getString("string2"),Toast.LENGTH_LONG).show();
    }
}
