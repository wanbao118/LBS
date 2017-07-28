package com.group.isoft.bearsport.venues;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.venues.VenuesReqModel;
import com.group.isoft.bearsport.clientmodel.venues.VenuesRespModel;
import com.group.isoft.bearsport.model.venues.Venues;
import com.group.isoft.bearsport.persist.venues.VenuesMapper;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.Utils;

@Service
public class VenuesServiceImpl implements IVenuesService {

	@Resource
	VenuesMapper venuesMapper;

	public VenuesRespModel addVenues(VenuesReqModel venuesReqModel) {
		VenuesRespModel venuesRespModel = new VenuesRespModel();
		Venues venues;
		venues = venuesMapper.fetchVenuesByUid(venuesReqModel.getUid());

		if (venues != null) {
			return venuesRespModel;
		} else {
			venues = new Venues();
			venues.setId(Utils.getUUID());
			venues.setAddress(venuesReqModel.getAddress());
			venues.setContactNum(venuesReqModel.getTelephone());
			venues.setDetlUrl(venuesReqModel.getDetail_url());
			venues.setEnvRating(venuesReqModel.getEnvironment_rating());
			venues.setLatitude(venuesReqModel.getLatitude());
			venues.setLongitude(venuesReqModel.getLongitude());
			venues.setOverallRating(venuesReqModel.getOverall_rating());
			venues.setPrice(venuesReqModel.getPrice());
			venues.setServiceRating(venuesReqModel.getService_rating());
			venues.setUid(venuesReqModel.getUid());
			venues.setVenuesId("0001");
			venues.setVenuesName(venuesReqModel.getTitle());
	
			if (venuesMapper.addVenues(venues)) {
				venuesRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				venuesRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}
		}

		return venuesRespModel;
	}

}
