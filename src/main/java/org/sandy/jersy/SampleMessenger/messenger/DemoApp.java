package org.sandy.jersy.SampleMessenger.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

@Path("/demo")
public class DemoApp {
	
	@GET
	@Path("basic")
	public String demo(@MatrixParam("name") String name) {
		
		return "Hai :" + name;
	}
}
