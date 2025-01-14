package com.mangalitsa.litsa.controllers.dto;

import java.util.List;

public class PlacesApiResponse {

    private List<Place> places;

    public static class Place {
        private String id;
        private List<String> types;
        private String formattedAddress;
        private String websiteUri;
        private String priceLevel;
        private DisplayName displayName;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }

        public List<String> getTypes() {
            return types;
        }
        public void setTypes(List<String> types) {
            this.types = types;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }
        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getWebsiteUri() {
            return websiteUri;
        }
        public void setWebsiteUri(String websiteUri) {
            this.websiteUri = websiteUri;
        }

        public String getPriceLevel() {
            return priceLevel;
        }
        public void setPriceLevel(String priceLevel) {
            this.priceLevel = priceLevel;
        }

        public DisplayName getDisplayName() {
            return displayName;
        }
        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public static class DisplayName {
            private String text;
            private String languageCode;

            public String getText() {
                return text;
            }
            public void setText(String text) {
                this.text = text;
            }

            public String getLanguageCode() {
                return languageCode;
            }
            public void setLanguageCode(String languageCode) {
                this.languageCode = languageCode;
            }
        }
    }

    public List<Place> getPlaces() {
        return places;
    }
    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
