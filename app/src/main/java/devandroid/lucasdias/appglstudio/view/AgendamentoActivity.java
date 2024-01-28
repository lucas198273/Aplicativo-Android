package devandroid.lucasdias.appglstudio.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.lucasdias.appglstudio.R;
import devandroid.lucasdias.appglstudio.controller.AgendamentoController;
import devandroid.lucasdias.appglstudio.controller.TipoServicoController;
import devandroid.lucasdias.appglstudio.model.AgendamentoConfirmado;

public class AgendamentoActivity extends AppCompatActivity {

    AgendamentoController controller;
    TipoServicoController tipoServicoController;
    List<String> listaNomesServicos;

    EditText nomeCompleto;
    EditText telefone;
    EditText tipoServico;
    Button btFinalizar;
    Button btLimpar;
    AgendamentoConfirmado agendamentoUsuario;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento_user);

        // Inicializa os controladores antes de utilizá-los
        controller = new AgendamentoController(AgendamentoActivity.this);
        tipoServicoController = new TipoServicoController();

        agendamentoUsuario = new AgendamentoConfirmado();
        agendamentoUsuario = controller.buscar(agendamentoUsuario);

        // Agora que os controladores estão inicializados, podemos usar seus métodos
        listaNomesServicos = tipoServicoController.dadosParaOSpinner();

        nomeCompleto = findViewById(R.id.edit_nome_completo);
        telefone = findViewById(R.id.edit_telefone);
        tipoServico = findViewById(R.id.edit_tipoServico);
        btFinalizar = findViewById(R.id.btLogin);
        btLimpar = findViewById(R.id.btLimpar);
        spinner = findViewById(R.id.btSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNomesServicos);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        nomeCompleto.setText(agendamentoUsuario.getNomeDoUsuario());
        telefone.setText(agendamentoUsuario.getTelefoneContato());
        tipoServico.setText(agendamentoUsuario.getTipoServico());

        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                agendamentoUsuario.setNomeCompleto(nomeCompleto.getText().toString());
                agendamentoUsuario.setTelefoneContato(telefone.getText().toString());
                agendamentoUsuario.setTipoServico(tipoServico.getText().toString());

                Toast.makeText(AgendamentoActivity.this, "Cadastro realizado " + agendamentoUsuario.getNomeDoUsuario(), Toast.LENGTH_LONG).show();
                controller.salvar(agendamentoUsuario);
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeCompleto.setText("");
                telefone.setText("");
                tipoServico.setText(""); // Corrigido: limpando o campo tipoServico
                controller.limpar();
            }
        });
    }
}
