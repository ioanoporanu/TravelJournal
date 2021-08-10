package com.example.myapplication.ui.home;

import android.content.Intent;
import  android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AddNewJourneyActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.recycler_view.Journey;
import com.example.myapplication.recycler_view.JourneyAdapter;
import com.example.myapplication.recycler_view.JourneyDataBase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private JourneyAdapter journeyAdapter;

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private void loadJourneyList() {
        JourneyDataBase db = JourneyDataBase.getInstance(this.getContext());
        List<Journey> journeyList = db.journeyDao().getJourneys();
        journeyAdapter.setJourneyList(journeyList);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if(requestCode == 100){
            loadJourneyList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FloatingActionButton addNewJourneyButton = root.findViewById(R.id.floatingButton);
        addNewJourneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddNewJourneyActivity.class), 100);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

//        journeyList.add(new Journey("Romania", "Cluj", 500, R.drawable.cluj));
//        journeyList.add(new Journey("England", "London", 1000, R.drawable.london));
//        journeyList.add(new Journey("France", "Paris", 2000, R.drawable.paris));
//        journeyList.add(new Journey("Germany", "Berlin", 3000, R.drawable.berlin));
//        journeyList.add(new Journey("Spain", "Barcelona", 3000, R.drawable.barcelona));

        journeyAdapter = new JourneyAdapter(this.getContext());
        recyclerView.setAdapter(journeyAdapter);

//        recyclerView.setAdapter(new JourneyAdapter(journeyList));

        loadJourneyList();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}