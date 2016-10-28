import java.util.ArrayList;

public class FIFO implements SchedulingAlgorithm {

  public void run(ArrayList<Job> jobList) {
    int index = 0, wt = 0;
    for (Job job : this.jobList) {
      index = jobList.indexOf(job);
      for (int i = 0; i < index; i++)
        wt += jobList.get(i).getProcessingTime();
      job.setWaitingTime(wt);
    }
  }
}