package com.group.isoft.bearsport.persist.venues;

import com.group.isoft.bearsport.model.venues.Venues;

public interface VenuesMapper {
    boolean addVenues(Venues venues);
    Venues fetchVenuesByUid(String uid);

}
