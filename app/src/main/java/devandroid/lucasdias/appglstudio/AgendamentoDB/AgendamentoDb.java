package devandroid.lucasdias.appglstudio.AgendamentoDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import devandroid.lucasdias.appglstudio.model.AgendamentoConfirmado;


public class AgendamentoDb extends SQLiteOpenHelper {

    public static final String DB_usuariosAgendados = "usuariosAgendados.db";
    public static final int DB_VERSAO = 1;
    SQLiteDatabase db;

    public AgendamentoDb(Context context) {
        super(context, DB_usuariosAgendados, null, DB_VERSAO);
        db = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Defina a tabela SQL
        String tabelaSqlAgendamento = "CREATE TABLE usuariosAgendados (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCompleto TEXT, " +
                "telefoneContato TEXT, " +
                "tipoServico TEXT)";

        // Execute a query para criar a tabela
        db.execSQL(tabelaSqlAgendamento);
    }@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se precisar realizar alguma atualização do esquema do banco de dados, faça aqui
        // Este método é chamado quando a versão do banco de dados é atualizada
    }

    // Método para inserir um AgendamentoConfirmado no banco de dados
    public long inserirAgendamento(AgendamentoConfirmado agendamento) {
        ContentValues values = new ContentValues();
        values.put("nomeCompleto", agendamento.getNomeDoUsuario());
        values.put("telefoneContato", agendamento.getTelefoneContato());
        values.put("tipoServico", agendamento.getTipoServico());

        // Insira o registro no banco de dados
        return db.insert("usuariosAgendados", null, values);
    }
}
