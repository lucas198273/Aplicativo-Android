package devandroid.lucasdias.appglstudio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.lucasdias.appglstudio.R;
import devandroid.lucasdias.appglstudio.controller.MainController;

public class MainActivity extends AppCompatActivity {

    EditText edit_nome_user;
    EditText edit_senha_user;
    Button btLogin;

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
                String nomeCadastrado = "lucas";
                if (edit_nome_user.getText().toString().trim().equalsIgnoreCase(nomeCadastrado)) {
                    // Lógica para login bem-sucedido
                    Intent intent = new Intent(MainActivity.this, AgendamentoActivity.class);
                    startActivity(intent);
                } else {
                    // Feedback ao usuário quando o nome do usuário não corresponde
                    Toast.makeText(MainActivity.this, "Nome de usuário incorreto", Toast.LENGTH_LONG).show();
                }
            } else {
                // Toast para campos vazios (talvez seja útil apenas no desenvolvimento)
                Toast.makeText(MainActivity.this, MainController.menssagemErroCampoVazio(), Toast.LENGTH_LONG).show();
            }



        });
    }
}
