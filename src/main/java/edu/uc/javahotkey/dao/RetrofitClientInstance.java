package edu.uc.javahotkey.dao;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitClientInstance {

    private static Retrofit retrofit;


    public static Retrofit getRetrofitInstance() {
        /*
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseURL("replace")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

         */
        return null;
    }
}
