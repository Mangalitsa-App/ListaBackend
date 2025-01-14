package com.mangalitsa.litsa.controllers.dto;

public class PlaceApiResponse {
    private String id;
    private DisplayName displayName;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DisplayName getDisplayName() {
        return displayName;
    }

    public void setDisplayName(DisplayName displayName) {
        this.displayName = displayName;
    }

    // Nested class for displayName
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
