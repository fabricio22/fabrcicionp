package br.com.fabricionp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricionp.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
