package com.faisal.peoplentech.lecture.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Anim  implements Serializable {
   // -----------------------------------com.example.Example.java-----------------------------------
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("Rating")
        @Expose
        private String rating;
        @SerializedName("episode")
        @Expose
        private Integer episode;
        @SerializedName("categorie")
        @Expose
        private String categorie;
        @SerializedName("studio")
        @Expose
        private String studio;
        @SerializedName("img")
        @Expose
        private String img;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public Integer getEpisode() {
            return episode;
        }

        public void setEpisode(Integer episode) {
            this.episode = episode;
        }

        public String getCategorie() {
            return categorie;
        }

        public void setCategorie(String categorie) {
            this.categorie = categorie;
        }

        public String getStudio() {
            return studio;
        }

        public void setStudio(String studio) {
            this.studio = studio;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }


}
