package com.haven.techassessment.endpoint;

/*
    Note that I ended up not using this class, but left it to show the thought process. I was going to create
    builder objects so you could make network requests based on the actual objects. I feel the approach would make
    tests very easy to write, but overall I felt like the work was too much for this limited engagement.
 */
/**
 * Object to encapsulate the 30+ optional parameters that make up the Movie Discover endpoint.
 *  @see <a href="https://developers.themoviedb.org/3/discover/movie-discover">movie-discover</a>
 */
public class MovieDiscover {

    private MovieDiscover(MovieDiscoverBuilder builder) {
    }

    public static class MovieDiscoverBuilder {
        private String language;
        private boolean includeAdult;
        private int page;
        private double voteAverage;

        /*
         *  Outside of api_key, all parameters of this endpoint are optional. Our builder constructor is no-args
         */
        public MovieDiscoverBuilder() {
        }

        //<editor-fold desc="String Parameters">
        public MovieDiscoverBuilder language(String langauge) {
            this.language = langauge;
            return this;
        }

        /* Omitted 18 other String parameters */
        //</editor-fold>

        //<editor-fold desc="Boolean Parameters">
        public MovieDiscoverBuilder includeAdult(boolean includeAdult) {
            this.includeAdult = includeAdult;
            return this;
        }

        /* Omitted 1 other Boolean parameters */
        //</editor-fold>

        //<editor-fold desc="Integer Parameters">
        public MovieDiscoverBuilder page(int page) {
            this.page = page;
            return this;
        }

        /* Omitted 9 other Integer parameters */
        //</editor-fold>

        //<editor-fold desc="Number Parameters">
        //TODO: The next method would have been lessThan, so I could have defined an enum to be passed in as a parameter
        public MovieDiscoverBuilder voteAverage_greaterThan(double voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        /* Omitted 11 other Number parameters */
        //</editor-fold>

        public MovieDiscover build() {
            return new MovieDiscover(this);
        }
    }
}
