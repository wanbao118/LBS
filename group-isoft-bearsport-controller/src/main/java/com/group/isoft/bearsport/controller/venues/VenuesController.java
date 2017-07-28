package com.group.isoft.bearsport.controller.venues;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.isoft.bearsport.clientmodel.venues.VenuesReqModel;
import com.group.isoft.bearsport.clientmodel.venues.VenuesRespModel;
import com.group.isoft.bearsport.venues.IVenuesService;

@Controller
@RequestMapping("/venues")
public class VenuesController {
	private static final Logger sysLogger = Logger.getLogger("customer");

	@Resource
	IVenuesService venuesService;

	@RequestMapping(value = "/venuesAdd", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object venuesMaintain(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody List<VenuesReqModel> venuesRequestList) throws Exception {
		VenuesRespModel venuesRespModel = new VenuesRespModel();

		for (VenuesReqModel venuesRequest : venuesRequestList) {
				venuesRespModel = addVenues(venuesRequest);	
		}

		return venuesRespModel;
	}

	private VenuesRespModel addVenues(@RequestBody VenuesReqModel venuesRequest) {
		return venuesService.addVenues(venuesRequest);
	}
}
