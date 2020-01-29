package com.example.myapplication.Presenter;

import androidx.annotation.NonNull;

import com.example.myapplication.CountryView;
import com.example.myapplication.Model.Country;
import com.example.myapplication.Model.CountryAsyncLoader;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.List;

public class CountryPresenterImp extends MvpBasePresenter<CountryView> implements CountryPresenter {


    @Override
    public void loadCountries(final boolean pullToRefresh) {
        ifViewAttached(new ViewAction<CountryView>() {
            @Override
            public void run(@NonNull CountryView view) {
                view.showLoading(false);
            }
        });
        CountryAsyncLoader loader = new CountryAsyncLoader(false, new CountryAsyncLoader.CountryAsyncListener() {
            @Override
            public void onSuccess(final List<Country> countries) {
              ifViewAttached(new ViewAction<CountryView>() {
                  @Override
                  public void run(@NonNull CountryView view) {
                      view.setData(countries);
                      view.showContent();
                      view.disableRefresh();
                  }
              });
            }

            @Override
            public void nError(final Exception e) {
                ifViewAttached(new ViewAction<CountryView>() {
                    @Override
                    public void run(@NonNull CountryView view) {
                        view.showError(e,pullToRefresh);
                    }
                });
            }
        });
        loader.execute();
    }
}
