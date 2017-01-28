package org.sandy.jersy.SampleMessenger.messenger;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.sandy.jersy.SampleMessenger.model.Messages;
import org.sandy.jersy.SampleMessenger.service.BeanParamClass;
import org.sandy.jersy.SampleMessenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessengerApp {

	MessageService messageService = new MessageService();

	@GET
	public List<Messages> getMessages(@QueryParam("year") int year) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Messages getMessage(@BeanParam BeanParamClass bPC, @Context UriInfo uriInfo) {
		System.out.println(bPC.getName());
		/* return messageService.getMessage(bPC.getMessageId()); */
		/* return Response.status(Status.FOUND).entity(message).build(); */
		Messages message = messageService.getMessage(bPC.getMessageId());
		String uri = getUriSelf(bPC, uriInfo);
		String uriProf = getUriProfile(bPC, uriInfo);
		String uriComm = getUriComments(bPC, uriInfo);
		message.addLink(uri, "self");
		message.addLink(uriProf, "profile");
		message.addLink(uriComm, "comments");
		return message;
	}

	private String getUriComments(BeanParamClass bPC, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(MessengerApp.class).path(MessengerApp.class, "getComments")
				.resolveTemplate("messageId", bPC.getMessageId()).path(CommentsApp.class).build().toString();
		return uri;
	}

	private String getUriSelf(BeanParamClass bPC, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(MessengerApp.class).path(Long.toString((bPC.getMessageId())))
				.build().toString();
		return uri;
	}

	private String getUriProfile(BeanParamClass bPC, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileApp.class).path(Long.toString((bPC.getMessageId())))
				.build().toString();
		return uri;
	}

	@POST
	public Response saveMessage(Messages message, @Context UriInfo uriInfo) {
		Messages newMessage = messageService.addMessage(message);
		String id = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(uri).entity(newMessage).build();
	}

	@PUT
	@Path("/{messageId}")
	public Messages updateMessage(@PathParam("messageId") long messageId, Messages message) {
		message.setId(messageId);
		System.out.println(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Messages deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}

	@Path("/{messageId}/comments")
	public CommentsApp getComments() {
		return new CommentsApp();
	}

	/*
	 * @Path("/{messageId}/likes") public LikesApp getLikes() { return new
	 * LikesApp(); }
	 */
}
