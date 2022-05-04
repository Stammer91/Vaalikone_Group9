package app;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.vastauksetMTM;

@WebServlet(urlPatterns = {"/addVastaus", "/deleteVastaus/{id}","/updateVastaus","/readVastaus","/readtoupdateVastaus/{id}", "/readallVastaus"})
public class HandleVastaukset extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<vastauksetMTM> list=null;
	  switch (action) {
	  case "/addVastaus":
		  list=addVastaus(request);break;
	  case "/deleteVastaus":
		  String id=request.getParameter("id");
		  list=deleteVastaus(request);break;
	  case "/updateVastaus":
		  list=updateVastaus(request);break;
	  case "/readfish":
		  list=readVastaus(request);break;
	  case "/readtoupdateVastaus":
		  vastauksetMTM f=readtoupdateVastaus(request);
		  request.setAttribute("Vastaus", f);
		  // ???
		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/fishtoupdateform.jsp");
		  rd.forward(request, response);
		  return;
	  }
	  request.setAttribute("VastausLista", list);
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/Vastausform.jsp");
	  rd.forward(request, response);
  }

	private vastauksetMTM readtoupdateVastaus(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/VaalikoneService/readtoupdateVastaus/"+id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		vastauksetMTM vastaus=b.get(vastauksetMTM.class);
		return vastaus;
	}

	private List<vastauksetMTM> addVastaus(HttpServletRequest request) {
		//A Fish object to send to our web-service 
		vastauksetMTM f=new vastauksetMTM(request.getParameter("vastausSTR"));
		System.out.println(f);
		String uri = "http://127.0.0.1:8080/rest/VaalikoneService/addVastaus";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Fish object as JSON string format
		Entity<vastauksetMTM> e=Entity.entity(f,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<vastauksetMTM>> genericList = new GenericType<List<vastauksetMTM>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<vastauksetMTM> returnedList=b.post(e, genericList);
		return returnedList;
	}
	
	private List<vastauksetMTM> readVastaus(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/VaalikoneService/readVastaus";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<vastauksetMTM>> genericList = new GenericType<List<vastauksetMTM>>() {};
		
		List<vastauksetMTM> returnedList=b.get(genericList);
		return returnedList;
	}
	
	private List<vastauksetMTM> updateVastaus(HttpServletRequest request) {
		//A Fish object to send to our web-service 
		vastauksetMTM f=new vastauksetMTM(request.getParameter("id"), request.getParameter("vastausSTR"));
		System.out.println(f);
		String uri = "http://127.0.0.1:8080/rest/VaalikoneService/updateVastaus";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Fish object as JSON string format
		Entity<vastauksetMTM> e=Entity.entity(f,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<vastauksetMTM>> genericList = new GenericType<List<vastauksetMTM>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<vastauksetMTM> returnedList=b.put(e, genericList);
		return returnedList;
	}
	
	private List<vastauksetMTM> deleteVastaus(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/VaalikoneService/deleteVastaus/"+id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<vastauksetMTM>> genericList = new GenericType<List<vastauksetMTM>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<vastauksetMTM> returnedList=b.delete(genericList);
		return returnedList;
	}
}