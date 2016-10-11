import java.util.ArrayList;

public class FIFOScheduler extends JobScheduler {

  public FIFOScheduler() {
    algorithm = new FIFO();
  }

  public void process(ArrayList<Job> jobList) {
    turnaroundTime = algorithm.run(jobList);
  }

}