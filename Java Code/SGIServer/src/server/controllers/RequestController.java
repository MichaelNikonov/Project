package server.controllers;

public class RequestController {

	public enum REQUESTS {
		LOGIN_USER, LOGOUT_USER,
		GET_ALL_CLIENTS, GET_CLIENT_BY_ID, GET_CLIENT_BY_USERNAME,
<<<<<<< HEAD
		GET_ALL_EMPLOYESS, GET_EMPLOYEE_BY_ID, GET_EMPLOYEE_BY_USERNAME,
		GET_ALL_COMPLAINTS, GET_UNSEEN_COMPLAINTS, GET_UNADDRESSED_COMPLAINTS,ADD_NEW_COMPLAINT,
		GET_ALL_SUBSCRIPTION, GET_SUBSCRIPTION_BY_ID,
=======
		ADD_CLIENT, UPDATE_CLIENT, REMOVE_CLIENT,
		GET_EMPLOYEE_BY_USERNAME,
		GET_ALL_COMPLAINTS, GET_UNSEEN_COMPLAINTS, GET_UNADDRESSED_COMPLAINTS,
		ADD_COMPLAINT, UPDATE_COMPLAINT,
		GET_ALL_SUBSCRIPTIONS, GET_SUBSCRIPTION_BY_ID, GET_ACTIVATED_SUBSCRIPTIONS, 
		ADD_SUBSCRIPTION, ACTIVATE_SUBSCRIPTION, DEACTIVATE_SUBSCRIPTION,
>>>>>>> origin/Server-branch
		GET_ALL_IMAGES, GET_IMAGES_BY_TITLE, GET_IMAGE_BY_ID,
		ADD_IMAGE, UPDATE_IMAGE,
		GET_ALL_LAYERS, GET_LAYER_BY_ID, GET_LAYERS_BY_IMAGEID,
		ADD_LAYER, REMOVE_LAYER,
		PURCHASE_IMAGE, DOWNLOAD_LAYER, PURCHASE_SUBSCRIPTION,
		GET_PRICES, SUGGEST_PRICES, APPROVE_PRICES, ACTIVATE_PRICES
	}
	
	
}
