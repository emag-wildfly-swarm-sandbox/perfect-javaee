package perfectjavaee.chapter14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private Name name;

  @OneToOne
  @JoinColumn(name = "travel_profile_id")
  private TravelProfile profile;

  @OneToOne
  private Cubicle cubicle;

  @ManyToOne
  @JoinColumn(name = "addr", referencedColumnName = "addr_id")
  private Address address;

  @OneToMany
  @JoinTable(
    name = "emp_reviews",
    joinColumns = @JoinColumn(name = "emp", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "review", referencedColumnName = "id")
  )
  private List<AnnualReview> annualReviews;

  @ManyToOne
  private Department department;

  @ManyToMany
  @JoinTable(
    name = "emp_patents",
    joinColumns = @JoinColumn(name = "emp", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "patent", referencedColumnName = "id")
  )
  private List<Patent> patents;

  @ManyToMany(mappedBy = "employees")
  private List<Project> projects;

}
