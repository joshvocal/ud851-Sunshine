package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by josh on 5/23/17.
 */

// DONE (15) Add a class file called ForecastAdapter
// DONE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends
        RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    // DONE (23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // DONE (24) Override onCreateViewHolder
    // DONE (25) Within onCreateViewHolder, inflate the list item xml into a view
    // DONE (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);

        return viewHolder;
    }

    // DONE (27) Override onBindViewHolder
    // DONE (28) Set the text of the TextView to the weather for this list item's position
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherForThisDay = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherForThisDay);
    }

    // DONE (29) Override getItemCount
    // DONE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    @Override
    public int getItemCount() {
        if (mWeatherData == null) {
            return 0;
        } else {
            return mWeatherData.length;
        }
    }

    // DONE (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // DONE (32) After you save mWeatherData, call notifyDataSetChanged
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    // TODO (47) Create the default constructor (we will pass in parameters in a later lesson)

    // DONE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // DONE (17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
        // DONE (18) Create a public final TextView variable called mWeatherTextView

        // DONE (19) Create a constructor for this class that accepts a View as a parameter
        // DONE (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // DONE (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }


}
