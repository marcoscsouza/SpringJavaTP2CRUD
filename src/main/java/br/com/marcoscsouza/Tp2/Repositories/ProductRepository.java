package br.com.marcoscsouza.Tp2.Repositories;

import br.com.marcoscsouza.Tp2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


}
