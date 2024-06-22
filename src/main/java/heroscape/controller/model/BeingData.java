package heroscape.controller.model;

import java.util.HashSet;
import java.util.Set;

import heroscape.entity.ArmyUnit;
import heroscape.entity.Being;
import heroscape.entity.Wave;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeingData {
	private Long beingId;

	private String name;
	private String origin;

	private Set<ArmyUnitData> armyUnits = new HashSet<>();

	public BeingData(Being being) {
		this.beingId = being.getBeingId();
		this.name = being.getName();
		this.origin = being.getOrigin();

		for (ArmyUnit armyUnit : being.getArmyUnits()) {
			this.armyUnits.add(new ArmyUnitData(armyUnit));
		}
	}

	public BeingData(Long beingId, String name, String origin) {
		this.beingId = beingId;
		this.name = name;
		this.origin = origin;
	}

	public Being toBeing() {
		Being being = new Being();

		being.setBeingId(beingId);
		being.setName(name);
		being.setOrigin(origin);

		for (ArmyUnitData armyUnitData : armyUnits) {
			being.getArmyUnits().add(armyUnitData.toArmyUnit());
		}

		return being;
	}

	@Data
	@NoArgsConstructor
	public static class ArmyUnitData {
		private Long armyUnitId;
		private String valkyrieGeneral;
		private Long basicMove;
		private Long basicRange;
		private Long basicAttack;
		private Long basicDefense;
		private Set<WaveData> waves = new HashSet<>();

		public ArmyUnitData(ArmyUnit armyUnit) {
			this.armyUnitId = armyUnit.getArmyUnitId();
			this.valkyrieGeneral = armyUnit.getValkyrieGeneral();
			this.basicMove = armyUnit.getBasicMove();
			this.basicRange = armyUnit.getBasicRange();
			this.basicAttack = armyUnit.getBasicAttack();
			this.basicDefense = armyUnit.getBasicDefense();

			for (Wave wave : armyUnit.getWaves()) {
				this.waves.add(new WaveData(wave));
			}
		}

		public ArmyUnit toArmyUnit() {
			ArmyUnit armyUnit = new ArmyUnit();

			armyUnit.setArmyUnitId(armyUnitId);
			armyUnit.setValkyrieGeneral(valkyrieGeneral);
			armyUnit.setBasicMove(basicMove);
			armyUnit.setBasicRange(basicRange);
			armyUnit.setBasicAttack(basicAttack);
			armyUnit.setBasicDefense(basicDefense);

			for (WaveData waveData : waves) {
				armyUnit.getWaves().add(waveData.toWave());
			}

			return armyUnit;
		}
	}

	@Data
	@NoArgsConstructor
	public static class WaveData {
		private Long waveId;
		private String waveName;
		private String copyrightYear;
		private String version;

		public WaveData(Wave wave) {
			this.waveId = wave.getWaveId();
			this.waveName = wave.getWaveName();
			this.copyrightYear = wave.getCopyrightYear();
			this.version = wave.getVersion();
		}

		public Wave toWave() {
			Wave wave = new Wave();

			wave.setWaveId(waveId);
			wave.setWaveName(waveName);
			wave.setCopyrightYear(copyrightYear);
			wave.setVersion(version);

			return wave;
		}
	}

}
