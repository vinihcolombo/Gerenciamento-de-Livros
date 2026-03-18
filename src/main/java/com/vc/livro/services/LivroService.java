package com.vc.livro.services;

import com.vc.livro.models.LivroModel;
import com.vc.livro.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    public Optional<LivroModel> buscarId (Long id){
        return livroRepository.findById(id);
    }

    public LivroModel atualizarLivro(Long id, LivroModel livroModel){
        LivroModel newLivroModel = livroRepository.findById(id).get();
        newLivroModel.setTitulo(livroModel.getTitulo());

        return livroRepository.save(newLivroModel);
    }
}
