package com.example.barcodescanncreate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView rv = v.findViewById(R.id.rv_history);
        HistoryViewModel vm = new ViewModelProvider(this).get(HistoryViewModel.class);
        HistoryAdapter adapter = new HistoryAdapter(vm);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        vm.allHistory.observe(getViewLifecycleOwner(), adapter::submitList);
        return v;
    }
}
