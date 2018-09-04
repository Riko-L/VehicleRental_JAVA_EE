package com.campusnumerique.vehiclerental.registration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.bean.ClientBean;



public final class ConnexionForm {
	private static final String email = "email";
	private static final String password = "password";
	
	private String result;
	private Map<String, String>errors = new HashMap<String, String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public ClientBean connectPerson(HttpServletRequest request) {
		
		/* Récupération des champs du formulaire */
        String mail = getFieldValue(request, email);
        String pwd = getFieldValue(request, password);
        
        ClientBean client = new ClientBean();
	
        /* Validation du email */
        try {
        	validateEmail(mail);
        	
        } catch (Exception ex){
        	setError(email, ex.getMessage());
        }
        client.setEmail(mail);
        
        /* Validation du password */
        try {
        	validatePassword(pwd);
        	
        } catch (Exception ex){
        	setError(pwd, ex.getMessage());
        	
        }
        client.setPassword(pwd);
	    
        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
        	result = "Succès de la connexion";
        } else {
        	result = "Echec de la connexion";
        }
        
        return client;
	}
	
	/**
	 * Valide l'adresse email saisie
	 */
	private void validateEmail(String mail) throws Exception{
		if ( mail != null && !mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception( "Your email isn't valid." );
        }
    }
	
	/**
     * Valide le mot de passe saisi
     */
    private void validatePassword(String pwd) throws Exception {
        if (pwd != null) {
        	if (pwd.length() < 3) {
                throw new Exception( "Password must contain at least 3 characters." );
            }
        } else {
            throw new Exception( "Thanks to type your password." );
        }
    }
	
    /**
    * Ajoute un message correspondant au champ spécifié à la map des erreurs.
    */
   private void setError(String field, String message) {
       errors.put(field, message);
   }
   
   /**
    * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
    * sinon.
    */
   private static String getFieldValue (HttpServletRequest request, String fieldName) {
       String value = request.getParameter(fieldName);
       if (value == null || value.trim().length() == 0 ) {
           return null;
       } else {
           return value;
       }
   }	
}
