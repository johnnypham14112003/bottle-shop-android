package com.prm392.ego_flask;


import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.prm392.ego_flask.utils.SessionManager;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginTask extends AsyncTask<String, Void, String> {
    private static final String TAG = "LoginTask";
    private Context context;

    public LoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String email = params[0];
        String password = params[1];
        String apiUrl = "https://egoflask-be.azurewebsites.net/api/Account/login";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("email", email);
            jsonParam.put("password", password);

            OutputStream os = connection.getOutputStream();
            os.write(jsonParam.toString().getBytes("UTF-8"));
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString(); // Trả về phản hồi từ server
            } else {
                Log.e(TAG, "Login failed: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result != null) {
            try {
                // Chuyển đổi chuỗi JSON thành đối tượng JSONObject
                JSONObject jsonObject = new JSONObject(result);
                String token = jsonObject.getString("token");
                String role = jsonObject.getString("role");
                String userId = "YOUR_USER_ID"; // Lấy userId từ đâu đó, nếu không có trong response
                String username = "YOUR_USERNAME"; // Lấy username từ đâu đó, nếu không có trong response

                // Lưu thông tin vào SessionManager
                SessionManager sessionManager = new SessionManager(context);
                sessionManager.createLoginSession(userId, username, token, role);

                // Hiển thị thông báo và chuyển đến MainActivity
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(context, "Error parsing data", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Error: " + e.getMessage());
            }
        } else {
            Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

}
