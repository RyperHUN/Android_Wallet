package hu.bme.aut.a03_weatherinfo.Network;

import hu.bme.aut.a03_weatherinfo.model.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ryper on 2016. 10. 20..
 */
public interface WeatherApi {
    @GET("/data/2.5/weather")
    Call<WeatherData> getWeather(@Query("q") String cityName,
                                 @Query("units") String units,
                                 @Query("appid") String appId);
}
