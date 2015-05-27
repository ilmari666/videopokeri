/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/**
 *
 * @author Ilmari
 */
public class MathLoader {
    public MathLoader(String src) throws IOException{
        try(Reader reader = new InputStreamReader(MathLoader.class.getResourceAsStream(src), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            MathConfig cfg = gson.fromJson(reader, MathConfig.class);
        }
    }
}
