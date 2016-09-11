package perfectjavaee.chapter14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "anual_reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnualReview implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer year;

  private Integer quarter;

  @Enumerated(EnumType.STRING)
  private Rank rank;

}
