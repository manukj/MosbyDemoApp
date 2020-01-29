package com.example.myapplication.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.CountryView;
import com.example.myapplication.Model.Country;
import com.example.myapplication.Presenter.CountryPresenter;

import com.example.myapplication.Presenter.CountryPresenterImp;
import com.example.myapplication.R;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceFragment;

import java.util.List;

public class CountriesFragment extends MvpLceFragment<RecyclerView, List<Country>, CountryView, CountryPresenter>
        implements CountryView, SwipeRefreshLayout.OnRefreshListener {


    CountriesAdapter adapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framgment_layout,container,false);
       recyclerView = view.findViewById(R.id.contentView);
       swipeRefreshLayout = view.findViewById(R.id.refresh);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new CountriesAdapter(getActivity());
//
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        loadData(true);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "failled";
    }

    @Override
    public CountryPresenter createPresenter() {
        return new CountryPresenterImp();
    }

    @Override
    public void setData(List<Country> data) {
        adapter.updateAdapter(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadCountries(pullToRefresh);
    }

    @Override
    public void disableRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
