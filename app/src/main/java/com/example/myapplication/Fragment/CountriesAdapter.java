package com.example.myapplication.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Country;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private List<Country> countries;

    public CountriesAdapter(FragmentActivity activity) {
        countries = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(countries.get(position), position);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void updateAdapter(List<Country> countries) {
        this.countries.clear();
        this.countries.addAll(countries);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View listItem) {
            super(listItem);
            textView = listItem.findViewById(R.id.item_text);
        }

        public void bind(Country country, int position) {
            textView.setText(country.getName());
        }

    }


}
