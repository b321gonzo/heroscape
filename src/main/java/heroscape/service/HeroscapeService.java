package heroscape.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import heroscape.controller.model.BeingData;
import heroscape.controller.model.BeingData.ArmyUnitData;
import heroscape.controller.model.BeingData.WaveData;
import heroscape.dao.ArmyUnitDao;
import heroscape.dao.BeingDao;
import heroscape.dao.WaveDao;
import heroscape.entity.ArmyUnit;
import heroscape.entity.Being;
import heroscape.entity.Wave;

@Service
public class HeroscapeService {
	
	
	//Being methods
	
	@Autowired
	private BeingDao beingDao;	

	@Autowired
	private ArmyUnitDao armyUnitDao;
	
	@Autowired WaveDao waveDao;
	
	
	@Transactional(readOnly = false)
	public BeingData saveBeing(BeingData beingData) {
		Long beingId = beingData.getBeingId();
		Being being = findOrCreateBeing(beingId);
		
		copyBeingFields(being, beingData);
		
		return new BeingData(beingDao.save(being));
	}
	
	private void copyBeingFields(Being being, BeingData beingData) {
		being.setBeingId(beingData.getBeingId());
		being.setName(beingData.getName());
		being.setOrigin(beingData.getOrigin());
	}

	private Being findOrCreateBeing(Long beingId) {
		if (beingId == null) {
			return new Being();
		} else {
			return findBeingById(beingId);
		}
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

	
//Army Unit
	
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
	
	private ArmyUnit findArmyUnitByIdByWave(Long armyUnitId) {
		ArmyUnit armyUnit = armyUnitDao.findById(armyUnitId).orElseThrow(()-> new NoSuchElementException("Army Unit with this ID not found."));
		return armyUnit;
	}
	
//Wave
	
	@Transactional(readOnly = false)
	public WaveData saveWave(WaveData waveData) {
		Long waveId = waveData.getWaveId();
		Wave wave = findOrCreateWave(waveId);
		
		copyWaveFields(wave, waveData);
		
		return new WaveData(waveDao.save(wave));
	}
	
	private void copyWaveFields(Wave wave, WaveData waveData) {
		wave.setWaveId(waveData.getWaveId());
		wave.setWaveName(waveData.getWaveName());
		wave.setCopyrightYear(waveData.getCopyrightYear());
		wave.setVersion(waveData.getVersion());
	}

	private Wave findOrCreateWave(Long waveId) {
		if (waveId == null) {
			return new Wave();
		} else {
			return findWaveById(waveId);
		}
	}

	@Transactional(readOnly = true)
	public WaveData retrieveWaveById(Long waveId) {
		Wave wave = findWaveById(waveId);
		return new WaveData(wave);
	}

	private Wave findWaveById(Long waveId) {
		return waveDao.findById(waveId).orElseThrow(() -> new NoSuchElementException("Wave with ID=" + waveId + " was not found."));
	}

	@Transactional(readOnly = false)
	public void deleteWave(Long waveId) {
		Wave wave = findWaveById(waveId);
		waveDao.delete(wave);
	}
	
	
	
	@Transactional(readOnly = false)
	public ArmyUnitData saveArmyUnitWithWave(Long waveId, Long armyUnitId) {
        
		Wave wave = findWaveById(waveId);
        ArmyUnit armyUnit = findArmyUnitByIdByWave(armyUnitId);

        armyUnit.getWaves().add(wave);
        wave.getArmyUnits().add(armyUnit); 

        armyUnit = armyUnitDao.save(armyUnit);
        
        return new ArmyUnitData(armyUnit);
    }
	
	
	
}













