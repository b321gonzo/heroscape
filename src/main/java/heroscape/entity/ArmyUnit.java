package heroscape.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class ArmyUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long armyUnitId;
	
	@EqualsAndHashCode.Exclude
	private String valkyrieGeneral;
	
	@EqualsAndHashCode.Exclude
	private Long basicMove;
	
	@EqualsAndHashCode.Exclude
	private Long basicRange;
	
	@EqualsAndHashCode.Exclude
	private Long basicAttack;
	
	@EqualsAndHashCode.Exclude
	private Long basicDefense;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "being_id", nullable = false)
	private Being being;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "army_unit_wave",
			joinColumns = @JoinColumn(name = "army_unit_id"),
			inverseJoinColumns = @JoinColumn(name = "wave_id")
	)
	private Set<Wave> waves = new HashSet <>();
	
}
