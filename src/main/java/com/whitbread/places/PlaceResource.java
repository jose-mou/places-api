package com.whitbread.places;


import com.whitbread.places.services.FourSquareService;
import com.whitbread.places.services.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceResource {

    private PlaceService placeService;
    private FourSquareService fourSquareClient;

    @Autowired
    public PlaceResource(PlaceService placeService, FourSquareService fourSquareClient) {
        this.fourSquareClient = fourSquareClient;
        this.placeService = placeService;
    }

    @GetMapping(path = "/api/v1/places/{name}")
    public PlaceDto searchByName(@PathVariable("name") String name) {
        PlaceModel place = placeService.findByName(name);
        List<Venue> venues = fourSquareClient.searchVenuesByLocation(place.getLocation());
        PlaceDto result = PlaceDto.builder().
                location(place.getLocation()).
                name(place.getName()).
                venues(venues).
                build();
        return result;
    }

}