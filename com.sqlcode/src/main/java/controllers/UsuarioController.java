package controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import models.Usuario;

public class UsuarioController {
	
	public String createUsuario(String nombre,String apellido, String ciudad) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			Usuario usuario = new Usuario(nombre, apellido, ciudad);
			session.beginTransaction();
						
			session.save(usuario);
			
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Usuario Creado";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al registrar usuario...";
	}
	
	public String deleteUsuario(int id)  {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class,id);
						
			session.delete(usuario);
			
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Usuario Eliminado Correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al eliminar usuario...";
	}

	public String updateUsuario(int id, String nombre) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class,id);
			
			usuario.setNombre(nombre);
						
			session.update(usuario);
			
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Usuario Actualizado Correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar usuario...";
	}
	
	public String getUsuario(int id)  {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class,id);
			
			
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return usuario.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "El usuario no existe...";
	}
}
