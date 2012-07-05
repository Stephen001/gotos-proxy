package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.awesome.turtlenecksandgotos.model.GameHub;

/**
 * Session Bean implementation class DeveloperProxy
 */
@Stateless
public class GameProxy implements GameProxyLocal {

	@EJB
	private HttpFetchClientLocal client;
	
	@EJB
	private GameTextParserLocal parser;
	
    /**
     * Default constructor. 
     */
    public GameProxy() {}
   
    public GameHub proxify(final String developer, final String hubname) {
    	try {
			HttpResponse response = client.fetch(buildURI("http://www.byond.com/games/", new String[] {developer, hubname, "?format=text"}));
			HttpEntity entity = response.getEntity();
			InputStream stream = entity.getContent();
			final GameHub hub = parser.parse(stream);
			EntityUtils.consume(entity);
			return hub;
		} catch (IOException e) {
			return null;
		}
    }
    
    private URI buildURI(final String prefix, final String[] parts) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(prefix);
    	for (String part : parts) {
    		builder.append('/');
    		builder.append(part);
    	}
    	try {
			return new URI(builder.toString());
		} catch (URISyntaxException e) {
			return null;
		}
    }
}
