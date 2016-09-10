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

  public Message findById(Long id) {
    return entityManager.find(Message.class, id);
  }

  public List<Message> findByMessage(String message) {
    return entityManager
      .createQuery("SELECT x FROM Message x WHERE x.message LIKE :message", Message.class)
      .setParameter("message", "%" + message + "%")
      .getResultList();
  }

}
