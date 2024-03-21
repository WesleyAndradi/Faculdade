package com.example.projetoproduto.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoproduto.Models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {

    @Autowired
    private EntityManager entityManager;
    
    @Transactional
    public void inserir(CategoriaProduto categoriaProduto) {
        entityManager.merge(categoriaProduto);
    }

    public List<CategoriaProduto> obterTodos() {
        return entityManager.createQuery("SELECT c FROM CategoriaProduto c",
                CategoriaProduto.class).getResultList();
    }

    public List<CategoriaProduto> ObterPorId(String id) {
        String jpql = "select c from CategoriaProduto c where c.id like :id";
        TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql,CategoriaProduto.class);
        return query.getResultList();
    }
}


   