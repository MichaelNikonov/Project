package server.controllers;

public class RequestController {

	public enum REQUESTS {
		LOGIN_USER, LOGOUT_USER,
		GET_ALL_IMAGES, GET_IMAGES_BY_SEARCH, GET_IMAGE_BY_ID,
		GET_ALL_LAYERS, GET_LAYER_BY_ID, GET_LAYERS_BY_IMAGE_ID,
		GET_CLIENT_BY_USERNAME, GET_EMPLOYEE_BY_USERNAME,
		GET_CLIENTS, GET_EMPLOYEES, GET_CLIENT_BY_ID,
		GET_ALL_COMPLAINTS, GET_COMPLAINT_BY_ID, GET_ALL_UNADDRESSED_COMPLAINTS
	}
	
	
}
