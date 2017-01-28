package org.sandy.jersy.SampleMessenger.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


public class LikesApp {

	@GET
	public String allLikesForMessage() {
		return "All Likes For Messages";
	}

	@GET
	@Path("/{likeId}")
	public String likesForMessage(@PathParam("likeId") long likeId, @PathParam("messageId") long messageId) {
		return "Likes For Message Id :" + messageId + " and LikeId :" + likeId;
	}
}
