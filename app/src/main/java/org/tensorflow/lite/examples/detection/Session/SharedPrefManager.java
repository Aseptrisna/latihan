package org.tensorflow.lite.examples.detection.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_LOGIN_APP = "Apps";
    public static final String SP_ID = "ID";
    public static final String USER= "User";
    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_TELPON= "spTelpon";
    public static final String SP_ALAMAT = "spAlamat";
    public static final String SP_Mac = "mac";
    public static final String SP_Prov = "prov";
    public static final String SP_Kab = "kab";
    public static final String SP_device_channel ="device_channel";
    public static final String SP_Status = "status";
    public  static final String Sp_suhu="suhu";
    public  static final String Sp_mac="mac";
    public  static final String Sp_gambar="gambar";
    public static final String SP_SUDAH_LOGIN = "SudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_LOGIN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }
    public String getUser(){
        return sp.getString(USER, "");
    }
    public String getSpId(){
        return sp.getString(SP_ID, "");
    }
    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }
    public String getSPAlamat(){
        return sp.getString(SP_ALAMAT, "");
    }
    public String getSPTelpon(){
        return sp.getString(SP_TELPON, "");
    }
    public String getSP_Mac(){
        return sp.getString(SP_Mac, "");
    }
    public String getSP_Prov(){
        return sp.getString(SP_Prov, "");
    }
    public String getSP_Kab(){
        return sp.getString(SP_Kab, "");
    }
    public String getSP_Status(){
        return sp.getString(SP_Status, "");
    }
    public String getSP_device_channel(){
        return sp.getString(SP_device_channel, "");
    }
    public String getSuhu(){
        return sp.getString(Sp_suhu, "");
    }
    public String getMac(){
        return sp.getString(Sp_mac, "");
    }
    public String getGambar(){
        return sp.getString(Sp_gambar, "");
    }
    public Boolean getSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
