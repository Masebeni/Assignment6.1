package com.mobileBanking.respository.client.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mobileBanking.domain.client.ClientContact;
import com.mobileBanking.respository.client.ClientContactRepository;

import java.util.HashSet;
import java.util.Set;

import com.mobileBanking.config.database.DBConstants;

/**
 * Created by Isiphile on 2016-04-20.
 */
public abstract class ClientContactRepositoryImpl extends SQLiteOpenHelper implements ClientContactRepository {
    public static final String TABLE_NAME = "pcontacts";
    private SQLiteDatabase db;


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CELLNUMBER = "contactTypeId";
    public static final String COLUMN_EMAIL = "contactValue";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STATE = "state";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CELLNUMBER + " TEXT UNIQUE NOT NULL , "
            + COLUMN_EMAIL + " TEXT  NOT NULL , "
            + COLUMN_STATUS + " TEXT  NOT NULL , "
            + COLUMN_DATE + " TEXT  NOT NULL , "
            + COLUMN_STATE + " TEXT NOT NULL );";


    public ClientContactRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public ClientContact findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CELLNUMBER,
                        COLUMN_EMAIL,
                        COLUMN_STATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final ClientContact clientContact = new ClientContact.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .cellNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CELLNUMBER)))
                    .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                    .build();

            return clientContact;
        } else {
            return null;
        }
    }

    @Override
    public ClientContact save(ClientContact entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CELLNUMBER, entity.getCellNumber());
        values.put(COLUMN_EMAIL, entity.getEmail());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ClientContact insertedEntity = new ClientContact.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public ClientContact update(ClientContact entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CELLNUMBER, entity.getCellNumber());
        values.put(COLUMN_EMAIL, entity.getEmail());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public ClientContact delete(ClientContact entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<ClientContact> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ClientContact> personAddresses = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ClientContact personAddress = new ClientContact.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .cellNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CELLNUMBER)))
                        .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                        .build();
                personAddresses.add(personAddress);
            } while (cursor.moveToNext());
        }
        return personAddresses;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
