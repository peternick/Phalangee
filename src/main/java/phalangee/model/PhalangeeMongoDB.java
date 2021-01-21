package phalangee.model;

import java.util.regex.*;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

public class PhalangeeMongoDB {
	
	private static String uri = "mongodb+srv://Peter:slick-rick@cluster0.85azu.mongodb.net/test";;
	private static MongoClientURI clientURI = new MongoClientURI(uri);
	private static MongoClient client = new MongoClient(clientURI);
	
	private static MongoDatabase mgdb = client.getDatabase("PhalangeeDB");
	private static MongoCollection gameInfo = mgdb.getCollection("GameInfo");
	private static MongoCollection userInfo = mgdb.getCollection("UserSignIn");
	
	/*
	 * returns a code to represent the result of a user submitting their user name and password. There are three codes:
	 * 1. -1: the password or username is not valid 
	 * 2.  0: the account has already been created
	 * 3.  1: a new account was created/stored in the database
	 */
	public static int createAccount(String username, String password) {
		
		int usernameCode = verifyUsername(username);
		boolean validPassword = verifyPassword(password);
		
		if(usernameCode == 1 && validPassword) {
			LocalDate currDate = LocalDate.now();
			boolean dateObjPresent = false;
			for(Object d : gameInfo.find()) {
				if(((Document) d).containsValue(currDate)) {
					dateObjPresent = true;
					break;
				}
			}
			
			Document dateIDDoc = new Document("date", currDate);
			Document userInfoDoc = new Document(username, password);
			if(dateObjPresent) {
				dateIDDoc = (Document) gameInfo.find(dateIDDoc).first();
			}
			userInfoDoc.append("gameData", null);
			ArrayList userInfoList = new ArrayList();
			userInfoList.add(userInfoDoc);
			
			dateIDDoc.append("High Score", 0);
			dateIDDoc.append("game_docs", userInfoList);
			gameInfo.insertOne(dateIDDoc);
			
			return 1;
		}else if(usernameCode == 0 && validPassword){
			return 0;
		}else {
			return -1;
		}
		
	}
	
	/*
	 * returns a code to represent the result of a user submitting their user name. There are three codes:
	 * 1. -1: Username is not valid
	 * 2.  0: the user name already exists
	 * 3.  1: the user name is valid and does not exist currently
	 */
	private static int verifyUsername(String username) {
		
		String re = "(\\w)+";
		Pattern pat = Pattern.compile(re);
		Matcher mat = pat.matcher(username);
		if(!(mat.matches())) {
			return -1;
		}
		
		boolean userFound = false;
		for(Object docObj : userInfo.find()) {
			if(((Document) docObj).containsKey(username)) {
				userFound = true;
				return 0;
				
			}
			
		}
//		ArrayList games_arr = new ArrayList();
//		boolean userFound = false;
//		for(Object docObj : gameInfo.find()) {
//			if(((Document) docObj).containsKey("game_docs")) {
//				games_arr = (ArrayList) ((Document) docObj).get("game_docs");
//				
//				for(Object gameObj : games_arr) {
//					Document game = (Document) gameObj;
//					if(game.containsKey(username)) {
//						userFound = true;
//						return 0;
//					}
//				}
//				
//			}
//		}
//		return 1;
	}
	
	
	private static boolean verifyPassword(String psswd) {
		
		String re = "((\\w)*[A-Z]+(\\w)*(\\d)+(\\w)*)||((\\w)*(\\d)+(\\w)*[A-Z]+(\\w)*)";
		Pattern pat = Pattern.compile(re);
		Matcher mat = pat.matcher(psswd);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static int accountLookup(String username, String password) {
		
	}
	
}


