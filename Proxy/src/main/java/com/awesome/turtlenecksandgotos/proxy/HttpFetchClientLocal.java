package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.net.URI;

import javax.ejb.Local;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

@Local
public interface HttpFetchClientLocal {
	public HttpResponse fetch(URI uri) throws ClientProtocolException, IOException;
}
