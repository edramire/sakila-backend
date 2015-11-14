package cl.citiaps.jefferson.taller_android_bd.views;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author:
 */
import org.json.JSONObject;

import java.util.Date;

import cl.citiaps.jefferson.taller_android_bd.R;
import cl.citiaps.jefferson.taller_android_bd.controllers.HttpPost;
import cl.citiaps.jefferson.taller_android_bd.model.Actor;
import cl.citiaps.jefferson.taller_android_bd.utilities.JsonHandler;
import cl.citiaps.jefferson.taller_android_bd.utilities.SystemUtilities;

public class NewItem extends Fragment {

    private BroadcastReceiver br = null;
    //private IntentFilter intentFilter;

    /**
     * Constructor. Obligatorio para Fragmentos!
     */
    public NewItem() {
    }// NewItem()

    /**
     * Método que crea la vista del fragmento
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.new_item, container, false);
        Button button = (Button)v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SystemUtilities su = new SystemUtilities(getActivity().getApplicationContext());

                if(su.isNetworkAvailable()) {
                    IntentFilter intentFilter = new IntentFilter("httpPost");

                    //Obtenemos los datos entregados por el usuario

                    String name = ((EditText) getActivity().findViewById(R.id.edit_name)).getText().toString();
                    String last_name = ((EditText) getActivity().findViewById(R.id.edit_last_name)).getText().toString();
                    Date d = new Date();

                    // no tiene id asignado actualmente
                    Actor a = new Actor(0, name, last_name, d.toString());

                    JsonHandler jh = new JsonHandler();
                    JSONObject jObject = jh.setActor(a);

                    br = new BroadcastReceiver() {
                        @Override
                        public void onReceive(Context context, Intent intent) {
                            String result = intent.getStringExtra("post");
                            if(result.equals("OK")){
                                Toast.makeText(getActivity(), getResources().getString(R.string.actor_created),
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getActivity(), getResources().getString(R.string.error_database_connection),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    };
                    getActivity().registerReceiver(br, intentFilter);
                    new HttpPost(getActivity().getApplicationContext()).execute(getResources().getString(R.string.server),jObject.toString());
                }else{
                    Toast.makeText(getActivity(), getResources().getString(R.string.error_internet), Toast.LENGTH_LONG).show();
                }

            }
        });

        return v;
    }// onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)


    @Override
    public void onPause() {
        getActivity().unregisterReceiver(br);
        super.onPause();
    }
}// NewItem extends Fragment