/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osmadeit.mystory.rest;

import com.google.gson.Gson;
import com.osmadeit.mystory.beans.StoriesBean;
import com.osmadeit.mystory.entities.Stories;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author os
 */
@Path("/stories")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoriesRest {
    @EJB
    StoriesBean storyService; 
 
    @GET
    @Path("/list")
    public List<Stories> findStories(){
       List<Stories> stories = storyService.getStories();
       return stories;
    }
  
    @GET
    @Path("/{id}")
    public Stories findAllStories(@PathParam("id") int id){
       Stories stories = storyService.getStoriesById(id);
       return stories;
    }
    
    @POST
    @Path("/create")
    public Stories saveStories(Stories story){
        storyService.createStories(story);
        return story;
    }
    
    @Path("/update/{id}")
    @PUT
    public Stories update(@PathParam("id") int id, Stories editedStory) {
        Stories story = storyService.updateStory(id, editedStory);
        return story;
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Stories deleteStories(@PathParam("id") int id){
       Stories stories = storyService.deleteStories(id);
       return stories;
    }
}
