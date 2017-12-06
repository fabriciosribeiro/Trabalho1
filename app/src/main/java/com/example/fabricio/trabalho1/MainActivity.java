package com.example.fabricio.trabalho1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //add
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cadastrar = (Button) findViewById(R.id.btCadastrar);
        final EditText edNome = (EditText) findViewById(R.id.edNome);
        final EditText edSenha = (EditText) findViewById(R.id.edSenha);
        final EditText edRepitaSenha = (EditText) findViewById(R.id.edRepitaSenha);
        final EditText edEmail = (EditText) findViewById(R.id.edEmail);
        final RadioGroup sexoOpcoes = (RadioGroup) findViewById(R.id.sexoOpcoes);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int s = sexoOpcoes.getCheckedRadioButtonId();
                String sexo ="";
                String senha1 = edSenha.getText().toString();
                String senha2 = edRepitaSenha.getText().toString();

                if(senha1.equals(senha2)) {
                    if (s == R.id.rMasculino)
                        sexo = "Masculino";
                    else
                        sexo = "Feminino";

                    String msg = "Nome: "+ edNome.getText().toString();
                    msg += "\nSenha: " + edSenha.getText().toString();
                    msg += "\nE-mail: " + edEmail.getText().toString();
                    msg += "\nSexo: " + sexo;

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Cadastro");
                    dialogo.setMessage(msg);
                    dialogo.setNeutralButton("OK",null);
                    dialogo.show();
                }else{
                    Toast.makeText(MainActivity.this, "A primeira senha informada não confere com a segunda", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
