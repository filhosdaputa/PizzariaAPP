package br.edu.ifms.pizzaria;

import android.os.AsyncTask;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class BackgroundWebRunner extends AsyncTask<String, Void, String> {
    private static final String TAG = "BackgroundWebRunner";
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {
        Response response = null;
        Request request = new Request.Builder()
                .url(params[0])
                .build();

        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
