package com.example.webclient;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.Attributes;

import static java.util.jar.Attributes.*;

public class async extends AsyncTask<Void, Void, Void> {
    String data="";
    String fData="";
    Double salary= Double.NaN;
    String line="";
   public static Double totalSalary=0.0;
    @Override
    protected Void doInBackground(Void... voids) {

        try {

            URL url = new URL("https://api.jsonbin.io/b/5f98044c30aaa01ce619982d");
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            while(line!=null){
                line = bufferedReader.readLine();
                data= data + line;
            }
            JSONArray jsonArray  = new JSONArray(data);
            ArrayList array = new ArrayList();
            for(int i= 0; i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                array.add("Name: " + jsonObject.get("lastName") + " "+
                        jsonObject.get("firstName") +"\n" +"Emp Code: " + jsonObject.get("empCode") +"\n" + "Salary :" + jsonObject.get("salary")+"\n");

                salary = jsonObject.getDouble("salary");
                totalSalary= totalSalary+salary;

            }
            Collections.sort(array);
            for(int i=0; i<array.size(); i++){
                fData = fData + array.get(i) + "\n";
            }

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.fData );
    }
}
