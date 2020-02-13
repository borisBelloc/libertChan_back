package kaboni.libertchan.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import kaboni.libertchan.models.ReservedPseudo;



public interface ReservedPseudoJpaRepository extends JpaRepository<ReservedPseudo, Integer> {
	public Optional<ReservedPseudo> findByPseudo(String pseudo);
	public Optional<ReservedPseudo> findById(Long id);
	public Optional<ReservedPseudo> findByIp(String ip);
	public List<ReservedPseudo> findAll();

}
