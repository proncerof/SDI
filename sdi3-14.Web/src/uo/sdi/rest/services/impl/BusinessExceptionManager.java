package uo.sdi.rest.services.impl;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import uo.sdi.business.exception.BusinessException;

/**
 * Class that takes care of the business exceptions
 * @author jlo
 *
 */
@Provider
public class BusinessExceptionManager implements
		ExceptionMapper<BusinessException> {

	@Override
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response toResponse(BusinessException b) {

		ResponseBuilder rb = Response.status(Status.BAD_REQUEST);

		rb.entity(b.getMessage());
		return rb.build();
	}

}
