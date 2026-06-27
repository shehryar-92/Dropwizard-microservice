package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyscanner.model.SearchResult;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        InputStream hotelsStream = getClass().getResourceAsStream("/hotels.json");
        InputStream carsStream = getClass().getResourceAsStream("/rental_cars.json");

        List<SearchResult> hotels = mapper.readValue(hotelsStream, new TypeReference<List<SearchResult>>() {});
        List<SearchResult> cars = mapper.readValue(carsStream, new TypeReference<List<SearchResult>>() {});

        List<SearchResult> allResults = new ArrayList<>();
        allResults.addAll(hotels);
        allResults.addAll(cars);

        environment.jersey().register(new SearchResource(allResults));
    }
}
