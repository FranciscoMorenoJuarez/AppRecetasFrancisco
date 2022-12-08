package com.example.apprecetas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;



public class DeveloperBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developer.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_PEDIDOS="CREATE TABLE PEDIDOS(COSTO INT PRIMARY KEY)";

    public DeveloperBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_PEDIDOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(TABLA_PEDIDOS);
    }

    public void agregarCursos(double costo){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd != null){
            bd.execSQL("INSERT INTO PEDIDOS VALUES('"+costo+"')");
            bd.close();
        }
    }

   /* public List<> mostrarPedidos() {
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM PEDIDOS", null);
        List<> cursos=new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursor.add(new CursosModelo(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        return cursos;
    } */

}
