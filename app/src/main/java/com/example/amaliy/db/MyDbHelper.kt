package com.example.amaliy.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.amaliy.models.User

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, VERSION),
    MyDbInterface {
    companion object {
        const val DB_NAME = "user_db"
        const val VERSION = 1
        const val USER_NAME = "image_user"
        const val ID = "id"
        const val NAME = "name"
        const val AGE = "age"
        const val ZAXIRA = "zaxira"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table ${USER_NAME}($ID integer not null primary key autoincrement,$NAME text not null,$AGE integer not null,$ZAXIRA integer not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, user.name)
        contentValues.put(AGE, user.age)
        contentValues.put(ZAXIRA, user.zaxirami)
        database.insert(USER_NAME, null, contentValues)
        database.close()
    }

    override fun getAllUser(): List<User> {
        val list = ArrayList<User>()
        val database = this.readableDatabase
        val query = "select * from $USER_NAME"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                list.add(
                    User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3)
                    )
                )
            } while (cursor.moveToNext())
        }
        return list
    }
}
