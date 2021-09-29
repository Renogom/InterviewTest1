package com.m.edutabtest.Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.m.edutabtest.models.Data;
import com.m.edutabtest.models.DataOffliner;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private final static String DB_NAME = "test1.db";
    private final static int DB_VER = 3;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    public List<DataOffliner> getCart() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"dataID", "dataTrips", "airlineID", "airlineName", "airlineContry", "airlineLogo", "airlineSlogon", "airlineHeadquarters", "airlineWebsite", "airlineEst", "dataName"};
        String sqlTable = "Passenger";
        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        final List<DataOffliner> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                result.add(new DataOffliner(c.getString(c.getColumnIndex("dataID")),
                        c.getString(c.getColumnIndex("dataTrips")),
                        c.getString(c.getColumnIndex("airlineID")),
                        c.getString(c.getColumnIndex("airlineName")),
                        c.getString(c.getColumnIndex("airlineContry")),
                        c.getString(c.getColumnIndex("airlineLogo")),
                        c.getString(c.getColumnIndex("airlineSlogon")),
                        c.getString(c.getColumnIndex("airlineHeadquarters")),
                        c.getString(c.getColumnIndex("airlineWebsite")),
                        c.getString(c.getColumnIndex("airlineEst")),
                        c.getString(c.getColumnIndex("dataName"))

                ));
            } while (c.moveToNext());
        }
        return result;
    }

    public void addToCart(List<Data> dataArrayList) {
        SQLiteDatabase db = getWritableDatabase();

        for (int i = 0; i < dataArrayList.size(); i++) {
            String query = String.format("INSERT OR REPLACE INTO Passenger(dataID,dataTrips,airlineID,airlineName,airlineContry,airlineLogo,airlineSlogon,airlineHeadquarters,airlineWebsite,airlineEst,dataName) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",
                    dataArrayList.get(i).get_id(),
                    dataArrayList.get(i).getTrips() + "",
                    dataArrayList.get(i).getAirline().get(0).getName(),
                    dataArrayList.get(i).getAirline().get(0).getCountry(),
                    dataArrayList.get(i).getAirline().get(0).getLogo(),
                    dataArrayList.get(i).getAirline().get(0).getSlogan(),
                    dataArrayList.get(i).getAirline().get(0).getHead_quaters(),
                    dataArrayList.get(i).getAirline().get(0).getWebsite(),
                    dataArrayList.get(i).getAirline().get(0).getEstablished(),
                    "1",
                    dataArrayList.get(i).getName());
            db.execSQL(query);

//            dataArrayList.get(i).get_id(),
//                    dataArrayList.get(i).getTrips()+"",
//                    dataArrayList.get(i).getAirline().get(i).getId()+"",
//                    dataArrayList.get(i).getAirline().get(i).getName(),
//                    dataArrayList.get(i).getAirline().get(i).getCountry(),
//                    dataArrayList.get(i).getAirline().get(i).getLogo(),
//                    dataArrayList.get(i).getAirline().get(i).getSlogan(),
//                    dataArrayList.get(i).getAirline().get(i).getHead_quaters(),
//                    dataArrayList.get(i).getAirline().get(i).getWebsite(),
//                    dataArrayList.get(i).getAirline().get(i).getEstablished(),
//                    dataArrayList.get(i).getName());

        }

    }


    public int getCountCart() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT COUNT(*) FROM Passenger");
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                count = cursor.getInt(0);

            } while (cursor.moveToNext());
        }
        return count;
    }


}
