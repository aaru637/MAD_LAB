package com.dk.mad_lab.fourth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(Context context){
        super(context, "STUDENT.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS STUDENT(REGISTER_NO TEXT PRIMARY KEY, NAME TEXT, MOBILE TEXT, DEPARTMENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
    }

    SQLiteDatabase db = this.getWritableDatabase();

    public boolean add(User user){
        boolean result = false;
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put("REGISTER_NO", user.RegisterNo);
            contentValues.put("NAME", user.Name);
            contentValues.put("MOBILE", user.Mobile);
            contentValues.put("DEPARTMENT", user.Department);
           return (db.insert("STUDENT", null, contentValues)) != -1;}
        catch (Exception e){
            System.out.println(e.toString());
            return result;}
    }

    public User read(String RegisterNo, Context context){
        Cursor cursor;
        int count = 0;
        try{cursor = db.rawQuery("SELECT * FROM STUDENT WHERE REGISTER_NO = ?" , new String[]{String.valueOf(RegisterNo)});
            while (cursor.moveToNext()){User user = new User(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                count++;
                return user;}
            if(count == 0){
                Toast.makeText(context, "No Data Found", Toast.LENGTH_LONG).show();
                return new User();}}
        catch (Exception e){
            System.out.println(e.toString());}
        return new User();
    }

    public ArrayList<User> readall(){
        Cursor cursor;
        ArrayList<User> user = new ArrayList<>();
        try{cursor = db.rawQuery("SELECT * FROM STUDENT",null);
            while (cursor.moveToNext()){
                user.add(new User(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3)));}return user;}
        catch (Exception e){
            System.out.println(e.toString());}
        return user;
    }

    public boolean update(User user){
        boolean result = false;
        try{ContentValues contentValues = new ContentValues();
            contentValues.put("REGISTER_NO", user.RegisterNo);
            contentValues.put("NAME", user.Name);
            contentValues.put("MOBILE", user.Mobile);
            contentValues.put("DEPARTMENT", user.Department);
            return (db.update("STUDENT", contentValues, "REGISTER_NO = ?", new String[]{user.RegisterNo})) != -1;}
        catch (Exception e){
            System.out.println(e.toString());
            return result;}
    }

    public boolean delete(String RegisterNo){
        boolean result = false;
        try{return (db.delete("STUDENT", "REGISTER_NO = ?", new String[]{RegisterNo})) != -1;}
        catch (Exception e){
            System.out.println(e.toString());
            return result;}
    }
}
