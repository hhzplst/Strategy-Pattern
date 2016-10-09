public class RRScheduler extends JobScheduler {

  public RRScheduler() {
    algorithm = new RR();
  }

  public void process(Job job) {
    turnaroundTime = algorithm.run(job);
  }
  
}