package devandroid.lucasdias.appglstudio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.lucasdias.appglstudio.AgendamentoDB.AgendamentoDb;
import devandroid.lucasdias.appglstudio.R;
import devandroid.lucasdias.appglstudio.model.AgendamentoConfirmado;

public class SplashActivity extends AppCompatActivity {

    public static final  int TIME_OUT_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        comutarTelaSplash();
    }


    private   void  comutarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AgendamentoConfirmado novoAgendamento = new AgendamentoConfirmado("João Lobato", "123456789", "Corte de Cabelo");

                AgendamentoDb db = new AgendamentoDb(SplashActivity.this);
                long resultado = db.inserirAgendamento(novoAgendamento);

// Verificar o resultado, por exemplo, se resultado é maior que -1, a inserção foi bem-sucedida.


                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        },TIME_OUT_SPLASH);
    }
}