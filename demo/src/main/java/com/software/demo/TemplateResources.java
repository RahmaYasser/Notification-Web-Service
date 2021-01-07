package com.software.demo;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("templates")
public class TemplateResources {
	TemplateOperations repo= new TemplateOperations();
	
	@GET
	@Path("template/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Template readTemplate(@PathParam("type")String type) {
		
		return repo.readTemplate(type);
	}
	
	@POST
	@Path("create")
	public void createTemplate(Template t) {
		
		repo.createTemplate(t);
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTemplate(Template t) {
		
		if(repo.readTemplate(t.getTemplateType())==null)
			repo.createTemplate(t);
		else
			repo.updateTemplate(t);	
	}
	
	
	@DELETE
	@Path("template/{type}")
	public void deleteTemplate(@PathParam("type")String type) {
		
	 	repo.deleteTemplate(type);
	}
}
