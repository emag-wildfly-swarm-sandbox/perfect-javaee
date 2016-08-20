package perfectjavaee.chapter04.cdi_event;

public class Alert {

  private final long id;
  private final AlertLevel level;
  private final String title;

  public Alert(long id, AlertLevel level, String title) {
    this.id = id;
    this.level = level;
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public AlertLevel getLevel() {
    return level;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return "Alert{" +
      "id=" + id +
      ", level=" + level +
      ", title='" + title + '\'' +
      '}';
  }

}
