import java.util.ArrayList;

public class FIFOScheduler extends JobScheduler {

  public FIFOScheduler(ArrayList<Job> jobList) {
    this.jobList = jobList;
    algorithm = new FIFO();
  }

  public void process() {
    for (Job job : this.jobList)
      algorithm.run(this.jobList, job);
  }

}