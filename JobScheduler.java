public abstract class JobScheduler {

  protected int turnaroundTime;
  SchedulingAlgorithm algorithm;
  
  public int getTurnaroundTime() {
    return turnaroundTime;
  }

  abstract void process(Job job);

}