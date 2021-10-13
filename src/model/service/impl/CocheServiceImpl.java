package model.service.impl;

import java.util.HashMap;
import java.util.List;

import model.entity.Coche;
import model.repository.impl.CocheRepositoryImpl;
import model.respository.CocheRepository;
import model.service.CocheService;

public class CocheServiceImpl implements CocheService {

	CocheRepository cocheRepository = new CocheRepositoryImpl();

	/**
	 * @param c -> Objeto coche
	 * @return -> Devuelve un objeto HashMap indicando si está todo correcto o han habido errores
	 */
	@Override
	public HashMap<String, String> alta(Coche c) {
		HashMap<String, String> messages = new HashMap<>();
		if (c != null) {
			if (c.getMarca().length() == 0) {
				messages.put("Marca Error -> ", "El campo Marca no puede estar vacío");
			} 
			if (c.getMatricula().length() != 7) {
				messages.put("Matricula Error -> ", "El campo Matricula debe tener 7 caracteres");
			}
			if (c.getModel().length() == 0) {
				messages.put("Model Error -> ", "El campo Modelo no puede estar vacío");
			}
			if (messages.isEmpty()) {
				if (cocheRepository.alta(c))
					messages.put("Alta Correcta -> ", "El vehiculo ha sido creado correctamente");
				else 
					messages.put("Persistence Error -> ", "Error contra la base de datos");
			}
		} else {
			messages.put("Null Error -> ", "El objeto coche no puede ser nulo");
		}
		return messages;
	}

	/**
	 * @param id -> parámetro para buscar a través del repositorio un objeto Coche con esa ID
	 * @return -> Devuelve un objeto HashMap indicando si está todo correcto o han habido errores
	 */
	@Override
	public HashMap<String, String> baja(int id) {
		HashMap<String, String> messages = new HashMap<>();
		Coche coche = cocheRepository.obtener(id);
		if (coche != null) {			
			if (cocheRepository.baja(id))
				messages.put("Baja Correcta -> ", "El vehiculo se ha eliminado correctamente");
			else
				messages.put("Persistence Error -> ", "Error contra la base de datos");
		} else {
			messages.put("Null Error -> ", "El coche con la ID " + id + " no se encuentra en la bbdd");
		}
		return messages;
	}

	/**
	 * @param c -> Objeto coche
	 * @return -> Devuelve un objeto HashMap indicando si está todo correcto o han habido errores
	 */
	@Override
	public HashMap<String, String> modificar(Coche c) {
		HashMap<String, String> messages = new HashMap<>();
		if (c != null) {
			if (c.getMarca().length() == 0) {
				messages.put("Marca Error -> ", "El campo Marca no puede estar vacío");
			} 
			if (c.getMatricula().length() != 7) {
				messages.put("Matricula Error -> ", "El campo Matricula debe tener 7 caracteres");
			}
			if (c.getModel().length() == 0) {
				messages.put("Model Error -> ", "El campo Modelo no puede estar vacío");
			}
			if (messages.isEmpty()) {
				if (cocheRepository.modificar(c))
					messages.put("Modificación Correcta -> ", "El vehiculo ha sido modificado correctamente");
				else
					messages.put("Persistence Error -> ", "Error contra la base de datos");
			}
		} else {
			messages.put("Null Error -> ", "El objeto coche no puede ser nulo");
		}
		return messages;
	}

	/**
	 * @param id -> parámetro para buscar a través del repositorio un objeto Coche con esa ID
	 * @return -> Devuelve el objeto Coche encontrado con esa ID
	 */
	@Override
	public Coche obtener(int id) {
		return cocheRepository.obtener(id);
	}

	/**
	 * @return -> Devuelve la lista de los coches existentes en la BBDD
	 */
	@Override
	public List<Coche> listar() {
		return cocheRepository.listar();
	}

}
