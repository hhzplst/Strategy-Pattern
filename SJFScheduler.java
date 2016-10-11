import java.util.ArrayList;

public class SJFScheduler extends JobScheduler {

  public SJFScheduler() {
    algorithm = new SJF();
  }

  public void process(ArrayList<Job> job) {
    turnaroundTime = algorithm.run(job);
  }
  
}