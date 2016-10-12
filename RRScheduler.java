import java.util.ArrayList;

public class RRScheduler extends JobScheduler {

  boolean notDone = true;

  public RRScheduler(ArrayList<Job> jobList) {
    this.jobList = jobList;
    algorithm = new RR();
  }

  public void process() {
    while (notDone) {
      for (Job job : this.jobList)
        algorithm.run(this.jobList, job);
      notDone = checkIfDone();
    }
  }

  private boolean checkIfDone() {
    for (Job job : jobList)
      if (job.getProcessingTime() > 0) return true;
    return false;
  }
  
}