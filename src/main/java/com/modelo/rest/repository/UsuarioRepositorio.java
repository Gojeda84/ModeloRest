package com.modelo.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.rest.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

}
