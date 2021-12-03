package org.tensorflow.lite.examples.detection.Server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
//    public  static final String BASE_IP="http://asep.epizy.com";
    //    public  static final  String BASE_IP="http://172.31.0.30";
//   public static final String BASE_URL ="http://172.31.0.74/Api_TimeUP/Fungsi/";
//    public static final String BASE_URL =BASE_IP+"/Api_TimeUP/Fungsi/";
    public static final String BASE_URL ="http://192.168.43.247/API_Covid/";
    //    public  static final String Url_Provinsi="http://www.emsifa.com/api-wilayah-indonesia/api/";
    private static InitRetrofit mInstance;
    private Retrofit retrofit;
    private InitRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized InitRetrofit getInstance(){
        if (mInstance == null ){
            mInstance = new InitRetrofit();
        }
        return mInstance;
    }
    public ApiServices getApi(){
        return retrofit.create(ApiServices.class);
    }
}
