package foo.maddo.cursoandroidaula10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import foo.maddo.cursoandroidaula10.dao.LoginDAO;
import foo.maddo.cursoandroidaula10.datamodel.DataModel;
import foo.maddo.cursoandroidaula10.model.Login;


public class MainActivity extends ActionBarActivity

        implements View.OnClickListener {

    // Criação dos objetos
    EditText editLogin;
    EditText editSenha;

    Button btnAcessar;

    Button btnSalvar; // Botão Salvar


    // Variável para validar os dados
    // do formulário
    Boolean camposValidados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os objetos aos seus IDs
        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        // Programando o botão btnAcessar
        btnAcessar.setOnClickListener(this);
        // Programando o botão btnSalvar
        btnSalvar.setOnClickListener(this);


            Toast.makeText(getApplication(),
                    "Query "+DataModel.criarTabelaLogin(),
                    Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnAcessar:
                // Regra de Negócio btnAcessar
                camposValidados = true;
                // Valida o campo LOGIN
                if (!editLogin.getText().toString().equals("aula@foo.maddo")) {
                    Toast.makeText(getApplication(),
                            "O campo LOGIN é obrigatório.....",
                            Toast.LENGTH_LONG).show();
                    // Atribuindo falso para camposValidados
                    camposValidados = false;
                }
                // Valida o campo senha
                if (!editSenha.getText().toString().equals("android")) {
                    Toast.makeText(getApplication(),
                            "O campo Senha é obrigatório....",
                            Toast.LENGTH_LONG).show();
                    // Atribuindo falso para camposValidados
                    camposValidados = false;
                }
                // Carrega a tela Dashboard
                if (camposValidados) {

                    btnSalvar.setEnabled(true);

                } else {
                    Toast.makeText(getApplication(),
                            "Dados inválidos!",
                            Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnSalvar:


                //TODO: Salva os dados no banco de dados

                Login login = new Login();
                login.setLogin(editLogin.getText().toString());
                login.setSenha((editSenha.getText().toString()));

                LoginDAO dao = new LoginDAO(getApplicationContext());

                if(dao.adicionar(login)){
                    Toast.makeText(getApplication(),
                            "Dados adicionado com Sucesso ao Banco de Dados!",
                            Toast.LENGTH_LONG).show();

                    // Muda de tela
                    Intent dashboard = new Intent(MainActivity.this,
                            DashboardActivity.class);
                    startActivity(dashboard);
                    // Remove a Activity Main da pilha
                    finish();
                }else{
                    Toast.makeText(getApplication(),
                            "Erro ao gravar os dados no Banco de Dados!",
                            Toast.LENGTH_LONG).show();
                }

            break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

