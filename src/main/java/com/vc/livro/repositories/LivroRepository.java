package com.vc.livro.repositories;

import com.vc.livro.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel,Long> {

}