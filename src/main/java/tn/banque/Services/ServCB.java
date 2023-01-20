package tn.banque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Comptebancaire;

import tn.banque.Repositories.CBRepo;

@Service
public class ServCB implements ISCB {
@Autowired
CBRepo repo;
@Override
public List<Comptebancaire> retrieveAllCb() {
	List<Comptebancaire> lct=(List<Comptebancaire>)repo.findAll();
	return lct;
}
}
