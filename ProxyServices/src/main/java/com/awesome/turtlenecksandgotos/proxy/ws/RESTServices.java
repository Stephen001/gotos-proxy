package com.awesome.turtlenecksandgotos.proxy.ws;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/rest")
public class RESTServices extends PackagesResourceConfig {
	public RESTServices() {
		super("com.awesome.turtlenecksandgotos.proxy.ws");
	}
}
