package com.skyscanner;

import com.skyscanner.model.Search;
import com.skyscanner.model.SearchResult;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final List<SearchResult> searchResults;

    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @POST
    public List<SearchResult> search(Search search) {
        return searchResults.stream()
            .filter(r -> r.getCity().equalsIgnoreCase(search.getCity()))
            .collect(Collectors.toList());
    }
}
