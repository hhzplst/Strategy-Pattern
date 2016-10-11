import java.util.ArrayList;

public class RRScheduler extends JobScheduler {

  public RRScheduler() {
    algorithm = new RR();
  }

  public void process(ArrayList<Job> job) {
    turnaroundTime = algorithm.run(job);
  }
  
}