package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultado_text;
    double n1,n2,res;
    String Operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void zero_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"0");
    }
    public void uno_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"1");
    }
    public void two_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"2");
    }
    public void three_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"3");
    }
    public void four_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"4");
    }
    public void five_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"5");
    }
    public void six_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"6");
    }
    public void seven_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"7");
    }
    public void eight_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"8");
    }
    public void nine_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+"9");
    }
    public void dot_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText(resultado_text.getText()+".");
    }
    public void OperacionPrimerNumero(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        n1=Double.parseDouble(resultado_text.getText().toString());
        resultado_text.setText("");
    }
    public void sum_bt(View view) {
        Operador="+";
        OperacionPrimerNumero(view);
    }
    public void res_bt(View view) {
        Operador="-";
        OperacionPrimerNumero(view);
    }
    public void mult_bt(View view) {
        Operador="*";
        OperacionPrimerNumero(view);
    }
    public void div_bt(View view) {
        Operador="/";
        OperacionPrimerNumero(view);
    }
    public void eq_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        n2=Double.parseDouble(resultado_text.getText().toString());
        if(Operador.equals("+")){
            res=n1+n2;
        }else if(Operador.equals("-")){
            res=n1-n2;
        }else if(Operador.equals("*")){
            res=n1*n2;
        }else if(Operador.equals("/")) {
            res = n1 / n2;
        }
        resultado_text.setText(""+res);
    }
    public void sin_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        try{
            n1=Double.parseDouble(resultado_text.getText().toString());
            double rd=Math.toRadians(n1);
            res=Math.sin(rd);
            resultado_text.setText(String.valueOf(res));
        }catch (NumberFormatException NFE){}
    }
    public void cos_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        try{
            n1=Double.parseDouble(resultado_text.getText().toString());
            double rd=Math.toRadians(n1);
            res=Math.cos(rd);
            resultado_text.setText(String.valueOf(res));
        }catch (NumberFormatException NFE){}
    }
    public void tan_bt(View view) {
        resultado_text=(TextView)findViewById(R.id.resultado);
        try{
            n1=Double.parseDouble(resultado_text.getText().toString());
            double rd=Math.toRadians(n1);
            res=Math.tan(rd);
            resultado_text.setText(String.valueOf(res));
        }catch (NumberFormatException NFE){}
    }
    public void clear_bt(View view) {
        n1=0.0;
        n2=0.0;
        resultado_text=(TextView)findViewById(R.id.resultado);
        resultado_text.setText("");
    }
}