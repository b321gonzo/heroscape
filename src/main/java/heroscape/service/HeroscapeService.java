package heroscape.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import heroscape.controller.model.BeingData;
import heroscape.controller.model.BeingData.ArmyUnitData;
import heroscape.dao.ArmyUnitDao;
import heroscape.dao.BeingDao;
import heroscape.entity.ArmyUnit;
import heroscape.entity.Being;

@Service
public class HeroscapeService {
	
	
	//Being methods
	
	@Autowired
	private BeingDao beingDao;	

	@Transactional(readOnly = false)
	public BeingData saveBeing(BeingData beingData) {
		Being being = beingData.toBeing();
		Being dbBeing = beingDao.save(being);
		
		return new BeingData(dbBeing);
	}

	@Transactional(readOnly = true)
	public BeingData retrieveBeingById(Long beingId) {
		Being being = findBeingById(beingId);
		return new BeingData(being);
	}

	private Being findBeingById(Long beingId) {
		return beingDao.findById(beingId).orElseThrow(() -> new NoSuchElementException("Being with ID=" + beingId + " was not found."));
	}

	@Transactional(readOnly = false)
	public void deleteBeing(Long beingId) {
		Being being = findBeingById(beingId);
		beingDao.delete(being);
	}

	
	@Autowired
	private ArmyUnitDao armyUnitDao;
	
	@Transactional(readOnly = false)
	public ArmyUnitData saveArmyUnit(Long beingId, ArmyUnitData armyUnitData) {
		Being being = findBeingById(beingId);
		ArmyUnit armyUnit = findOrCreateArmyUnit(beingId, armyUnitData.getArmyUnitId());
		
		copyArmyUnitFields(armyUnit, armyUnitData);
		
		armyUnit.setBeing(being);
		being.getArmyUnits().add(armyUnit);
		
		armyUnit = armyUnitDao.save(armyUnit);
				
		return new ArmyUnitData(armyUnit);
	}

	private void copyArmyUnitFields(ArmyUnit armyUnit, ArmyUnitData armyUnitData) {
		armyUnit.setValkyrieGeneral(armyUnitData.getValkyrieGeneral());
		armyUnit.setBasicMove(armyUnitData.getBasicMove());
		armyUnit.setBasicRange(armyUnitData.getBasicRange());
		armyUnit.setBasicAttack(armyUnitData.getBasicAttack());
		armyUnit.setBasicDefense(armyUnitData.getBasicDefense());
	}

	private ArmyUnit findOrCreateArmyUnit(Long beingId, Long armyUnitId) {
		if (armyUnitId == null) {
			return new ArmyUnit();
		} else {
			return findArmyUnitById(beingId, armyUnitId);
		}
	}

	private ArmyUnit findArmyUnitById(Long beingId, Long armyUnitId) {
		ArmyUnit armyUnit = armyUnitDao.findById(armyUnitId).orElseThrow();
		if (armyUnit.getBeing() !=null && !armyUnit.getBeing().getBeingId().equals(beingId)) {
			throw new IllegalArgumentException("Army Unit not found with this Army Unit and/or Being ID.");
		}
		return armyUnit;
	}

}













