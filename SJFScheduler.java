public class SJFScheduler extends JobScheduler {

  public SJFScheduler() {
    algorithm = new SJF();
  }

  public void process(Job job) {
    turnaroundTime = algorithm.run(job);
  }
  
}