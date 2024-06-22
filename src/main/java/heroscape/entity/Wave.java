package heroscape.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
public class Wave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long waveId;
	
	private String waveName;
	private String copyrightYear;
	private String version;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "waves")
	private Set<ArmyUnit> armyUnits = new HashSet <>();
}
