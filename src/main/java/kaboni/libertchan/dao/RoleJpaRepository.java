package kaboni.libertchan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {
}
