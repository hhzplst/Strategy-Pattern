import java.util.ArrayList;

public class RR implements SchedulingAlgorithm {

  final int TIME_SLICE = 20;
  private boolean notDone = true;

  public void run(ArrayList<Job> jobList) {
    int index = 0, currentPt = 0, tempWt = 0;
    
    while (notDone) {
      for (Job job : this.jobList) {
        index = jobList.indexOf(job);
        currentPt = job.getProcessingTime();
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
      notDone = checkIfDone();
    }     
  }

  private boolean checkIfDone() {
    for (Job job : jobList)
      if (job.getProcessingTime() > 0) return true;
    return false;
  }

}