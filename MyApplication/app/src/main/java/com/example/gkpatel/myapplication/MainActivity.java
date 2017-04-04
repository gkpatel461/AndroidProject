package com.example.gkpatel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    EditText firstname,lastname,email;
    Button submit;
    Spinner city,department,collage;
    String selected_city,selected_collage,selected_department;
    CheckBox andoid,windows,ios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIds();


        List<String> cities =new ArrayList<String>();
        cities.add("Select City");
        cities.add("Ahmedabad");
        cities.add("Gandhinagar");
        cities.add("Vadodra");
        cities.add("Surat");

        List<String> depatments =new ArrayList<String>();
        depatments.add("Select Depatment");
        depatments.add("Information Technology");
        depatments.add("Computer");
        depatments.add("Civil");
        depatments.add("Electrical");

        List<String> collages =new ArrayList<String>();
        collages.add("Select Collage");
        collages.add("LDRP");
        collages.add("L.D");
        collages.add("Nirma");
        collages.add("DAIICT");




        ArrayAdapter<String> my_city=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,cities);
        my_city.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        city.setAdapter(my_city);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_city=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> mydepartment=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,depatments);
        mydepartment.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        department.setAdapter(mydepartment);
        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_department=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> mycollage=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,collages);
        my_city.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        collage.setAdapter(mycollage);
        collage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_collage=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringBuffer result = new StringBuffer();
                result.append("Android check : ").append(andoid.isChecked());
                result.append("\nWindows check : ").append(windows.isChecked());
                result.append("\nIos  check :").append(ios.isChecked());

                Toast.makeText(MainActivity.this,firstname.getText().toString()+" "+selected_city+" "+selected_department+" "+selected_collage+" "+result, Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void findViewByIds()
    {
        firstname= (EditText) findViewById(R.id.first_name);
        lastname= (EditText)findViewById(R.id.last_name);
        email = (EditText)findViewById(R.id.email);
        submit= (Button) findViewById(R.id.submit);
        city=(Spinner)findViewById(R.id.city);
        department=(Spinner)findViewById(R.id.department);
        collage=(Spinner)findViewById(R.id.collage);
        andoid= (CheckBox) findViewById(R.id.check_android);
        windows= (CheckBox) findViewById(R.id.check_windows);
        ios= (CheckBox) findViewById(R.id.check_ios);
    }


}
