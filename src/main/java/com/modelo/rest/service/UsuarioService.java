package com.modelo.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.rest.modelo.Usuario;
import com.modelo.rest.repository.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();
	}

	public void guardarUsuario(Usuario usuario) {
		repositorio.save(usuario);
	}

	public Usuario obtenerUsuarioById(Integer id) {
		return repositorio.findById(id).get();
	}

	public void eliminarUsuario(Integer id) {
		repositorio.deleteById(id);
	}

}
