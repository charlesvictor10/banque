package dev.charles.metier;

import org.springframework.data.domain.Page;

import dev.charles.entities.Compte;
import dev.charles.entities.Operation;
import dev.charles.entities.Roles;
import dev.charles.entities.Users;

public interface IBanqueMetier {
	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public void virement(String codeCompte1, String codeCompte2, double montant);
	public void saveUser(Users u);
	public void saveRole(Roles r);
	public Page<Operation> listOperation(String codeCompte, int page, int size);
}
