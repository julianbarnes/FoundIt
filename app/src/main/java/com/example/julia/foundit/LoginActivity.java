package com.example.julia.foundit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import com.amazonaws.mobile.client.AWSMobileClient;


public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button sign_in, register;
    private RequestQueue requestQueue;
    private static final String URL = "string to backend";
    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //May have to move this after we change the order of Activities
        //AWSMobileClient.getInstance().initialize(this).execute();

        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sign_in = findViewById(R.id.login);
        register = findViewById(R.id.register);

        requestQueue = Volley.newRequestQueue(this);

        sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Buttons","This button was clicked");
                Intent intent = new Intent(LoginActivity.this, LostItemBrowseActivity.class);
                startActivity(intent);
            }
            /*public void onClick(View v) {

                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success")) {
                                Toast.makeText(getApplicationContext(), "SUCCESS"
                                        + jsonObject.getString("success"),
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Error" + jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashmap = new HashMap<String, String>();
                        hashmap.put("email", email.getText().toString());
                        hashmap.put("password", password.getText().toString());
                        return hashmap;
                    }
                };
                requestQueue.add(request);
            }*/
        });

    }
}
