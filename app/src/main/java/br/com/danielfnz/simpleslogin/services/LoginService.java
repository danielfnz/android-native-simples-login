package br.com.danielfnz.simpleslogin.services;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.danielfnz.simpleslogin.R;
import br.com.danielfnz.simpleslogin.model.User;

import java.util.HashMap;
import java.util.Map;


public class LoginService extends WebTaskBase{

    private static String ENDPOINT = "login";
    private String email;
    private String password;

    public LoginService(Context context,  String email, String password) {
        super(context, ENDPOINT);
        this.email = email;
        this.password = password;
    }

    @Override
    public void handleResponse(String response) {
        Log.i("teste", response);
        System.out.print(response);
        try {
            JSONObject responseJSON = new JSONObject(response);

            String name = responseJSON.getString("name");
            String token = responseJSON.getString("token");
            String photoUrl = responseJSON.getString("photo_url");

            User user = new User(name, token, photoUrl);

            EventBus.getDefault().post(user);
        } catch (JSONException e) {
            if(!isSilent()){
                EventBus.getDefault().post(new Error(getContext().getString(R.string.label_error_invalid_response)));
            }
        }
    }

    @Override
    public String getRequestBody() {
        Log.i("teste", "getRequestBody");
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("email", email);
        requestMap.put("password", password);

        JSONObject json = new JSONObject(requestMap);
        String jsonString = json.toString();

        return  jsonString;
    }
}
