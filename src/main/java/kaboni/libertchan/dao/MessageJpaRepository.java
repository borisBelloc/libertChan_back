package kaboni.libertchan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Message;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long> {
	public Optional<Message> findById(Long id);
	public Optional<Message> findByPostNumber(Long postNumber);
	public List<Message> findAll();
}
