package perfectjavaee.chapter13;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.logging.Logger;

@Entity
@Table(
  name = "messages",
  indexes = {@Index(name = "message_idx", columnList = "message")}
)
public class Message implements Serializable {

  private static final Logger LOGGER = Logger.getLogger(Message.class.getName());

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;

  @PostLoad
  public void postLoad() {
    LOGGER.info(() -> this + " was loaded!");
  }

  @PrePersist
  public void prePersist() {
    LOGGER.info(() -> this + " is persisting...");
  }

  @PostPersist
  public void postPersist() {
    LOGGER.info(() -> this + " was persisted!");
  }

  @PreUpdate
  public void preUpdate() {
    LOGGER.info(() -> this + " is updating...");
  }

  @PostUpdate
  public void postUpdate() {
    LOGGER.info(() -> this + " was updated!");
  }

  @PreRemove
  public void preRemove() {
    LOGGER.info(() -> this + " is removing...");
  }

  @PostRemove
  public void postRemove() {
    LOGGER.info(() -> this + " was removed!");
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Message message1 = (Message) o;

    if (id != null ? !id.equals(message1.id) : message1.id != null) return false;
    return message != null ? message.equals(message1.message) : message1.message == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (message != null ? message.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Message{" +
      "id=" + id +
      ", message='" + message + '\'' +
      '}';
  }

}
