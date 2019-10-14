package com.innovasoft.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Registro_Usuario extends AppCompatActivity {

    EditText etextnombre,etextpaterno,etextmaterno,etextcedula, etextcontra;
    Button btnguardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registro__usuario );

        etextcedula=(EditText)findViewById( R.id.etextcedula );
        etextnombre=(EditText)findViewById( R.id.etextnombre );
        etextmaterno=(EditText)findViewById( R.id.etextmaterno );
        etextpaterno=(EditText)findViewById( R.id.etextpaterno );
        etextcontra=(EditText)findViewById( R.id.etextcontra ) ;
        btnguardar=(Button)findViewById( R.id.btnguardar );


        btnguardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio( "http://192.168.0.2/resto/insertar_usuario.php" );
            }
        } );

    }

    private void ejecutarServicio(String URL)
    {
        StringRequest stringRequest=new StringRequest( Request.Method.POST, URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Toast.makeText( getApplicationContext(), "Se guardo correctamente", Toast.LENGTH_SHORT ).show();
            }
        }, new Response.ErrorListener()
            {
            @Override
            public void onErrorResponse(VolleyError error)
                {
                Toast.makeText( getApplicationContext(),error.toString(), Toast.LENGTH_SHORT ).show();
                }

            })
             {
            @Override
            protected Map<String, String>getParams()throws AuthFailureError
                {
                    Map<String, String> parametros = new HashMap<String, String>(  );
                   parametros.put( "id_usuario", etextcedula.getText().toString() );
                    parametros.put( "nombre", etextnombre.getText().toString() );
                    parametros.put( "paterno", etextpaterno.getText().toString() );
                    parametros.put( "materno", etextmaterno.getText().toString() );
                    parametros.put( "contrasenia", etextcontra.getText().toString() );

                    return parametros;
                }
            };
            RequestQueue requestQueue=Volley.newRequestQueue( this );
            requestQueue.add( stringRequest );
    }
}
