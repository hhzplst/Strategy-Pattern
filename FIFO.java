import java.util.ArrayList;

public class FIFO implements SchedulingAlgorithm {

  public void run(ArrayList<Job> jobList, Job job) {
    int index = jobList.indexOf(job);
    int wt = 0;
    for (int i = 0; i < index; i++)
      wt += jobList.get(i).getProcessingTime();
    job.setWaitingTime(wt);
  }

}