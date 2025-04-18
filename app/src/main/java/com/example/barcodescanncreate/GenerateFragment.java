package com.example.barcodescanncreate;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateFragment extends Fragment {
    private Bitmap qrBitmap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_generate, container, false);
        EditText et = v.findViewById(R.id.et_input);
        ImageView iv = v.findViewById(R.id.iv_qr_code);

        v.findViewById(R.id.btn_generate).setOnClickListener(b -> {
            String text = et.getText().toString().trim();
            try {
                BitMatrix bm = new MultiFormatWriter()
                        .encode(text, BarcodeFormat.QR_CODE, 512, 512);
                qrBitmap = new BarcodeEncoder().createBitmap(bm);
                iv.setImageBitmap(qrBitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        });
        v.findViewById(R.id.btn_download).setOnClickListener(b -> {
            if(qrBitmap != null) {
                String savedImageURL = MediaStore.Images.Media.insertImage(
                        requireContext().getContentResolver(),
                        qrBitmap,
                        "QRCode_"+System.currentTimeMillis(),
                        "Generated QR Code"
                );

                if(savedImageURL != null) {
                    Toast.makeText(getContext(), "QR disimpan di galeri", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Gagal menyimpan QR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}