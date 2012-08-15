package com.awesome.turtlenecksandgotos.proxy.pages;

import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.awesome.turtlenecksandgotos.model.DeveloperHub;
import com.awesome.turtlenecksandgotos.proxy.DeveloperProxyLocal;

@ManagedBean(name="libraryProxy")
@RequestScoped
public final class LibraryDisplayBean {
	@EJB
	private DeveloperProxyLocal proxy;
	
	private DeveloperHub hub;
	
	public DeveloperHub getHub() {
		if (hub == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, String> path = context.getExternalContext().getRequestParameterMap();
			hub = proxy.proxify(path.get("developer"), path.get("hub"));
		}
		return hub;
	}
}
