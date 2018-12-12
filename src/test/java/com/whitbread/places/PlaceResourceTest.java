package com.whitbread.places;

import com.whitbread.places.services.FourSquareService;
import junit.framework.TestCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaceResourceTest extends TestCase {

    public static final String FAKE_PLACE_NAME = "fakePlaceName";
    public static final String FAKE_PLACE_LOCATION = "fakePlaceLocation";
    private PlaceService placeService;
    private FourSquareService fourSquareService;

    private PlaceResource resource;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        placeService = mock(PlaceService.class);
        fourSquareService = mock(FourSquareService.class);
        resource = new PlaceResource(placeService, fourSquareService);
    }

    public void testSearchByName_ExistingName_returnPlaceWithVenues() {
        List mockVenues = mock(List.class);
        PlaceModel mockPlaceModel = new PlaceModel(FAKE_PLACE_NAME, FAKE_PLACE_LOCATION);
        when(placeService.findByName(FAKE_PLACE_NAME)).thenReturn(mockPlaceModel);
        when(fourSquareService.searchVenuesByLocation(FAKE_PLACE_LOCATION)).thenReturn(mockVenues);

        PlaceDto placeDto = resource.searchByName(FAKE_PLACE_NAME);

        assertEquals(FAKE_PLACE_NAME, placeDto.getName());
        assertEquals(FAKE_PLACE_LOCATION, placeDto.getLocation());
        assertEquals(mockVenues, placeDto.getVenues());
    }
}