package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static List<String> jsonArray2List(JSONArray jsonArray) {
        List<String> result = new ArrayList<String>();
        if(jsonArray != null)
        {
            for (int i = 0; i < jsonArray.length() -1; i++ ) {
                try {
                    result.add(jsonArray.getString(i));
                } catch (Exception e) {}
            }
        }
        
        return result;
    }

    public static String implode(String delimiter, List<String> source){
        String result = "";
        for (int i = 1; i < source.size()-2; i++)
        {
            result += source.get(i) + delimiter + "\n";
        }

        result += source.get(source.size() - 1);

        return result;
    }

    public static Sandwich parseSandwichJson(String json) {
        Sandwich s = new Sandwich();

        try {
            JSONObject jsonSandwich = new JSONObject(json);

            JSONObject name = jsonSandwich.getJSONObject("name");
            s.setMainName(name.getString("mainName"));
            s.setAlsoKnownAs(JsonUtils.jsonArray2List(name.getJSONArray("alsoKnownAs")));
            s.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
            s.setDescription(jsonSandwich.getString("description"));
            s.setImage(jsonSandwich.getString("image"));
            s.setIngredients(JsonUtils.jsonArray2List(jsonSandwich.getJSONArray("ingredients")));
        } catch (Exception e) {}

        return s;
    }
}
