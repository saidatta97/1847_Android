package com.example.materialapp;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class frag1 extends Fragment {

    Button sendbtn ,readbtn;
    TextInputEditText name1,email,phone,password,rePassword1;

    SQLiteDatabase myDB;

    dbHelper db;

//    public tab1() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragments1,container,false);
        TextInputEditText nameinput;
        nameinput= (TextInputEditText) view.findViewById(R.id.name);

        sendbtn = (Button) view.findViewById(R.id.send);
        readbtn = (Button) view.findViewById(R.id.read);

        name1= view.findViewById(R.id.name);
        email= view.findViewById(R.id.email);
        phone= view.findViewById(R.id.mobile);
        password= view.findViewById(R.id.password);
        rePassword1= view.findViewById(R.id.repassword);

        db = new dbHelper(getContext());

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name1.getText().toString();
                String mail= email.getText().toString();
                String no= phone.getText().toString();
                String pass=  password.getText().toString();
                String repass= rePassword1.getText().toString();

                Boolean checkinsertdata = db.insertData(name,mail,no,pass,repass);
                if(checkinsertdata==true){
                    Toast.makeText(getContext(),"User Registered Successfully", Toast.LENGTH_SHORT).show();

                    name1.setText("");
                    email.setText("");
                    phone.setText("");
                    password.setText("");
                    rePassword1.setText("");


                }else{
                    Toast.makeText(getContext(),"Error", Toast.LENGTH_SHORT).show();
                }


            }
        });


        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.readData();
                if(res.getCount()==0){
                    Toast.makeText(getContext(),"No User in Database",Toast.LENGTH_SHORT).show();
                    return;
                }
//                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

//                    email,phone,password,rePassword1
                    name1.setText(res.getString(0));
                    email.setText(res.getString(1));
                    phone.setText(res.getString(2));
                    password.setText(res.getString(3));
                    rePassword1.setText(res.getString(4));



//                    buffer.append("Name : "+res.getString(0)+"\n");
//                    buffer.append("No : "+res.getString(1)+"\n");
//                    buffer.append("Email : "+res.getString(2)+"\n");
//                    buffer.append("Pass : "+res.getString(3)+"\n");
//                    buffer.append("Re-pass : "+res.getString(4)+"\n\n");
                }
//                AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
//                builder.setCancelable(true);
//                builder.setTitle("Users Data");
//                builder.setMessage(buffer.toString());
//                builder.show();
            }
        });

        getActivity().setTitle("Login");
        return view;




    }

}
