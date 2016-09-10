package perfectjavaee.chapter13;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;

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
