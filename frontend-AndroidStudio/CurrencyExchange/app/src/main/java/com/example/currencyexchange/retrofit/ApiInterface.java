package com.example.currencyexchange.retrofit;

import com.example.currencyexchange.model.ConversionCurrency;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @Headers("Content-Type: application/json")
    @POST("/currency-converter")
    Call<ResponseBody> convertCurrencies(@Body ConversionCurrency conversionCurrency);


    //Call<ResponseBody> convertCurrencies(@Body JSONObject body);

    //Call<ConversionCurrency> convertCurrencies(@Body ConversionCurrency conversionCurrency);

}
