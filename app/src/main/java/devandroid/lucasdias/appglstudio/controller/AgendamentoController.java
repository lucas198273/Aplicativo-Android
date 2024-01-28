package devandroid.lucasdias.appglstudio.controller;

import android.content.SharedPreferences;

import devandroid.lucasdias.appglstudio.model.AgendamentoConfirmado;
import devandroid.lucasdias.appglstudio.view.AgendamentoActivity;

public class AgendamentoController {
    public static final String DS_USUARIOS = "pref_listauser";
    SharedPreferences preferences;
    SharedPreferences.Editor listCadastroUsuarios;


    public AgendamentoController(AgendamentoActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(DS_USUARIOS, 0);
        listCadastroUsuarios = preferences.edit();
    }


    public void salvar(AgendamentoConfirmado agendamentoUsuario) {
        listCadastroUsuarios.putString("NomeCompleto", agendamentoUsuario.getNomeDoUsuario());
        listCadastroUsuarios.putString("Telefone", agendamentoUsuario.getTelefoneContato());
        listCadastroUsuarios.putString("TipoServico", agendamentoUsuario.getTipoServico());
        listCadastroUsuarios.apply(); // Salva os dados no SharedPreferences
    }
    public AgendamentoConfirmado buscar(AgendamentoConfirmado agendamento){
        agendamento.setNomeCompleto(preferences.getString("NomeCompleto","NA"));
        agendamento.setTelefoneContato(preferences.getString("Telefone","NA"));
        agendamento.setTipoServico(preferences.getString("TipoServico","NA"));
        return agendamento;
    }

    public void limpar() {
        listCadastroUsuarios.clear();
        listCadastroUsuarios.apply();
    }
}
