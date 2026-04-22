package com.example.umbrella.repository;


import com.example.umbrella.common.ListaBOWs;
import com.example.umbrella.domain.model.Bow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BowRepository {
    private final ListaBOWs lista;

    public BowRepository(ListaBOWs lista) {
        this.lista = lista;
    }

    public List<Bow> findAll() {
        return lista.getBows();
    }
}
