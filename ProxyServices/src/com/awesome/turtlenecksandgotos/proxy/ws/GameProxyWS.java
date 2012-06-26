package com.awesome.turtlenecksandgotos.proxy.ws;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.awesome.turtlenecksandgotos.model.GameHub;
import com.awesome.turtlenecksandgotos.proxy.GameProxyLocal;

/**
 * Session Bean implementation class DeveloperProxyService
 */
@Stateless
@LocalBean
@WebService
@Path("games")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class GameProxyWS {

	@EJB
	private GameProxyLocal proxy;
	
    /**
     * Default constructor. 
     */
    public GameProxyWS() {}

    @WebMethod
    @GET @Path("{developer}/{hubname}")
    public GameHub proxify(@PathParam("developer") final String developer, @PathParam("hubname") final String hubname) {
    	return proxy.proxify(developer, hubname);
    }
}
