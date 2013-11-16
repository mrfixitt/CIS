package com.example.CIS.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{

	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DBContractor.create_table_user);
		db.execSQL(DBContractor.create_table_ppt);
		db.execSQL(DBContractor.create_table_course);
		db.execSQL(DBContractor.create_table_course_student);
		db.execSQL(DBContractor.create_table_session);
		db.execSQL(DBContractor.create_table_feedback);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
