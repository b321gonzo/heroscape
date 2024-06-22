package heroscape.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import heroscape.entity.Wave;

public interface WaveDao extends JpaRepository<Wave, Long> {

}
