package org.sandy.jersy.SampleMessenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messages {

	private long id;
	private String message;
	private Date created;
	private String author;
	List<Link> listOfLinks = new ArrayList<>();

	public Messages() {

	}

	public Messages(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Link> getListOfLinks() {
		return listOfLinks;
	}

	public void setListOfLinks(List<Link> listOfLinks) {
		this.listOfLinks = listOfLinks;
	}

	public void addLink(String link, String rel) {
		Link links = new Link();
		links.setLink(link);
		links.setRel(rel);
		listOfLinks.add(links);
	}
}
