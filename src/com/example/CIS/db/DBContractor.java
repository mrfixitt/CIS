package com.example.CIS.db;

public class DBContractor {

	public static final String DATABASE_NAME = "cis";
	public static final int DATABASE_VERSION_1 = 1;

	public static String create_table_user = "CREATE TABLE IF NOT EXISTS USER(ID  integer primary key autoincrement, UserName text unique, Password text, Email text, IsInstructor integer)";
	
	public static String create_table_course = "CREATE TABLE IF NOT EXISTS COURSE(ID integer primary key autoincrement, CourseName text, InstructorID integer, " +
			"FOREIGN KEY(InstructorID) REFERENCES USER(ID));";
	
	public static String create_table_ppt = "CREATE TABLE IF NOT EXISTS PPT(ID integer primary key autoincrement, SlideID integer, Slide BLOB)";
	
	public static String create_table_course_student = "CREATE TABLE IF NOT EXISTS COU_STU(CourseID integer, StudentID integer, " +
			"FOREIGN KEY(CourseID) REFERENCES COURSE(ID), FOREIGN KEY(StudentID) REFERENCES USER(ID))";
	
	public static String create_table_session = "CREATE TABLE IF NOT EXISTS SESSION(ID integer primary key autoincrement, SessionName text, CourseID integer, Content text, " +
			"FOREIGN KEY(CourseID) REFERENCES COURSE(ID), FOREIGN KEY (PPTID) REFERENCES PPT(ID))";
	
	public static String create_table_feedback = "CREATE TABLE IF NOT EXISTS FEEDBACK(ID integer primary key autoincrement, StudentID integer, SessionID integer, Feedback integer, Comments text, " +
			"FOREIGN KEY(StudentID) REFERENCES USER(ID), FOREIGN KEY(SessionID) REFERENCES SESSION(ID)";
	
}
