package pablofranco.org.aplicacion_turismo_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import pablofranco.org.aplicacion_turismo_android.Bean.Usuario;
import pablofranco.org.aplicacion_turismo_android.volley.WebService;
public class Login extends AppCompatActivity {

    private TextView txtEmail,txtPassword;
    private Button btnLogin;
    private Usuario userLogged = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        txtEmail=(TextView) findViewById(R.id.txtEmail);
        txtPassword=(TextView) findViewById(R.id.txtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> params=new HashMap<String, String>();
                params.put("correo",txtEmail.getText().toString());
                params.put("contraseña",txtPassword.getText().toString());

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, WebService.autenticar, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray listaUsuarios=response.getJSONArray("data");
                            if(listaUsuarios.length()>0){
                                //Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                                JSONObject user=listaUsuarios.getJSONObject(0);
                                userLogged=new Usuario(
                                        user.getInt("id_Usuario"),
                                        user.getString("nombre"),
                                        user.getString("correo"),
                                        user.getString("contraseña"),
                                        user.getString("nick"),
                                        user.getInt("telefono"),
                                        user.getString("nacionalidad"),
                                        user.getInt("id_Rol"),
                                        response.getString("token"),
                                        response.getString("exp")
                                );
                                startActivity(new Intent(Login.this,menuPrincipal.class));
                            }else{
                                Toast.makeText(getApplicationContext(),"Verifique sus Credenciales",Toast.LENGTH_LONG).show();
                            }
                        }catch(Exception ex){
                            Log.e("Response exception ",ex.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError err) {
                        Log.d("Error: Response ",err.getMessage());
                    }
                }
                );
                WebService.getInstance(v.getContext()).addToRequestQueue(request);
            }
        });
    }
}