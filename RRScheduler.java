import java.util.ArrayList;

public class RRScheduler extends JobScheduler {

  public RRScheduler(ArrayList<Job> jobList) {
    this.jobList = jobList;
    algorithm = new RR();
  }

  public void process() {
    for (Job job : this.jobList)
      algorithm.run(this.jobList, job);
  }
  
}