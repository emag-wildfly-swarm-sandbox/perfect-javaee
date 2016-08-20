package perfectjavaee.chapter04.cdi_event;

public class AlertRequest {

  private AlertLevel level;
  private String title;

  public AlertLevel getLevel() {
    return level;
  }

  public void setLevel(AlertLevel level) {
    this.level = level;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
