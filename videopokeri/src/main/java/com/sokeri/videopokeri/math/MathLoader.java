package com.sokeri.videopokeri.math;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author Ilmari
 */
public class MathLoader {
    public MathLoader() {
        
    }
/**
 * Load a given configuration file, maps it to a MathConfig object
 * @param src Source file path
 * @return MathConfig or null if fails
 */
    public MathConfig load(String src) {
        try {
            Reader reader = new InputStreamReader(MathLoader.class.getResourceAsStream(src), "UTF-8");
            Gson gson = new GsonBuilder().create();
            MathConfig cfg = gson.fromJson(reader, MathConfig.class);
            return cfg;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
