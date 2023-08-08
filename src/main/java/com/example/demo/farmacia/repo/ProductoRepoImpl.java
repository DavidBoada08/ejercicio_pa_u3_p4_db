package com.example.demo.farmacia.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.farmacia.repo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);

	}

	@Override

	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);

	}

	@Override
	
	public Producto buscar(String codBarras) {
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT i FROM Item i WHERE i.codBarras = :datoCodBarras", Producto.class);
		myQuery.setParameter("datoCodigoBarras", codBarras);
		return myQuery.getSingleResult();
	}

	@Override
	public boolean buscarProductoExistente(String codBarras) {
		try {
			TypedQuery<Producto> myQuery = this.entityManager
					.createQuery("SELECT i FROM Item i WHERE i.codBarras = :datoCodBarras", Producto.class);
			myQuery.setParameter("datoCodigoBarras", codBarras);
			Producto i = myQuery.getSingleResult();

			if (i != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	

	@Override

	public List<Producto> buscarPortipo(String tipo) {
		// TODO Auto-generated method stub
				CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
				CriteriaQuery<Producto> myQuery = myCriteria.createQuery(Producto.class);

				Root<Producto> myTabla = myQuery.from(Producto.class);

				Predicate predicado = myCriteria.equal(myTabla.get("categoria"), tipo);

				myQuery.select(myTabla).where(predicado);

				TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQuery);
				return myQueryFinal.getResultList();
			
	}
	
}
