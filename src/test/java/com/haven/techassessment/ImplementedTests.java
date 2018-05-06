package com.haven.techassessment;

import com.haven.techassessment.model.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ImplementedTests extends BaseTest {

    @Test(dataProvider = "genreList")
    public void tv_genreList_verifyMultipleGenresAreReturned(String genre) throws IOException {
        final String gameOfThronesID = "1399";

        TV tv = apiHelper.get("/tv/" + gameOfThronesID, TV.class);

        List<Genre> genres = tv.getGenres();

        Assert.assertTrue(genres.stream().anyMatch(g -> g.getName().equals(genre)),
                "The expected " + genre + " was not found within the Genre list for this TV show.");
    }

    //Note that I made the assertion include > 0, as they could add more shows with the same title.
    @Test
    public void search_nonEnglishName_itemFound() {
        final String searchQuery = "ドリフェス!";
        final String dreamFestival = "Dream Festival!";

        Search search =
                apiHelper.get("/search/tv", "&query=" + searchQuery, Search.class);
        List<Result> results = search.getResults();

        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(Result result : results) {
            String showName = result.getName();
            Assert.assertTrue(showName.contains(dreamFestival),
                    "The search results did not contain the name searched for.");
        }
    }

    @Test
    public void discover_onePagePopularMovies_returnsOnePageOnly() {
        final int pageCount = 1;
        final int pageSize = 20;

        Discover discover = apiHelper.get("/discover/movie",
                "&&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + pageCount,
                Discover.class);

        int page = discover.getPage();
        int resultsSize = discover.getResults().size();

        Assert.assertEquals(pageCount, page, "There should only be one page.");
        Assert.assertEquals(pageSize, resultsSize, "moo");
    }

    @DataProvider
    public Object[][] genreList() {
        return new Object[][]{
                {"Sci-Fi & Fantasy"}, {"Drama"}, {"Action & Adventure"}
        };
    }
}
