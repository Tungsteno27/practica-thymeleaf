package com.example.ResourceHub_262797.service;

import com.example.ResourceHub_262797.model.Recurso;
import com.example.ResourceHub_262797.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> obtenerTodos(){
        return recursoRepository.findAll();
    }
    public Optional<Recurso> obtenerPorId(Long id){
        return recursoRepository.findById(id);
    }

    public Recurso crear(Recurso recurso){
        return recursoRepository.save(recurso);
    }
    public Optional<Recurso> actualizar(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExist -> {
            recursoExist.setTitulo(recurso.getTitulo());
            recursoExist.setUrl(recurso.getUrl());
            recursoExist.setCategoria(recurso.getCategoria());
            recursoExist.setTipo(recurso.getTipo());
            return recursoRepository.save(recursoExist);
        } );
    }

    public Optional<Recurso> actualizarParcailmente(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExist -> {
            if(recurso.getTipo()!=null)recursoExist.setTitulo(recurso.getTitulo());
            if(recurso.getUrl()!=null)recursoExist.setUrl(recurso.getUrl());
            if(recurso.getCategoria()!=null)recursoExist.setCategoria(recurso.getCategoria());
            if(recurso.getTipo()!=null)recursoExist.setTipo(recurso.getTipo());
            return recursoRepository.save(recursoExist);
        } );
    }
    public boolean eliminarRecurso(Long id){
       return recursoRepository.deleteById(id);
    }
}
