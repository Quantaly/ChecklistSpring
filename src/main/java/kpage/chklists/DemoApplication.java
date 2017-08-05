package kpage.chklists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kpage.chklists.pojos.Checklist;
import kpage.chklists.pojos.ChecklistItem;
import kpage.chklists.repos.ChecklistRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Bean
	CommandLineRunner startup() {
		return args -> {
			Checklist chklist = new Checklist();
			chklist.getItems().add(new ChecklistItem(false, "stuff"));
			chklist.getItems().add(new ChecklistItem(true, "moerstuff"));
			chklist.getItems().add(new ChecklistItem(false, "evenmoerastuff", "with some dadnk ndotse"));
			chkrepo.save(chklist);
		};
	}
	
	@Autowired
	private ChecklistRepository chkrepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
