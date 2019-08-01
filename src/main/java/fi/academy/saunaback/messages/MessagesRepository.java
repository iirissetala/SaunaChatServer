package fi.academy.saunaback.messages;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**  Repositoria, jonka avulla saadaan käyttöön valmiit metodit. Iiris */
@RepositoryRestResource
public interface MessagesRepository extends CrudRepository<Messages, Long> {



}
