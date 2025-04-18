package com.example.barcodescanncreate;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.Date;

public class HistoryAdapter extends ListAdapter<ScanHistory, HistoryAdapter.Holder> {

    private final HistoryViewModel viewModel;

    public HistoryAdapter(HistoryViewModel viewModel) {
        super(DIFF);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ScanHistory item = getItem(position);
        holder.tvData.setText(item.data);
        holder.tvTimestamp.setText(DateFormat.getDateTimeInstance().format(new Date(item.timestamp)));

        // Handle klik tombol hapus
        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setTitle("Hapus Riwayat")
                    .setMessage("Apakah Anda yakin ingin menghapus item ini?")
                    .setPositiveButton("Ya", (dialog, which) -> viewModel.delete(item))
                    .setNegativeButton("Tidak", null)
                    .show();
        });
    }

    private static final DiffUtil.ItemCallback<ScanHistory> DIFF =
            new DiffUtil.ItemCallback<ScanHistory>() {
                @Override
                public boolean areItemsTheSame(@NonNull ScanHistory oldItem, @NonNull ScanHistory newItem) {
                    return oldItem.id == newItem.id;
                }

                @Override
                public boolean areContentsTheSame(@NonNull ScanHistory oldItem, @NonNull ScanHistory newItem) {
                    return oldItem.equals(newItem);
                }
            };

    static class Holder extends RecyclerView.ViewHolder {
        TextView tvData, tvTimestamp;
        Button btnDelete;

        Holder(View v) {
            super(v);
            tvData = v.findViewById(R.id.tv_data);
            tvTimestamp = v.findViewById(R.id.tv_timestamp);
            btnDelete = v.findViewById(R.id.btn_delete);
        }
    }
}