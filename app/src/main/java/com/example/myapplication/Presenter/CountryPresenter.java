package com.example.myapplication.Presenter;

import com.example.myapplication.CountryView;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

public interface CountryPresenter extends MvpPresenter<CountryView> {

    void loadCountries(final boolean pullToRefresh);
}
