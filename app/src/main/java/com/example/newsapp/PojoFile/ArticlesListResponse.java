package com.example.newsapp.PojoFile;

import java.util.List;

public class ArticlesListResponse {
    public String count;

    public String next;


    public String previous;

    public List<ArticlesList> results;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ArticlesList> getResults() {
        return results;
    }

    public void setResults(List<ArticlesList> results) {
        this.results = results;
    }

    public static class ArticlesList {
        public String id;

        public String title;

        public String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getNews_site() {
            return news_site;
        }

        public void setNews_site(String news_site) {
            this.news_site = news_site;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getFeatured() {
            return featured;
        }

        public void setFeatured(String featured) {
            this.featured = featured;
        }

        public List<LaunchesListResponse> getLaunches() {
            return launches;
        }

        public void setLaunches(List<LaunchesListResponse> launches) {
            this.launches = launches;
        }

        public List<EventsListResponse> getEvents() {
            return events;
        }

        public void setEvents(List<EventsListResponse> events) {
            this.events = events;
        }

        public String image_url;

        public String news_site;

        public String summary;

        public String published_at;

        public String updated_at;

        public String featured;

        public List<LaunchesListResponse> launches;

        public List<EventsListResponse> events;
    }
}