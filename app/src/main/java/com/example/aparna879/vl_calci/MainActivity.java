package com.example.aparna879.vl_calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String current_value="0";
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void reset(View view){
        setvalue(0);
        current_value="0";
    }


    private void setvalue(double n){
        EditText e = findViewById(R.id.show);
        e.setText(String.valueOf(n));
    }


    public void numpad(View view){
        String s=(String)view.getTag();
        if(s==".")
            status = true;
        if(!status || s!=".")
            current_value+=(String)s;
        double i=Double.parseDouble(current_value);
        setvalue(i);

    }

    public void cross(View view){
        current_value = current_value.substring(0,current_value.length()-1);
        double i=Double.parseDouble(current_value);
        setvalue(i);

    }


}
