package devandroid.lucasdias.appglstudio.AgendamentoDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AgendamentoDb extends SQLiteOpenHelper {

    public static final String DB_users = "usuarios.db";
    public static final int DB_VERSAO = 1;

    Cursor cursor;
    SQLiteDatabase db;


    public  AgendamentoDb(Context context){
        super(context,DB_users,null, DB_VERSAO);
        db = getWritableDatabase();
    }
/*    public AgendamentoDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelaSqlUsers = "CREATE USUARIO ( ) ";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
