package com.example.CIS.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBConnector {
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;

	public DBConnector(Context context){
		dbHelper = new SQLiteHelper(context, DBContractor.DATABASE_NAME, null, DBContractor.DATABASE_VERSION_1);
	}
	
	public void open() throws SQLException {
		// open database in reading/writing mode
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		if (database != null)
			database.close();
	}
	
	//return ID
	public int getID(String userName, boolean isInstructor){
		try{
			open();
			Cursor cur = database.query("USER", new String[]{"ID"}, "UserName = ? and isInstructor = ?", 
					new String[]{userName, isInstructor?"1":"0"}, null, null, null);
			if(cur.moveToFirst()){
				return cur.getInt(0);
			}else{
				return -1;
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	public boolean verifyUserName(String userName, boolean isInstructor){
		boolean ret = false;
		try{
			open();
			Cursor cur = database.query("USER", new String[] {"UserName"},
					"UserName = ? and isInstructor = ?", 
					new String[] {userName, isInstructor?"1":"0"}, null, null, null);
			if(cur.getCount() == 1){
				ret = true;
			}else{
				ret = false;
			}
			return ret;
		}catch (Exception e){
			System.err.println(e.getMessage());
			return false;
		}finally{
			close();
		}
	}
	
	public boolean verifyPassword(String userid, String password, boolean isInstructor){
		return true;
	}
	
	public int addUser(String userName, String password, boolean isInstructor){
		try{
			open();
			ContentValues values = new ContentValues();
			values.put("UserName", userName);
			values.put("Password", password);
			values.put("IsInstructor", isInstructor?"1":"0");
			long ret = database.insert("USER", null, values);
			return (int) ret;
			
		}catch (Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	//return the auto generated courseId
	public int addCourse(int instructorId, String courseName){
		try{
			open();
			ContentValues values = new ContentValues();
			values.put("CoursName", courseName);
			values.put("InstructorId", instructorId);
			long ret = database.insert("COURSE", null, values);
			return (int) ret;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	public int getCourseId(String courseName){
		try{
			open();
			Cursor cur = database.query("COURSE", new String[] {"ID"},
					"CourseName = ?", 
					new String[] {courseName}, null, null, null);
			if(cur.moveToFirst()){
				return cur.getInt(0);
			}else{
				return -1;
			}
		}catch (Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	//return the auto generated sessionId
	public int addSession(String instructorId, String courseName, String sessionName, String content){
		try{
			open();
			ContentValues values = new ContentValues();
			values.put("CoursName", courseName);
			values.put("InstructorId", instructorId);
			values.put("Content", content);
			long ret = database.insert("SESSION", null, values);
			return (int) ret;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	public int getSessionId(String courseName, String SessionName){
		try{
			open();
			Cursor cur = database.query("SESSION", new String[] {"ID"},
					"CourseName = ? and SessionName = ?", 
					new String[] {courseName, SessionName}, null, null, null);
			if(cur.moveToFirst()){
				return cur.getInt(0);
			}else{
				return -1;
			}
		}catch (Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	//return the ppt ID
	public int uploadPPT(int sessionId, int pptId, byte[] PPT){
		try{
			open();
			ContentValues values = new ContentValues();
			values.put("SessionID", sessionId);
			values.put("PPTID", pptId);
			values.put("PPT", PPT);
			long ret = database.update("SESSION", values, 
					"SessionID = ? AND PPTID = ?", 
					new String[]{String.valueOf(sessionId), String.valueOf(pptId)});
			return (int) ret;
			
		}catch (Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	public int addPPTSlides(int PPTID, byte[] PPT){
		//convert PPT to pictures
		return -1;
	}
	
	//return the feedback ID
	public int addFeedback(int sessionId, int studentId, int feedback, String comments){
		try{
			open();
			ContentValues values = new ContentValues();
			values.put("SessionID", sessionId);
			values.put("StrudentID", studentId);
			values.put("Feedback", feedback);
			if(comments != null && comments.length() != 0){
				values.put("Comment", comments);
			}
			long ret = database.insert("FEEDBACK", null, values);
			return (int) ret;
			
		}catch (Exception e){
			System.err.println(e.getMessage());
			return -1;
		}finally{
			close();
		}
	}
	
	//[[studentId, feedback]]
	public ArrayList<ArrayList<Integer>> getFeedbacks(int sessionId){
		try{
			open();
			Cursor cur = database.query("FEEDBACK", new String[] {"StudentID", "Feedback"},
					"SessionID = ?", 
					new String[] {String.valueOf(sessionId)}, null, null, null);
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
			while(cur.moveToNext()){
				ArrayList<Integer> sub = new ArrayList<Integer>();
				sub.add(cur.getInt(0));
				sub.add(cur.getInt(1));
				ret.add(sub);
			}
			return ret;
		}catch (Exception e){
			System.err.println(e.getMessage());
			return null;
		}finally{
			close();
		}
	}
}
