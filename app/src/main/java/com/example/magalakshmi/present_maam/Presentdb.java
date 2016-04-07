package com.example.magalakshmi.present_maam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MAGA LAKSHMI on 4/6/2016.
 */

    public class Presentdb extends SQLiteOpenHelper {

        public Presentdb(Context context) {
            super(context, "student", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table student(username text,password text)");
            db.execSQL("insert into student values('student1','st1')");
            //db.execSQL("insert into student values('student2','st2')");
            //db.execSQL("insert into student values('student3','st3')");
            //db.execSQL("insert into student values('student4','st4')");
            //db.execSQL("insert into student values('student5','st5')");
            db.execSQL("insert into student values('staff1','sf1')");
           // db.execSQL("insert into student values('staff2','sf2')");
           // db.execSQL("insert into student values('staff3','sf3')");
            db.execSQL("create table loc(lattitude double, longitude double)");
            db.execSQL("create table attendance(student_id text,checkin number,checkout number,attper number,lattitude number,altitude number)");
            db.execSQL("insert into attendance values('student1','','','','','')");
            //db.execSQL("insert into attendance values('student2','','','','','')");
            //db.execSQL("insert into attendance values('student3','','','','','')");
            //db.execSQL("insert into attendance values('student4','','','','','')");
            //db.execSQL("insert into attendance values('student5','','','','','')");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists student");
        }

        public Cursor Retrive(String st) {
            SQLiteDatabase db = getWritableDatabase();
            Cursor rs = db.rawQuery("select * from student where username ='" + st + "'", null);
            return rs;
        }

        public void Store(String id1, int chin1, int chout1, int attper2) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("insert into attendance values('" + id1 + "','" + chin1 + "','" + chout1 + "','" + attper2 + "')", null);
        }

        public void Store1(String lat, String lon) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("insert into loc values('" + lat + "','" + lon + "')", null);
        }
   /* public Cursor Retrive2(String pname)
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor rs1=db.rawQuery("select * from student where pn='"+pname+"'",null);
        return rs1;
    }*/
    }

