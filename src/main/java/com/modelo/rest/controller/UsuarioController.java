package com.modelo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.rest.modelo.Usuario;
import com.modelo.rest.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;

	@GetMapping("/usuario")
	public List<Usuario> listarUsuarios() {
		return servicio.listarUsuarios();
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {

		try {
			Usuario usuario = servicio.obtenerUsuarioById(id);

			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/usuario")
	public void guardarUsuario(@RequestBody Usuario usuario) {
		servicio.guardarUsuario(usuario);
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {

		try {
			Usuario usuarioActual = servicio.obtenerUsuarioById(id);
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setPassword(usuario.getPassword());

			servicio.guardarUsuario(usuarioActual);

			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/usuario/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		servicio.eliminarUsuario(id);
	}

}
