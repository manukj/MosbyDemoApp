package com.example.myapplication.Model;

import android.os.AsyncTask;

import java.util.Collections;
import java.util.List;

public class CountryAsyncLoader extends AsyncTask<Void, Void, List<Country>> {


    // shouldFail is just to test fail and success condition
    private boolean shouldFail;
    private CountryAsyncListener listener;

    //Constructor
    public CountryAsyncLoader(boolean shouldFail, CountryAsyncListener listener) {
        this.shouldFail = shouldFail;
        this.listener = listener;
    }

    //interface
    public interface CountryAsyncListener {
        public void onSuccess(List<Country> countries);

        public void nError(Exception e);
    }

    @Override
    protected List<Country> doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Country> countries = CountryApi.getCountries();
        Collections.shuffle(countries);
        return countries;
    }

    @Override
    protected void onPostExecute(List<Country> countries) {
        if (isCancelled() || countries == null)
            return;
        if (shouldFail) {
            listener.nError(new Exception("Oops Something went wrong"));
        } else {
            listener.onSuccess(countries);
        }


    }
}
