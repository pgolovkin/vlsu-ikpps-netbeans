/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vlsu.rest;

import com.google.gson.Gson;
import java.util.Calendar;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import ru.vlsu.domain.Student;

/**
 * REST Web Service
 *
 * @author p.golovkin
 */
@Path("student")
public class StudentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    /**
     * Retrieves representation of an instance of ru.vlsu.rest.StudentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        Student student = new Student();
        student.setId(1);
        student.setName("name");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1994);
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 5);
        student.setBirthdate(c.getTime());
        return gson.toJson(student);
    }

    /**
     * PUT method for updating or creating an instance of StudentResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
