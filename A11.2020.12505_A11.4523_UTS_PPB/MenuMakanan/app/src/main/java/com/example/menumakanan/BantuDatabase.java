package com.example.menumakanan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BantuDatabase extends SQLiteOpenHelper {

    private static final String DB_MAKANAN = "db_makanan";
    private static final String TABEL_MAKANAN ="tabel_makanan";
    private static final String KODE = "kode";
    private static final String NM_MAKANAN = "nm_makanan";
    private SQLiteDatabase db;

    public BantuDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DB_MAKANAN, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String nama_tabel="create table "+TABEL_MAKANAN+ "(" + KODE + " integer primary key autoincrement," + NM_MAKANAN + " text)";
        db.execSQL(nama_tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVesion, int newVersion) {
    }
    public boolean tambahData(String namamakanan)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NM_MAKANAN,namamakanan);

        long hasil=db.insert(TABEL_MAKANAN,null,contentValues);
        return hasil != -1;

    }
        public void tampilanmenu()
        {
            SQLiteDatabase db=this.getWritableDatabase();
            String sql="select * from "+TABEL_MAKANAN;
            Cursor cursor=db.rawQuery(sql,null);
        }

    public Cursor tampilmenu() {
    }
}

