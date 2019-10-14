package com.innovasoft.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login );
        TextView registro=(TextView) findViewById( R.id.txtregistrar );
        registro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent( Login.this, Registro_Usuario.class  );
                Login.this.startActivity( registro );
                finish();
            }
        } );

    }
}
