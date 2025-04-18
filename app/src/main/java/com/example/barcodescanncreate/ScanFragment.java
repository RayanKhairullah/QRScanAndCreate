package com.example.barcodescanncreate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.widget.Toast;

public class ScanFragment extends Fragment {
    private HistoryViewModel vm;
    private TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scan, container, false);
        vm = new ViewModelProvider(this).get(HistoryViewModel.class);
        tvResult = v.findViewById(R.id.tv_scan_result);
        v.findViewById(R.id.btn_scan).setOnClickListener(btn -> {
            IntentIntegrator.forSupportFragment(this)
                    .setPrompt("Pindai QR/Barcode")
                    .initiateScan();
        });
        v.findViewById(R.id.btn_copy).setOnClickListener(btn -> {
            String text = tvResult.getText().toString();
            if(!text.isEmpty()) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Hasil Scan", text);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getContext(), "Tersalin ke clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && result.getContents() != null) {
            String text = result.getContents();
            tvResult.setText(text);
            ScanHistory h = new ScanHistory();
            h.data = text;
            h.timestamp = System.currentTimeMillis();
            vm.insert(h);
        }
    }
}
