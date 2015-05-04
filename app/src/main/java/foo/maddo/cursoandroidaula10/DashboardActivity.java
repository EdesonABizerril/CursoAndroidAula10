package foo.maddo.cursoandroidaula10;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class DashboardActivity extends ActionBarActivity {

    ImageView imgURL, imgSingOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imgURL = (ImageView) findViewById(R.id.imgURL);

        imgURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Carrega a URL
                Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse
                ("https://play.google.com/store/apps/developer?id=MarcoMaddo"));

                startActivity(intent);

            }
        });

        imgSingOut = (ImageView) findViewById(R.id.imgSingOut);
        imgSingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma instância da classe Alert Dialog
                AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(DashboardActivity.this);
                // Setando o título da tela de Alerta
                alertDialog.setTitle("Sair da Aula 09...");
                // Setando a mensagem do alerta
                alertDialog.setMessage("Você realmente deseja sair?");
                // Setando o icone para o alerta
                alertDialog.setIcon(R.drawable.ic_sair);
                // Setando o botão "Sim"
                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(getApplicationContext(),
                                "Até Breve...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                // Setando o botão "Não"
                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Ok, vamos continuar...", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Monstra a tela de Alerta
                alertDialog.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
