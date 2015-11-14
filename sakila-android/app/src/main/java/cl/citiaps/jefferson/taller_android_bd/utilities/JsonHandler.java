package cl.citiaps.jefferson.taller_android_bd.utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cl.citiaps.jefferson.taller_android_bd.model.Actor;
/**
 * @author: Jefferson Morales De la Parra
 * Clase que se utiliza para manipular objetos JSON
 */
public class JsonHandler {

    /**
     * Método que recibe un JSONArray en forma de String y devuelve un Actor[] con los actores
     */
    public Actor[] getActors(String actors) {
        if(actors == null){
            return null;
        }
        try {
            JSONArray ja = new JSONArray(actors);
            Actor[] result = new Actor[ja.length()];
            Actor actor;
            for (int i = 0; i < ja.length(); i++) {
                JSONObject row = ja.getJSONObject(i);
                actor = new Actor(
                        Integer.parseInt(row.getString("actorId")),
                        row.getString("firstName"),
                        row.getString("lastName"),
                        row.getString("lastUpdate")
                );
                //actor = " " + row.getString("firstName") + " " + row.getString("lastName");
                result[i] = actor;
            }
            return result;
        } catch (JSONException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
        return null;
    }// getActors(String actors)

    public JSONObject setActor(Actor actor) {
        // build jsonObject
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.accumulate("firstName", actor.getName());
            jsonObject.accumulate("lastName", actor.getLastName());
            return jsonObject;

        }catch(JSONException je){
            Log.e("ERROR",this.getClass().toString()+ " - "+ je.getMessage());
        }
        return null;
    }


    }// JsonHandler