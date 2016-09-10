package perfectjavaee.chapter13;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MessageService {

  @PersistenceContext
  EntityManager entityManager;

  public Message create(String message) {
    Message entity = new Message();
    entity.setMessage(message);
    entityManager.persist(entity);
    return entity;
  }

  public List<Message> findAll() {
    return entityManager
      .createQuery("SELECT x FROM  Message x", Message.class)
      .getResultList();
  }

}
