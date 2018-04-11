package com.example.aparna879.vl_calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String current_value="0",temp="0",dis="0",c;
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


    private void setvalue(String n){
        EditText e = findViewById(R.id.show);
        e.setText(n);
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


    public void operation(View view){
         temp = current_value;
         current_value="0";
         final Button badd = (Button) findViewById(R.id.add);
         final Button bsub = (Button) findViewById(R.id.sub);
         final Button bdivide = (Button) findViewById(R.id.divide);
         final Button bx = (Button) findViewById(R.id.x);

         if(view.equals(badd))
             c = "+";
         else if(view.equals(bsub))
            c = "-";
         else if(view.equals(bdivide))
            c = "/";
         else if(view.equals(bx))
            c = "*";

         dis= temp+" "+c;
         setvalue(dis);
    }


    public void result(View view) {
        double op1 = Double.parseDouble(current_value);
        double op2 = Double.parseDouble(temp);
        if(c == "+"){
            op2 = op2 + op1;
            setvalue(op2);
        }
        else if(c == "-"){
            op2 = op2 - op1;
            setvalue(op2);
        }
        else if(c == "*"){
            op2 = op2 * op1;
            setvalue(op2);
        }
        else if(c == "/"){
            op2 = op2 / op1;
            setvalue(op2);
        }
        current_value = String.valueOf(op2);
    }

    public void percentage(View view) {
        double per = Double.parseDouble(current_value);
        per/=100;
        setvalue(per);
    }
}
