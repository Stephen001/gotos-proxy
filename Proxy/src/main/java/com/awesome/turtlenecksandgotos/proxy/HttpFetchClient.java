package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.net.URI;

import javax.ejb.Stateless;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Session Bean implementation class HttpClient
 */
@Stateless
public class HttpFetchClient implements HttpFetchClientLocal {

    /**
     * Default constructor. 
     */
    public HttpFetchClient() {}
    
    /* (non-Javadoc)
     * @see com.awesome.turtlenecksandgotos.proxy.HttpFetchClientLocal#fetch(java.net.URI)
     */
    @Override
    public HttpResponse fetch(URI uri) throws ClientProtocolException, IOException {
    	final HttpClient client = new DefaultHttpClient();
    	HttpGet get = new HttpGet(uri);
    	return client.execute(get);
    }

}
