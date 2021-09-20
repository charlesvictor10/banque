package dev.charles.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.charles.dao.CompteRepository;
import dev.charles.dao.OperationRepository;
import dev.charles.dao.RolesRepository;
import dev.charles.dao.UsersRepository;
import dev.charles.entities.Compte;
import dev.charles.entities.CompteCourant;
import dev.charles.entities.Operation;
import dev.charles.entities.Retrait;
import dev.charles.entities.Roles;
import dev.charles.entities.Users;
import dev.charles.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Compte consulterCompte(String codeCompte) {
		Compte cp = compteRepository.getOne(codeCompte);
		if(cp==null)
			throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Compte cp = consulterCompte(codeCompte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte cp = consulterCompte(codeCompte);
		double facilitesCaisse = 0;
		if(cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		if(codeCompte1.equals(codeCompte2))
			throw new RuntimeException("Impossible d'effectuer un virement sur le même compte.");
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Operation> listOperation(String codeCompte, int page, int size) {
		return operationRepository.listOperation(codeCompte, new PageRequest(page, size));
	}

	@Override
	public void saveUser(Users u) {
		usersRepository.save(u);
	}

	@Override
	public void saveRole(Roles r) {
		rolesRepository.save(r);
	}
}
