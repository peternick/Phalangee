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

			
			Document userInfoDoc = new Document(username, password);
			userInfo.insertOne(userInfoDoc);
			
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
		return 1;
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
	
	
	public static boolean userLogin(String username, String password) {
		
		Document foundUserInfoDoc = (Document) userInfo.find(new Document(username, password)).first();
		if(foundUserInfoDoc.get(username).equals(password)){
			return true;
		}else {
			return false;
		}
	}
	
	public static void recordEndGameData(String user, int wpm, String gameMode, int mistypedWords) {
		String currDate = LocalDate.now().toString();
		boolean dateObjPresent = false;
		Document foundDateDoc = null;
		for(Object d : gameInfo.find()) {
			if(((Document) d).containsValue(currDate)) {
				
				dateObjPresent = true;
				foundDateDoc = (Document) d;
				break;
			}
		}
		
		if(dateObjPresent) {
			if(wpm > foundDateDoc.getInteger("High Score")) {
				System.out.println("new high score");
				Bson updateHighScore = new Document("High Score", wpm);
				Bson updateHighScoreOper = new Document("$set", updateHighScore);
				gameInfo.updateOne(foundDateDoc, updateHighScoreOper);
			}else {
				ArrayList userDocList = (ArrayList) foundDateDoc.get("GameData");
				System.out.println("edit existing");
				int arrIndex = 0;
				for(Object gameInfoDoc : userDocList) {
					if(((Document)gameInfoDoc).containsKey(user)){
						Document gameStatsDoc = new Document("GameID", gameMode);
						gameStatsDoc.append("WPM", wpm);
						gameStatsDoc.append("Mistyped", mistypedWords);
						
						Bson updateTo = new Document("GameData." + arrIndex + "." + user, gameStatsDoc);
						Bson upadateOp = new Document("$push", updateTo);
						gameInfo.updateOne(foundDateDoc, upadateOp);
					}
					arrIndex++;
				}
			}
		}else {
			Document newDoc = new Document("Date", currDate);
			ArrayList gameDocObjsList = new ArrayList();
			ArrayList userGameInfoList = new ArrayList();
			
			Document gameInfoDoc = new Document("GameID", gameMode);
			gameInfoDoc.append("WPM", wpm);
			gameInfoDoc.append("Mistyped", mistypedWords);
			userGameInfoList.add(gameInfoDoc);
			
			Document userGameInfoDoc = new Document(user, userGameInfoList);
			userGameInfoDoc.append("Highest WPM", wpm);
			
			gameDocObjsList.add(userGameInfoDoc);
			
			newDoc.append("High Score", wpm);
			newDoc.append("GameData", gameDocObjsList);
			
			gameInfo.insertOne(newDoc);
		}
	}
	
}


