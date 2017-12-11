package com.example.student2.testts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private EditText editText;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        editText.setText("1");
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new Listener());
    }
    class Listener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String choice = adapterView.getItemAtPosition(i).toString();
            String num = editText.getText().toString();
            try{
            String res = Integer.toBinaryString(Integer.parseInt(num));
            switch (choice){
                case "8":res = Integer.toOctalString(Integer.parseInt(num));
            break;
                case "16": res = Integer.toHexString(Integer.parseInt(num));
                break;
            }
            textView.setText(res);
        }catch (Exception e){
                Toast.makeText(MainActivity.this, "Только числа!", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
