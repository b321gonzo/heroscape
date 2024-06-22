package heroscape.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Being {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long beingId;
	
	private String name;
	private String origin;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "being")
	private Set<ArmyUnit> armyUnits = new HashSet <>();
}
