/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vlsu.student.webservice;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.vlsu.student.entity.WsUser;

/**
 *
 * @author p.golovkin
 */
@WebService(serviceName = "userService")
@Stateless()
public class NewWebService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "findUser")
    public List<WsUser> findUser(@WebParam(name = "name") String name, @WebParam(name = "birthdate") Date birthdate) {
        Query query = entityManager.createNamedQuery("WsUser.findByBirthdayAndName");
        query.setParameter("birthday", birthdate);
        query.setParameter("name", name);
        
        return query.getResultList();
    }

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "addUser")
    public Long addUser(@WebParam(name = "user") WsUser user) {
        entityManager.persist(user);
        return user.getId();
    }
}
