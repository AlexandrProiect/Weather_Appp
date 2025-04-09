  
  
package com.alexdevv.springboot_weatherapp;



public class WeatherResponse {
    private Main main;
    private Wind wind;
    private String name;
    private Weather[] weather; 

    private long dt; 
                                                                      
     public Weather[] getWeather() {
    return weather;
}

public void setWeather(Weather[] weather) {
    this.weather = weather;
}

public static class Weather {
    private String main;  
    private String description;  
    private String icon;  

    
    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
                                                   
    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
   
     

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }


    public static class Main {
        private double temp;
        private int humidity;
        private int pressure;
        
        public int getPressure(){
            return pressure;
        }
        public void setPressure(int pressure){
            this.pressure=pressure;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }
    
    public static class Wind {
        private double speed; 
        private int deg;

        public int getDeg(){
            return deg;
        }
        public void setDeg(int deg){
            this.deg=deg;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
     }
}



 