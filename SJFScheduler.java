import java.util.ArrayList;

public class SJFScheduler extends JobScheduler {

  public SJFScheduler(ArrayList<Job> jobList) {
    this.jobList = jobList;
    algorithm = new SJF();
  }

  public void process() {
    for (Job job : this.jobList)
      algorithm.run(this.jobList, job);
  }
  
}