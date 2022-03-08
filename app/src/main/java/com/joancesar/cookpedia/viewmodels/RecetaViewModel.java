package com.joancesar.cookpedia.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.joancesar.cookpedia.model.Ingrediente;
import com.joancesar.cookpedia.model.PasoReceta;
import com.joancesar.cookpedia.model.Receta;
import com.joancesar.cookpedia.model.RecetaConIngredientesConPasos;
import com.joancesar.cookpedia.repositories.RecetaRepository;

import java.util.List;

public class RecetaViewModel extends AndroidViewModel {

    private RecetaRepository repository;
    private LiveData<List<RecetaConIngredientesConPasos>> allRecetas;

    public RecetaViewModel(@NonNull Application application) {
        super(application);
        repository = new RecetaRepository(application);
        allRecetas = repository.getAllRecetas();
    }

    public long insertReceta(Receta receta) {
        return repository.insertReceta(receta);
    }

    public void updateReceta(Receta receta) {
        repository.updateReceta(receta);
    }

    public void deleteReceta(Receta receta) {
        repository.deleteReceta(receta);
    }

    public void insertIngredientes(List<Ingrediente> ingredientes) {
        repository.insertIngredientes(ingredientes);
    }

    public void deleteIngredientes(List<Ingrediente> ingredientes) {
        repository.deleteIngredientes(ingredientes);
    }

    public void insertPasosReceta(List<PasoReceta> pasoRecetas) {
        repository.insertPasosReceta(pasoRecetas);
    }

    public void deletePasosReceta(List<PasoReceta> pasoRecetas) {
        repository.deletePasosReceta(pasoRecetas);
    }

    public LiveData<List<RecetaConIngredientesConPasos>> getAllRecetas() {
        return allRecetas;
    }

    public LiveData<List<RecetaConIngredientesConPasos>> getRecetaByTitulo(String search) {
        return repository.getRecetaByTitulo(search);
    }
}
