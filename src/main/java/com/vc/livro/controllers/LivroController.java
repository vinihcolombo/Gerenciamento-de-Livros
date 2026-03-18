package com.vc.livro.controllers;

import com.vc.livro.LivroApplication;
import com.vc.livro.models.LivroModel;
import com.vc.livro.services.LivroService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.dnd.DragGestureEvent;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity <LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        livroService.criarLivro(livroModel);
        LivroModel request = livroService.criarLivro(livroModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(livroModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroModel> > findAll(){
        List<LivroModel> request = livroService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorId(@PathVariable Long id){
        Optional<LivroModel> livro = livroService.buscarId(id);

        if(livro.isPresent()){
            return ResponseEntity.ok(livro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizar (@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel request = livroService.atualizarLivro(id, livroModel);
        return ResponseEntity.ok().body(request);
    }

}
