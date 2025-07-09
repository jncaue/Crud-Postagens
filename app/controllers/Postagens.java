package controllers;

import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void salvar(Postagem post) {
		post.save();
		listar();
	}

	public static void listar() {
//		lista recebe uma postagem e armazena em listaPostagens
		List<Postagem> listaPostagens = Postagem.findAll();
		render(listaPostagens);
	}
	
	public static void remover(Long id) {
		Postagem post = Postagem.findById(id);
		post.delete();
		listar();
	}
	
	public static void detalhar(Postagem post) {
	    render(post);
	}
	
	public static void editar(Long id) {
		Postagem p = Postagem.findById(id);
		renderTemplate("Postagens/form.html", p);
	}
}
