package heroscape.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import heroscape.controller.model.BeingData;
import heroscape.controller.model.BeingData.ArmyUnitData;
import heroscape.service.HeroscapeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/heroscape")
@Slf4j
public class HeroscapeController {
	@Autowired
	private HeroscapeService heroscapeService;
	
	@PostMapping("/being")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BeingData createBeing(@RequestBody BeingData beingData) {
		log.info("Creating being {}", beingData);
		return heroscapeService.saveBeing(beingData);
	}
	
	@PutMapping("/being/{beingId}")
	public BeingData updateBeing(@PathVariable Long beingId, @RequestBody BeingData beingData) {
		beingData.setBeingId(beingId);
		log.info("Updating being {}", beingData);
		return heroscapeService.saveBeing(beingData);
	}
	
	@GetMapping("/being/{beingId}")
	public BeingData retrieveBeing(@PathVariable Long beingId) {
		log.info("Retrieving being with ID={}", beingId);
		return heroscapeService.retrieveBeingById(beingId);
	}
	
	@DeleteMapping("/being/{beingId}")
	public Map<String, String> deleteBeing(@PathVariable Long beingId) {
		log.info("Deleting being with ID=" + beingId + ".");
		heroscapeService.deleteBeing(beingId);
		
		return Map.of("message", "Being with ID=" + beingId + " was deleted succesffuly.");
	}
	
	
	
	@PostMapping("/being/{beingId}/armyUnit")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ArmyUnitData createArmyUnit(@PathVariable Long beingId, @RequestBody ArmyUnitData armyUnitData) {
		log.info("Creating army unit {}", armyUnitData);
		return heroscapeService.saveArmyUnit(beingId, armyUnitData);
	}
	
	
	
}



