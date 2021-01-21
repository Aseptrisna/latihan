package org.tensorflow.lite.examples.detection.View;

public interface Mysensor {
    void Berhasil_kirimdata(String Message);

    void Gagal_kirimdata(String Message);

    void No_Internet(String Message);
}
