package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ReservedPseudoJpaRepository;
import kaboni.libertchan.models.ReservedPseudo;

@Service
public class ReservedPseudoService {
	
	@Autowired
	private ReservedPseudoJpaRepository repository;
	
	public Optional<ReservedPseudo> findByPseudo(String pseudo){
		return repository.findByPseudo(pseudo);
		
	}
	
	public Optional<ReservedPseudo> findById(long id){
		return repository.findById(id);
	}
	
	public List<ReservedPseudo> findAll(){
		return repository.findAll();
	}

}
