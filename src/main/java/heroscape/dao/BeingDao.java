package heroscape.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import heroscape.entity.Being;

public interface BeingDao extends JpaRepository<Being, Long> {

}
