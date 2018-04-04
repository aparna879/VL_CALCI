package com.example.aparna879.vl_calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int result=0;
    String current_value="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void reset(View view){

        setvalue(0);
        current_value="0";
    }

    private void setvalue(int n){
        EditText e = findViewById(R.id.show);
        e.setText(String.valueOf(n));
    }


    public void numpad(View view){
        String s=(String)view.getTag();
        current_value+=(String)s;
        int i=Integer.parseInt(current_value);
        setvalue(i);

    }


}
