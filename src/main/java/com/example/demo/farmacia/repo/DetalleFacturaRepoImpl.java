package com.example.demo.farmacia.repo;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Repository;

import com.example.demo.farmacia.repo.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		
		this.entityManager.persist(detalleFactura);
		
	}

	@Override
	public void actualizar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleFactura);
	}

	@Override
	public List<DetalleFactura> buscarPorVenta(String numero) {
		TypedQuery<DetalleFactura> myQuery = this.entityManager.createQuery("SELECT df FROM DetalleFactura df WHERE df.factura.numero = :datoNumero",
				DetalleFactura.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getResultList();
	}

	@Override
	public Item buscarPorItem(String codBarras) {
		TypedQuery<Item> myQuery = this.entityManager.createQuery("SELECT i FROM DetalleFactura df, Item i WHERE df.item.codBarras = :codBarras",
				Item.class);
		myQuery.setParameter("datoCodBarras", codBarras);
		return myQuery.getSingleResult();
	}
	
	

}
