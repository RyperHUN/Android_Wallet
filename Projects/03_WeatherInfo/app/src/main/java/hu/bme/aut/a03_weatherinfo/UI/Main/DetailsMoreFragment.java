package hu.bme.aut.a03_weatherinfo.UI.Main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hu.bme.aut.a03_weatherinfo.R;
import hu.bme.aut.a03_weatherinfo.UI.Details.WeatherDataHolder;
import hu.bme.aut.a03_weatherinfo.model.WeatherData;


public class DetailsMoreFragment extends Fragment {
    private TextView tvTemperature;
    private TextView tvMinTemp;
    private TextView tvMaxTemp;
    private TextView tvPressure;
    private TextView tvHumidity;
    private WeatherDataHolder weatherDataHolder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof WeatherDataHolder) {
            weatherDataHolder = (WeatherDataHolder) getActivity();
        } else {
            throw new RuntimeException("Activity must implement WeatherDataHolder interface!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_more, container, false);
        tvTemperature = (TextView) view.findViewById(R.id.tvTemperature);
        tvMinTemp = (TextView) view.findViewById(R.id.tvMinTemp);
        tvMaxTemp = (TextView) view.findViewById(R.id.tvMaxTemp);
        tvPressure = (TextView) view.findViewById(R.id.tvPressure);
        tvHumidity = (TextView) view.findViewById(R.id.tvHumidity);
        if (weatherDataHolder.getWeatherData() != null) {
            showWeatherData();
        }
        return view;
    }

    private void showWeatherData() {
        WeatherData weatherData = weatherDataHolder.getWeatherData();
        tvTemperature.setText("" + weatherData.main.temp);
        tvMinTemp.setText("" + weatherData.main.temp_min);
        tvMaxTemp.setText("" + weatherData.main.temp_max);
        tvPressure.setText("" + weatherData.main.pressure);
        tvHumidity.setText("" + weatherData.main.humidity);
    }
}