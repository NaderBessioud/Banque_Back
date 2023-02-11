package tn.banque.Services;

import java.util.List;


import tn.banque.Entities.Action;
public interface IActionService {
	List<Action> retrieveAllAction();

	Action addAction (Action act);
	
	Action retrieveAction (Long id);
	
	void deleteAction(Long id);
	
	Action updateAction(Action act);
	
	float sommeAction(float prix, int nombre);
	
	public Iterable<Action> findAll();
	
}
