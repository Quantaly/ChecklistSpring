package kpage.chklists.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kpage.chklists.pojos.Checklist;
import kpage.chklists.repos.ChecklistRepository;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {
	
	@Autowired
	private ChecklistRepository chkrepo;
	
	@GetMapping(path="/all")
	public Iterable<Checklist> getChecklist() {
		return chkrepo.findAll();
	}
	
	@PostMapping(path="/create")
	public Checklist createChecklist(@RequestBody Checklist chklist) {
		chkrepo.save(chklist);
		return chklist;
	}
}
