import java.util.ArrayList;

public class RR implements SchedulingAlgorithm {

  final int TIME_SLICE = 20;

  public void run(ArrayList<Job> jobList, Job job) {
    
    int index = jobList.indexOf(job);
    int currentPt = job.getProcessingTime();
    int tempWt = 0;

    if (currentPt > 0) {
      if (currentPt > 20)
        job.setProcessingTime(currentPt - 20);
      else
        job.setProcessingTime(0);  

      for (int i = 0; i < jobList.size(); i++) {
        if (i != index && jobList.get(i).getProcessingTime() != 0) {
            tempWt = jobList.get(i).getWaitingTime();
            jobList.get(i).setWaitingTime(tempWt + TIME_SLICE);
        }
      }
    }
  }

}