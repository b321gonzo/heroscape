package heroscape.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import heroscape.entity.ArmyUnit;

public interface ArmyUnitDao extends JpaRepository<ArmyUnit, Long> {

}
