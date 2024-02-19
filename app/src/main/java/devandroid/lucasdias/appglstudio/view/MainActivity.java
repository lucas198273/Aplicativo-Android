package devandroid.lucasdias.appglstudio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.lucasdias.appglstudio.R;
import devandroid.lucasdias.appglstudio.controller.MainController;
import devandroid.lucasdias.appglstudio.model.Usuario;

public class MainActivity extends AppCompatActivity {

    Usuario usuario ;
    EditText edit_nome_user;
    EditText edit_senha_user;
    Button btLogin;
  /*  Bundle bundle;*/

    String senhaCadastrada = "lucas";
     /*Toast.makeText(AgendamentoActivity.this, "Cadastro realizado " + agendamentoUsuario.getNomeDoUsuario(), Toast.LENGTH_LONG).show();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nome_user = findViewById(R.id.edit_nome_user);
        edit_senha_user = findViewById(R.id.edit_senha_user);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(v -> {

            boolean isCampoOk = true;

            if (TextUtils.isEmpty(edit_nome_user.getText())) {
                edit_nome_user.setError(MainController.menssagemErroCampoVazio());
                isCampoOk = false;
                edit_nome_user.requestFocus();
            }

            if (TextUtils.isEmpty(edit_senha_user.getText())) {
                edit_senha_user.setError(MainController.menssagemErroCampoVazio());
                isCampoOk = false;
                edit_senha_user.requestFocus();
            }

            if (isCampoOk) {

                if (edit_senha_user.getText().toString().trim().equalsIgnoreCase(senhaCadastrada)) {
                    // Lógica para login bem-sucedida
                    String nome =  edit_nome_user.getText().toString();
                    String senha = edit_senha_user.getText().toString();
                    usuario = instanciarUsuario(nome,senha);
                    Intent intent = new Intent(MainActivity.this, AgendamentoActivity.class);
                  /*  bundle = new Bundle();
                    bundle.putString("nome",usuario.getNomeUsuario());

                    intent.putExtras(bundle);*/
                    startActivity(intent);
                } else {
                    // Feedback ao usuário quando a senha não corresponde

                    Toast.makeText(MainActivity.this, "Senha incorreta", Toast.LENGTH_LONG).show();
                }

            } else {
                // Toast para campos vazios (talvez seja útil apenas no desenvolvimento)
                Toast.makeText(MainActivity.this, MainController.menssagemErroCampoVazio(), Toast.LENGTH_LONG).show();
            }



        });
    }
    private Usuario instanciarUsuario(String nome,String senha ){

        return this.usuario = new Usuario(nome,senha);
    }
}
