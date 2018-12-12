package com.whitbread.places;

import com.whitbread.places.services.Venue;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PlaceDto {

    private String name;

    private String location;

    private List<Venue> venues;
}
