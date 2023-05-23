//tutorial aquí: https://www.youtube.com/watch?v=_F_-wNCahL0

package view;

import controllers.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {

		//Para crear un usuario
		//String usuario = new UsuarioController().createUsuario("Franco", "Cosolito", "Santo Tomé");
		
		//Para eliminar un usuario
		String usuario = new UsuarioController().deleteUsuario(3);

		//Para actualizar un usuario
		String usuario2 = new UsuarioController().updateUsuario(4,"Jerónimo");

		//Para recuperar un usuario
		//String usuario = new UsuarioController().getUsuario(3);

		
		System.out.println(usuario);
		System.out.println(usuario2);
	}

}
