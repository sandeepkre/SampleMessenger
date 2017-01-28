package org.sandy.jersy.SampleMessenger.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")

public class CommentsApp {
	@GET
	public String allCommentsForMessage() {
		return "All Comments For Messages";
	}

	@GET
	@Path("/{commentId}")
	public String commentForMessage(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
		return "Comments For Message Id :" + messageId + " and CommentId :" + commentId;
	}
}
