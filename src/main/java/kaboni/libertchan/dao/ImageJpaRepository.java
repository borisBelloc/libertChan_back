package kaboni.libertchan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Image;

@Repository
public interface ImageJpaRepository extends JpaRepository<Image, Long>{
	
}
