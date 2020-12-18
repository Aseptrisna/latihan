package org.tensorflow.lite.examples.detection.Server;

public interface MyRmq {
    void Berhasil(String message);
    void Gagal();
}
