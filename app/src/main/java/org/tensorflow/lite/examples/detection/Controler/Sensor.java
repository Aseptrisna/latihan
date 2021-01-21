package org.tensorflow.lite.examples.detection.Controler;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.examples.detection.Server.InitRetrofit;
import org.tensorflow.lite.examples.detection.View.Mysensor;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sensor {
final Mysensor mysensor;

    public Sensor(Mysensor mysensor) {
        this.mysensor = mysensor;
    }
    public void Simpan(String mac, String suhu, String keterangan, String gambar){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().SimpanSensor(keterangan,mac,gambar,suhu);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Message=jsonRESULTS.getString("message");
//                            myRequest.ServerResponse(Message);
                            mysensor.Berhasil_kirimdata(Message);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Message=jsonRESULTS.getString("message");
//                                myRequest.ServerNoResponse(Message);
                                mysensor.Gagal_kirimdata(Message);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        String error_message ="Ada Masalah Internet";
//                        myRequest.ServerNoResponse(error_message);
                        mysensor.No_Internet(error_message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("debug", "onFailure: ERROR > " + t.toString());
                try {
                    String error_message ="Server Tidak Merespon";
                    mysensor.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
