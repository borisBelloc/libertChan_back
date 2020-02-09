package kaboni.libertchan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kaboni.libertchan.models.Right;

public interface RightJpaRepository extends JpaRepository<Right , Long> {

}
