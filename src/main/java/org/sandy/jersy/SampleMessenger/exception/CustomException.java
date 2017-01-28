package org.sandy.jersy.SampleMessenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.sandy.jersy.SampleMessenger.error.ErrorMessage;

@Provider
public class CustomException implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable th) {
		ErrorMessage errorMessage = new ErrorMessage(th.getMessage(), "Generic Error", "No data to show.");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
	}

}
