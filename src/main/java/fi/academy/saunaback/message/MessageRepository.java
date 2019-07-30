package fi.academy.saunaback.message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository extends CrudRepository<Message, Integer> {

//    getti ja posti
}
