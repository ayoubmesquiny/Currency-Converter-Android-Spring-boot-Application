package com.example.currencyexchange;

import static java.util.Objects.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.currencyexchange.model.ConversionCurrency;
import com.example.currencyexchange.retrofit.ApiInterface;
import com.example.currencyexchange.retrofit.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText value_;
    Spinner from_;
    Spinner to_;
    EditText result_;
    Button button_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        value_ = findViewById(R.id.currency_to_be_converted);
        from_ = findViewById(R.id.spinner1);
        to_ = findViewById(R.id.spinner2);
        result_ = findViewById(R.id.result);
        button_ =findViewById(R.id.button);

        //Adding Functionality
        String[] dropDownList = {"USD", "INR","EUR","NZD","MAD","KRW","MGA","UZS","MUR","ZMW","JPY","HKD","GBP","CNY"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dropDownList);
        from_.setAdapter(adapter);
        to_.setAdapter(adapter);

        RetrofitService retrofitService = new RetrofitService();
        ApiInterface apiInterface = retrofitService.getRetrofit().create(ApiInterface.class);

        button_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int value = Integer.parseInt(value_.getText().toString());
                String from = from_.getSelectedItem().toString();
                String to = to_.getSelectedItem().toString();

                ConversionCurrency conversionCurrency = new ConversionCurrency();
                conversionCurrency.setValue(value);
                conversionCurrency.setFrom(from);
                conversionCurrency.setTo(to);
                /*JSONObject paramObject = new JSONObject();
                try {
                    paramObject.put("value", value);
                    paramObject.put("from", from);
                    paramObject.put("to", to);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_SHORT).show();
                                result_.setText(Integer.toString(response.code()));

                                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                }*/

                apiInterface.convertCurrencies(conversionCurrency).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            result_.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);

                    }
                });



            }
        });



    }
}