package com.group.isoft.bearsport.venues;

import com.group.isoft.bearsport.clientmodel.venues.VenuesReqModel;
import com.group.isoft.bearsport.clientmodel.venues.VenuesRespModel;

public interface IVenuesService {
	VenuesRespModel addVenues(VenuesReqModel venuesReqModel);
}
