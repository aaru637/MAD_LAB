package com.dk.mad_lab.fourth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.dk.mad_lab.R;
import java.util.ArrayList;

public class Experiment_4 extends AppCompatActivity {
    private EditText registerno, name, mobile;
    private Spinner department;
    private Database database;

    String[] departments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment4);

        Button add = findViewById(R.id.adddata);
        Button read = findViewById(R.id.readdata);
        Button update = findViewById(R.id.updatedata);
        Button delete = findViewById(R.id.deletedata);
        Button readall = findViewById(R.id.alldata);
        registerno = findViewById(R.id.registerno);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        department = findViewById(R.id.department);

        database = new Database(this);

        departments = getResources().getStringArray(R.array.department);

        ArrayAdapter adapter = new ArrayAdapter(Experiment_4.this, android.R.layout.simple_dropdown_item_1line, departments);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        department.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getRegisterNo().isEmpty()){registerNoNotify();}
                else{adddata();}}});

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getRegisterNo().isEmpty()){registerNoNotify();}
                else{readdata(adapter);}}});

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getRegisterNo().isEmpty()){registerNoNotify();}
                else{updatedata();}}});

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getRegisterNo().isEmpty()){registerNoNotify();}
                else{deletedata();}}});

        readall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readalldata();
            }});

    }

    // Getter Methods
    public String getRegisterNo(){
        return registerno.getText().toString().trim();
    }
    public String getName(){
        return name.getText().toString().trim();
    }
    public String getMobile(){
        return mobile.getText().toString().trim();
    }
    public String getDepartment(){
        return department.getSelectedItem().toString().trim();
    }

    //Setter Methods
    public void setRegisterNo(String registerNo){
        registerno.setText(registerNo);
    }
    public void setName(String name1){
        name.setText(name1);
    }
    public void setMobile(String mobile1){
        mobile.setText(mobile1);
    }
    public void setDepartment(ArrayAdapter adapter, String Department){
        int id;
        if(Department == null){id = 0;department.setSelection(id);}
        else{id = adapter.getPosition(Department);department.setSelection(id);}
    }

    //notify
    public void registerNoNotify(){
        Toast.makeText(this, "Register Not must be empty", Toast.LENGTH_LONG).show();
    }
    public void clear(){
        registerno.getText().clear();
        name.getText().clear();
        mobile.getText().clear();
        department.setSelection(0);
    }

    public void adddata(){
        boolean result = database.add(new User(getRegisterNo(), getName(), getMobile(), getDepartment()));
        if(result){Toast.makeText(this, "Data Added Successfully.", Toast.LENGTH_LONG).show();
            clear();}
        else{Toast.makeText(this, "Data Already Present.", Toast.LENGTH_LONG).show();}
    }

    public void readdata(ArrayAdapter adapter){
        User user = database.read(getRegisterNo(), this);
            setRegisterNo(user.RegisterNo);
            setName(user.Name);
            setMobile(user.Mobile);
            setDepartment(adapter, user.Department);
    }

    public void updatedata(){
        boolean result = database.update(new User(getRegisterNo(), getName(), getMobile(), getDepartment()));
        if(result){Toast.makeText(this, "Data Updated Successfully.", Toast.LENGTH_LONG).show();
            clear();}
        else{Toast.makeText(this, "Error Occured While Updating Data.", Toast.LENGTH_LONG).show();}
    }

    public void deletedata(){
        boolean result = database.delete(getRegisterNo());
        if(result){Toast.makeText(this, "Data Deleted Successfully.", Toast.LENGTH_LONG).show();
            clear();}
        else{Toast.makeText(this, "Error Occured While Deleting Data.", Toast.LENGTH_LONG).show();}
    }

    public void readalldata(){
        ArrayList<User> arrayList = database.readall();
        System.out.println("Register No\t\t Name\t\t\t Mobile\t\t\t Department\n");
        if (arrayList.isEmpty()){
            Toast.makeText(Experiment_4.this, "No Data Found", Toast.LENGTH_LONG).show();}
        else{for(User i : arrayList){
                System.out.println(i.RegisterNo + "\t" + i.Name + " \t\t" + i.Mobile + "\t\t\t" + i.Department + "\n");}}
    }
}