package com.lifehelper.android.bean.weather;

import java.util.List;

public class WeatherDailyBean {

    /**
     * status
     */
    private String status;
    /**
     * api_version
     */
    private String api_version;
    /**
     * api_status
     */
    private String api_status;
    /**
     * lang
     */
    private String lang;
    /**
     * unit
     */
    private String unit;
    /**
     * tzshift
     */
    private int tzshift;
    /**
     * timezone
     */
    private String timezone;
    /**
     * server_time
     */
    private int server_time;
    /**
     * location
     */
    private List<Double> location;
    /**
     * result
     */
    private ResultDTO result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public static class ResultDTO {
        /**
         * daily
         */
        private DailyDTO daily;
        /**
         * primary
         */
        private int primary;

        public DailyDTO getDaily() {
            return daily;
        }

        public void setDaily(DailyDTO daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class DailyDTO {
            /**
             * status
             */
            private String status;
            /**
             * astro
             */
            private List<AstroDTO> astro;
            /**
             * precipitation
             */
            private List<PrecipitationDTO> precipitation;
            /**
             * temperature
             */
            private List<TemperatureDTO> temperature;
            /**
             * wind
             */
            private List<WindDTO> wind;
            /**
             * humidity
             */
            private List<HumidityDTO> humidity;
            /**
             * cloudrate
             */
            private List<CloudrateDTO> cloudrate;
            /**
             * pressure
             */
            private List<PressureDTO> pressure;
            /**
             * visibility
             */
            private List<VisibilityDTO> visibility;
            /**
             * dswrf
             */
            private List<DswrfDTO> dswrf;
            /**
             * air_quality
             */
            private AirQualityDTO air_quality;
            /**
             * skycon
             */
            private List<SkyconDTO> skycon;
            /**
             * skycon_08h_20h
             */
            private List<Skycon08h20hDTO> skycon_08h_20h;
            /**
             * skycon_20h_32h
             */
            private List<Skycon20h32hDTO> skycon_20h_32h;
            /**
             * life_index
             */
            private LifeIndexDTO life_index;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<AstroDTO> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroDTO> astro) {
                this.astro = astro;
            }

            public List<PrecipitationDTO> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationDTO> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureDTO> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureDTO> temperature) {
                this.temperature = temperature;
            }

            public List<WindDTO> getWind() {
                return wind;
            }

            public void setWind(List<WindDTO> wind) {
                this.wind = wind;
            }

            public List<HumidityDTO> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityDTO> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateDTO> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateDTO> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<PressureDTO> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureDTO> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityDTO> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityDTO> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfDTO> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfDTO> dswrf) {
                this.dswrf = dswrf;
            }

            public AirQualityDTO getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityDTO air_quality) {
                this.air_quality = air_quality;
            }

            public List<SkyconDTO> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconDTO> skycon) {
                this.skycon = skycon;
            }

            public List<Skycon08h20hDTO> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<Skycon08h20hDTO> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public List<Skycon20h32hDTO> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<Skycon20h32hDTO> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
            }

            public LifeIndexDTO getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexDTO life_index) {
                this.life_index = life_index;
            }

            public static class AirQualityDTO {
                /**
                 * aqi
                 */
                private List<AqiDTO> aqi;
                /**
                 * pm25
                 */
                private List<Pm25DTO> pm25;

                public List<AqiDTO> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiDTO> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25DTO> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25DTO> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * max
                     */
                    private MaxDTO max;
                    /**
                     * avg
                     */
                    private AvgDTO avg;
                    /**
                     * min
                     */
                    private MinDTO min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public MaxDTO getMax() {
                        return max;
                    }

                    public void setMax(MaxDTO max) {
                        this.max = max;
                    }

                    public AvgDTO getAvg() {
                        return avg;
                    }

                    public void setAvg(AvgDTO avg) {
                        this.avg = avg;
                    }

                    public MinDTO getMin() {
                        return min;
                    }

                    public void setMin(MinDTO min) {
                        this.min = min;
                    }

                    public static class MaxDTO {
                        /**
                         * chn
                         */
                        private int chn;
                        /**
                         * usa
                         */
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class AvgDTO {
                        /**
                         * chn
                         */
                        private int chn;
                        /**
                         * usa
                         */
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class MinDTO {
                        /**
                         * chn
                         */
                        private int chn;
                        /**
                         * usa
                         */
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25DTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * max
                     */
                    private int max;
                    /**
                     * avg
                     */
                    private int avg;
                    /**
                     * min
                     */
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public int getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public int getAvg() {
                        return avg;
                    }

                    public void setAvg(int avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }
            }

            public static class LifeIndexDTO {
                /**
                 * ultraviolet
                 */
                private List<UltravioletDTO> ultraviolet;
                /**
                 * carWashing
                 */
                private List<CarWashingDTO> carWashing;
                /**
                 * dressing
                 */
                private List<DressingDTO> dressing;
                /**
                 * comfort
                 */
                private List<ComfortDTO> comfort;
                /**
                 * coldRisk
                 */
                private List<ColdRiskDTO> coldRisk;

                public List<UltravioletDTO> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletDTO> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<CarWashingDTO> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<CarWashingDTO> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<DressingDTO> getDressing() {
                    return dressing;
                }

                public void setDressing(List<DressingDTO> dressing) {
                    this.dressing = dressing;
                }

                public List<ComfortDTO> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortDTO> comfort) {
                    this.comfort = comfort;
                }

                public List<ColdRiskDTO> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskDTO> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public static class UltravioletDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * index
                     */
                    private String index;
                    /**
                     * desc
                     */
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class CarWashingDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * index
                     */
                    private String index;
                    /**
                     * desc
                     */
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DressingDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * index
                     */
                    private String index;
                    /**
                     * desc
                     */
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * index
                     */
                    private String index;
                    /**
                     * desc
                     */
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdRiskDTO {
                    /**
                     * date
                     */
                    private String date;
                    /**
                     * index
                     */
                    private String index;
                    /**
                     * desc
                     */
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class AstroDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * sunrise
                 */
                private SunriseDTO sunrise;
                /**
                 * sunset
                 */
                private SunsetDTO sunset;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunriseDTO getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseDTO sunrise) {
                    this.sunrise = sunrise;
                }

                public SunsetDTO getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetDTO sunset) {
                    this.sunset = sunset;
                }

                public static class SunriseDTO {
                    /**
                     * time
                     */
                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunsetDTO {
                    /**
                     * time
                     */
                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class PrecipitationDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class TemperatureDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class WindDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private MaxDTO max;
                /**
                 * min
                 */
                private MinDTO min;
                /**
                 * avg
                 */
                private AvgDTO avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxDTO getMax() {
                    return max;
                }

                public void setMax(MaxDTO max) {
                    this.max = max;
                }

                public MinDTO getMin() {
                    return min;
                }

                public void setMin(MinDTO min) {
                    this.min = min;
                }

                public AvgDTO getAvg() {
                    return avg;
                }

                public void setAvg(AvgDTO avg) {
                    this.avg = avg;
                }

                public static class MaxDTO {
                    /**
                     * speed
                     */
                    private double speed;
                    /**
                     * direction
                     */
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class MinDTO {
                    /**
                     * speed
                     */
                    private double speed;
                    /**
                     * direction
                     */
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class AvgDTO {
                    /**
                     * speed
                     */
                    private double speed;
                    /**
                     * direction
                     */
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }
            }

            public static class HumidityDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class CloudrateDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class PressureDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class VisibilityDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class DswrfDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * max
                 */
                private double max;
                /**
                 * min
                 */
                private double min;
                /**
                 * avg
                 */
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class SkyconDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * value
                 */
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon08h20hDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * value
                 */
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon20h32hDTO {
                /**
                 * date
                 */
                private String date;
                /**
                 * value
                 */
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
