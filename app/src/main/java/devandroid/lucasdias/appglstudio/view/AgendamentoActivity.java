package devandroid.lucasdias.appglstudio.view;

import android.os.Bundle;
import android.util.Log;
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
/*    Bundle bundle = getIntent().getExtras();*/
    String nomeUsuario;

    // Verificando se o Bundle não é nulo e contém dados específicos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento_user);

   /*     Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Log.d("bundle nao nulo", "bundle nao nulo");

            // Exemplo: Verificando se a chave é a correta ("nome")
            if (bundle.containsKey("nome")) {
                nomeUsuario = bundle.getString("nome");
                nomeCompleto.setText(nomeUsuario);

                Toast.makeText(AgendamentoActivity.this, "Cadastro realizado, bem-vindo " + nomeUsuario, Toast.LENGTH_LONG).show();
            }
        }*/

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

                Toast.makeText(AgendamentoActivity.this, "Agendamento Confirmado " + agendamentoUsuario.getNomeDoUsuario(), Toast.LENGTH_LONG).show();
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
