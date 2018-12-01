package com.guilfram.reportado.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.guilfram.reportado.app.models.entity.Publicacion;

public interface IPublicacionDao extends CrudRepository<Publicacion, Long>{

	//@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	//public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
	
	//@Query("select p from Publicacion p join fetch p.usuario u join fetch p.locaidad b join fetch p.publicacionCaracteristicas r join fetch r.caracteristica where p.id=?1")
	//public Publicacion fetchPublicacionByIdWithUbicacionWithCaracteristicas(Long id);
	
	@Query("select p from Publicacion p")
	public Publicacion fetchPublicacionByIdWithUbicacionWithCaracteristicas(Long id);
	
	@Query("select p from Publicacion p join fetch p.publicacionCaracteristicas r where r.valor like %?1%")
	public List<Publicacion> findPublicacionByValor(String valor);
}
