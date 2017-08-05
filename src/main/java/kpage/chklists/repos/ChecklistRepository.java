package kpage.chklists.repos;

import org.springframework.data.repository.CrudRepository;

import kpage.chklists.pojos.Checklist;

public interface ChecklistRepository extends CrudRepository<Checklist, Integer> {

}
