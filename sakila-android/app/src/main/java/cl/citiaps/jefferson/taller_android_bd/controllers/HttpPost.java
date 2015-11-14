package cl.citiaps.jefferson.taller_android_bd.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: Grupo 7
 */
public class HttpPost extends AsyncTask<String, Void, String> {


    private Context context;

    public HttpPost(Context context) {
        this.context = context;
    }// HttpPost(Context context)

    /***
     * Envia consulta POST.
     * @param params [0] URL, [1] parametros de envio (formato JSON)
     */
    public String sendData(String... params){
        Log.e("LOG_important", params[0]+" - "+params[1]);
        try {

            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(params[1]);
            out.close();
            return "OK";
        }catch(Exception e){
            Log.e("ERROR",this.getClass().toString() + " " + e.toString());
        }
        return "ERROR";
    }

    @Override
    protected String doInBackground(String... data) {
        return sendData(data);
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent("httpPost").putExtra("post", result);
        context.sendBroadcast(intent);
    }// onPostExecute(String result)

}// HttpPost