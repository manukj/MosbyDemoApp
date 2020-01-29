package com.example.myapplication;

import com.example.myapplication.Model.Country;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;

import java.util.List;

public interface CountryView extends MvpLceView<List<Country>> {
    void disableRefresh();
}
