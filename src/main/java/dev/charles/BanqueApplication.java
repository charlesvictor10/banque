package dev.charles;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dev.charles.dao.ClientRepository;
import dev.charles.dao.CompteRepository;
import dev.charles.dao.OperationRepository;
import dev.charles.entities.Client;
import dev.charles.entities.Compte;
import dev.charles.entities.CompteCourant;
import dev.charles.entities.CompteEpargne;
import dev.charles.entities.Retrait;
import dev.charles.entities.Versement;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Client c1 = clientRepository.save(new Client("Abdoulaye Dia", "layedia07@gmail.com"));
		Client c2 = clientRepository.save(new Client("Seydou Moussa Sall", "seydousall7@gmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 90000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 90000, cp1));
		operationRepository.save(new Versement(new Date(), 60000, cp1));
		operationRepository.save(new Versement(new Date(), 20000, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));
		
		operationRepository.save(new Versement(new Date(), 50000, cp2));
		operationRepository.save(new Versement(new Date(), 30000, cp2));
		operationRepository.save(new Versement(new Date(), 80000, cp2));
		operationRepository.save(new Retrait(new Date(), 4000, cp2));*/
	}
}

