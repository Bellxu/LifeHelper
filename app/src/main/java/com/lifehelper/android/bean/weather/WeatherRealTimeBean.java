package com.lifehelper.android.bean.weather;

import java.util.List;

public class WeatherRealTimeBean {

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
         * realtime
         */
        private RealtimeDTO realtime;
        /**
         * primary
         */
        private int primary;

        public RealtimeDTO getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeDTO realtime) {
            this.realtime = realtime;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class RealtimeDTO {
            /**
             * status
             */
            private String status;
            /**
             * temperature
             */
            private double temperature;
            /**
             * humidity
             */
            private double humidity;
            /**
             * cloudrate
             */
            private double cloudrate;
            /**
             * skycon
             */
            private String skycon;
            /**
             * visibility
             */
            private int visibility;
            /**
             * dswrf
             */
            private double dswrf;
            /**
             * wind
             */
            private WindDTO wind;
            /**
             * pressure
             */
            private double pressure;
            /**
             * apparent_temperature
             */
            private double apparent_temperature;
            /**
             * precipitation
             */
            private PrecipitationDTO precipitation;
            /**
             * air_quality
             */
            private AirQualityDTO air_quality;
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

            public double getTemperature() {
                return temperature;
            }

            public void setTemperature(double temperature) {
                this.temperature = temperature;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public double getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(double cloudrate) {
                this.cloudrate = cloudrate;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public int getVisibility() {
                return visibility;
            }

            public void setVisibility(int visibility) {
                this.visibility = visibility;
            }

            public double getDswrf() {
                return dswrf;
            }

            public void setDswrf(double dswrf) {
                this.dswrf = dswrf;
            }

            public WindDTO getWind() {
                return wind;
            }

            public void setWind(WindDTO wind) {
                this.wind = wind;
            }

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
            }

            public double getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(double apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public PrecipitationDTO getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationDTO precipitation) {
                this.precipitation = precipitation;
            }

            public AirQualityDTO getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityDTO air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexDTO getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexDTO life_index) {
                this.life_index = life_index;
            }

            public static class WindDTO {
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

            public static class PrecipitationDTO {
                /**
                 * local
                 */
                private LocalDTO local;
                /**
                 * nearest
                 */
                private NearestDTO nearest;

                public LocalDTO getLocal() {
                    return local;
                }

                public void setLocal(LocalDTO local) {
                    this.local = local;
                }

                public NearestDTO getNearest() {
                    return nearest;
                }

                public void setNearest(NearestDTO nearest) {
                    this.nearest = nearest;
                }

                public static class LocalDTO {
                    /**
                     * status
                     */
                    private String status;
                    /**
                     * datasource
                     */
                    private String datasource;
                    /**
                     * intensity
                     */
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }

                public static class NearestDTO {
                    /**
                     * status
                     */
                    private String status;
                    /**
                     * distance
                     */
                    private double distance;
                    /**
                     * intensity
                     */
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public double getDistance() {
                        return distance;
                    }

                    public void setDistance(double distance) {
                        this.distance = distance;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }
            }

            public static class AirQualityDTO {
                /**
                 * pm25
                 */
                private int pm25;
                /**
                 * pm10
                 */
                private int pm10;
                /**
                 * o3
                 */
                private int o3;
                /**
                 * so2
                 */
                private int so2;
                /**
                 * no2
                 */
                private int no2;
                /**
                 * co
                 */
                private double co;
                /**
                 * aqi
                 */
                private AqiDTO aqi;
                /**
                 * description
                 */
                private DescriptionDTO description;

                public int getPm25() {
                    return pm25;
                }

                public void setPm25(int pm25) {
                    this.pm25 = pm25;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public AqiDTO getAqi() {
                    return aqi;
                }

                public void setAqi(AqiDTO aqi) {
                    this.aqi = aqi;
                }

                public DescriptionDTO getDescription() {
                    return description;
                }

                public void setDescription(DescriptionDTO description) {
                    this.description = description;
                }

                public static class AqiDTO {
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

                public static class DescriptionDTO {
                    /**
                     * chn
                     */
                    private String chn;
                    /**
                     * usa
                     */
                    private String usa;

                    public String getChn() {
                        return chn;
                    }

                    public void setChn(String chn) {
                        this.chn = chn;
                    }

                    public String getUsa() {
                        return usa;
                    }

                    public void setUsa(String usa) {
                        this.usa = usa;
                    }
                }
            }

            public static class LifeIndexDTO {
                /**
                 * ultraviolet
                 */
                private UltravioletDTO ultraviolet;
                /**
                 * comfort
                 */
                private ComfortDTO comfort;

                public UltravioletDTO getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(UltravioletDTO ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public ComfortDTO getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortDTO comfort) {
                    this.comfort = comfort;
                }

                public static class UltravioletDTO {
                    /**
                     * index
                     */
                    private int index;
                    /**
                     * desc
                     */
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
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
                     * index
                     */
                    private int index;
                    /**
                     * desc
                     */
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
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
        }
    }
}
