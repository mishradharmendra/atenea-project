package co.com.inascol.atenea.dao.utils;

import java.util.List;

public interface DAO {

	public boolean crear(Object obj);
	public boolean actualizar(Object obj);
	public boolean borrar(Object idObj);
	public Object buscarPorId(Object idObj);
	public List<Object> buscarTodos();
}