package com.lifehelper.android.bean.weather;

import java.util.List;

public class WeatherPlaceBean {

    /**
     * status
     */
    private String status;
    /**
     * query
     */
    private String query;
    /**
     * places
     */
    private List<PlacesDTO> places;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<PlacesDTO> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlacesDTO> places) {
        this.places = places;
    }

    public static class PlacesDTO {
        /**
         * id
         */
        private String id;
        /**
         * name
         */
        private String name;
        /**
         * formatted_address
         */
        private String formatted_address;
        /**
         * location
         */
        private LocationDTO location;
        /**
         * place_id
         */
        private String place_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public LocationDTO getLocation() {
            return location;
        }

        public void setLocation(LocationDTO location) {
            this.location = location;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public static class LocationDTO {
            /**
             * lat
             */
            private String lat;
            /**
             * lng
             */
            private String lng;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }
}
