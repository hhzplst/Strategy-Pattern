public class Job {

  private int processingTime;
  private int waitingTime;
  private int turnaroundTime;

  public Job(int pt) {
    this.processingTime = pt;
  }

  public int getProcessingTime() {
    return this.processingTime;
  }

  public void setProcessingTime(int pt) {
    this.processingTime = pt;
  }

  public int getWaitingTime() {
    return this.waitingTime;
  }

  public void setWaitingTime(int wt) {
    this.waitingTime = wt;
  }

  private void calculateTurnaroundTime() {
    this.turnaroundTime = this.processingTime + this.waitingTime;
  }

  public int getTurnaroundTime() {
    calculateTurnaroundTime();
    return turnaroundTime;
  }

}