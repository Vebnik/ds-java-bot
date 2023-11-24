package com.lava.bot.service;

import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;

public class OpenWeatherClient {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final Dotenv dotenv = Dotenv.load();
    private static final String token = dotenv.get("OW_TOKEN");

    public static WeatherData getByCity(String city) {
        String url = String.format(
            "%s/weather/?q=%s&units=metric&lang=ru&appid=%s", 
            BASE_URL, city, token
        );

        try {
            String response = NetClient.get(url);
            JSONObject obj = new JSONObject(response);

            WeatherMain weatherMain = new WeatherMain(obj.getJSONObject("main"));
            WeatherData weatherData = new WeatherData(obj.getInt("id"), obj.getString("name"), weatherMain);

            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class WeatherMain {
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public double pressure;
        public double humidity;

        public WeatherMain(JSONObject main) {
            this.temp = main.getDouble("temp");
            this.feels_like = main.getDouble("feels_like");
            this.temp_min = main.getDouble("temp_min");
            this.temp_max = main.getDouble("temp_max");
            this.pressure = main.getDouble("pressure");
            this.humidity = main.getDouble("humidity");
        }
    }

    public static class WeatherData {
        public int id;
        public String name;
        public WeatherMain main;

        public WeatherData(int id, String name, WeatherMain main) {
            this.id = id;
            this.name = name;
            this.main = main;
        }
    }
}
