package tn.banque.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Action;
import tn.banque.Repositories.ActionRepository;
import org.hibernate.query.Query;  


@Service
public class ActionServiceImp implements IActionService{
	@Autowired
	ActionRepository ar;

	public float sommeAction(float prix, int nombre)
	{
		return prix * nombre;
	}
	
	@Override
	public List<Action> retrieveAllAction() {
		return (List<Action>) ar.findAll() ;

	}

	@Override
	public Action addAction(Action act) {
		float produit = sommeAction(act.getPrix(), act.getNombre());
		act.setTotal(produit);
		ar.save(act);
		return act;
	}

	@Override
	public Action retrieveAction(Long id) {
		Action act=  ar.findById(id).orElse(null);
		return act;
	}

	@Override
	public void deleteAction(Long id) {
		ar.deleteById(id);
		
	}
	
	@Override
	public Action updateAction(Action act) {
		ar.save(act);
		float produit = sommeAction(act.getPrix(), act.getNombre());
		act.setTotal(produit);
		ar.save(act);
		return act;
	}
	
	@Override
	public Iterable<Action> findAll(){
		return ar.findAll();
	}

}
