/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vlsu.rest;

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
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
@Path("students")
public class StudentsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentsResource
     */
    public StudentsResource() {
    }

    /**
     * Retrieves representation of an instance of ru.vlsu.rest.StudentsResource
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJSON() {
        Gson gson = new Gson();
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setId(1);
        student.setName("name");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1994);
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 5);
        student.setBirthdate(c.getTime());
        students.add(student);
        student = new Student();
        student.setId(2);
        student.setName("name2");
        c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1996);
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 5);
        student.setBirthdate(c.getTime());
        students.add(student);
        return gson.toJson(students);
    }

    /**
     * PUT method for updating or creating an instance of StudentsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJSON(String content) {
    }
}
