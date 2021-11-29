package br.com.artucrop.backendcarlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.artucrop.backendcarlos.entities.DevEntity;

public interface DevRepository extends JpaRepository<DevEntity, Long>{

}
