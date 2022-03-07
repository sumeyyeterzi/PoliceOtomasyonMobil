package org.sbm.police.service;

import org.sbm.police.model.response.PoliceModel;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public  class  PoliceService {
    private static Retrofit retrofit=null;
    private static String Base_Url="http://10.0.2.2:8080/police/";


    public static Retrofit getClient(){
        if(retrofit== null)
        { retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create()) //mapleme işlemini gerçekleştirir.
            .client(new OkHttpClient())
            .build();
        return retrofit;     }

        return retrofit; }

}
