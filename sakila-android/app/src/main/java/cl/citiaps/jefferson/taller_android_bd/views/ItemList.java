package cl.citiaps.jefferson.taller_android_bd.views;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import cl.citiaps.jefferson.taller_android_bd.R;
import cl.citiaps.jefferson.taller_android_bd.controllers.HttpGet;
import cl.citiaps.jefferson.taller_android_bd.model.Actor;
import cl.citiaps.jefferson.taller_android_bd.utilities.JsonHandler;
import cl.citiaps.jefferson.taller_android_bd.utilities.SystemUtilities;

/**
 * @author: Jefferson Morales De la Parra
 * Clase Fragmento (Lista) que se utiliza para mostrar una lista de items
 */
public class ItemList extends ListFragment {

    private BroadcastReceiver br = null;
    private Actor[] actorList;

    /**
     * Constructor. Obligatorio para Fragmentos!
     */
    public ItemList() {
    }// ItemList()

    /**
     * Método que se llama una vez que se ha creado la actividad que contiene al fragmento
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }// onActivityCreated(Bundle savedInstanceState)

    /**
     * Método que escucha las pulsaciones en los items de la lista
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //String item = l.getItemAtPosition(position).toString();
        //String[] separated = item.split("\\s+");
        Fragment itemDetail = new ItemDetail();
        Bundle arguments = new Bundle();
        arguments.putString("id", String.valueOf(actorList[position].getId()));
        arguments.putString("name", actorList[position].getName());
        arguments.putString("lastName", actorList[position].getLastName());
        arguments.putString("lastUpdate", actorList[position].getLastUpdate());
        itemDetail.setArguments(arguments);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, itemDetail);
        transaction.addToBackStack(null);
        transaction.commit();
    }// onListItemClick(ListView l, View v, int position, long id)

    /**
     * Método que se ejecuta luego que el fragmento es creado o restaurado
     */
    @Override
    public void onResume() {
        SystemUtilities su = new SystemUtilities(getActivity().getApplicationContext());

        if (su.isNetworkAvailable()) {
            IntentFilter intentFilter = new IntentFilter("httpData");
            br = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    JsonHandler jh = new JsonHandler();
                    actorList = jh.getActors(intent.getStringExtra("data"));
                    if(actorList==null){
                        Toast.makeText(getActivity(), getResources().getString(R.string.error_database_connection),
                                Toast.LENGTH_LONG).show();
                        setActorList(new String[0]); //mostrar lista vacia
                    }
                    else{
                        String[] actorsToString = new String[actorList.length];
                        for(int i=0;i<actorList.length;i++){
                            actorsToString[i] =actorList[i].toString();
                        }
                        setActorList(actorsToString);
                    }
                }
            };
            getActivity().registerReceiver(br, intentFilter);
            new HttpGet(getActivity().getApplicationContext()).execute(getResources().getString(R.string.server));
        }else{
            Toast.makeText(getActivity(), getResources().getString(R.string.error_internet), Toast.LENGTH_LONG).show();
            setActorList(new String[0]); //evitar pantalla de loading eterna
        }
        Log.i("INFO-" + this.getClass(), "Resume");
        super.onResume();
    }// onResume()

    /**
     * Método que se ejecuta luego que el fragmento se detiene
     */
    @Override
    public void onPause() {
        Log.i("INFO-"+this.getClass(),"Pause");
        if (br != null) {
            getActivity().unregisterReceiver(br);
        }
        super.onPause();
    }// onPause()

    private void setActorList(String[] actors){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity()
                , android.R.layout.simple_list_item_1, actors);
        setListAdapter(adapter);
    }// setActorList(String[] actors)

}// ItemList extends ListFragment