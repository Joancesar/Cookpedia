package com.joancesar.cookpedia.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.joancesar.cookpedia.dao.RecetaDao;
import com.joancesar.cookpedia.model.Ingrediente;
import com.joancesar.cookpedia.model.PasoReceta;
import com.joancesar.cookpedia.model.Receta;

@Database(entities = {Receta.class, Ingrediente.class, PasoReceta.class}, version = 4, exportSchema = false)
public abstract class RecetaDatabase extends RoomDatabase {

    private static RecetaDatabase instance;

    public abstract RecetaDao recetaDao();

    public synchronized static RecetaDatabase getInstance(final Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            RecetaDatabase.class, "receta_database")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return instance;
    }


}
