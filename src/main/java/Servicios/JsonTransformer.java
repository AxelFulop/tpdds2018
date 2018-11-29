package Servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import spark.Response;
import spark.ResponseTransformer;

import java.util.HashMap;
import java.util.List;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        if (model instanceof Response) {
            return gson.toJson(new HashMap<>());
        }
        return gson.toJson(model);
    }

    public static <T> Object jsonToModel(String json, T type)
    {
        Object object;
        Gson gson = new Gson();
        try {
             object = gson.fromJson(json, new TypeToken<T>(){}.getType());
             String a;
        } catch (Exception e) {
            throw new AssertionError("Test error"); //TODO: crear execpcion propia
        }
        return object;
    }

    
 


}