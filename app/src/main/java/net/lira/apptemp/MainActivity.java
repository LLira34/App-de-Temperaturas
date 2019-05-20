package net.lira.apptemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {
    EditText edtGrade, edtResult;
    Button btnConvert;
    MaterialSpinner spnOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflate
        edtGrade = findViewById(R.id.edt_grade);
        edtResult = findViewById(R.id.edt_result);
        btnConvert = findViewById(R.id.btn_convert);
        spnOptions = findViewById(R.id.spn_options);

        //Combo - Spinner
        ArrayAdapter<CharSequence> arrayAdapterSupp = ArrayAdapter.createFromResource(this,
                R.array.cmbOptions, android.R.layout.simple_dropdown_item_1line);
        spnOptions.setAdapter(arrayAdapterSupp);

        spnOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
                switch (position) {
                    case 0:
                        btnConvert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                convFahToCel();
                            }
                        });
                        Toast.makeText(getApplication(), "F to C", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        btnConvert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                convCelToFah();
                            }
                        });
                        Toast.makeText(getApplication(), "C to F", Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // Method for convert fahrenheit to celsius
    public double convFahToCel() {
        double fahrenheit = Double.parseDouble(String.valueOf(edtGrade.getText()));
        double celsius = 0.0;
        celsius = 5 * ((fahrenheit - 32) / 9);
        NumberFormat nm = NumberFormat.getNumberInstance();
        edtResult.setText(nm.format(celsius));
        return celsius;
    }

    // Method for convert celsius to fahrenheit
    public double convCelToFah() {
        double celsius = Double.parseDouble(String.valueOf(edtGrade.getText()));
        double fahrenheit = 0.0;
        fahrenheit = 32 + ((9 * celsius) / 5);
        NumberFormat nm = NumberFormat.getNumberInstance();
        edtResult.setText(nm.format(fahrenheit));
        return fahrenheit;
    }

}//End class
