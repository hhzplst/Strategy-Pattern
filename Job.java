public class Job {

  private int processingTime;

  public Job(int processingTime) {
    this.processingTime = processingTime;
  }

  public int getProcessingTime() {
    return this.processingTime;
  }

  public void setProcessingTime(int newProcessingTime) {
    this.processingTime = newProcessingTime;
  }

}