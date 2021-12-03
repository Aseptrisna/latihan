package org.tensorflow.lite.examples.detection.Server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {
    @FormUrlEncoded
    @POST("simpan.php")
    Call<ResponseBody> SimpanSensor(
            @Field("Keterangan") String keterangan,
            @Field("Serial_Number") String serial_number,
            @Field("Gambar") String gambar,
            @Field("suhuruangan") String suhuruangan,
            @Field("Suhu_Tubuh") String suhu_tubuh,
            @Field("suhuhasil") String suhuhasil
    );
}
