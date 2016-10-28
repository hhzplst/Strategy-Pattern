import java.util.ArrayList;

public class SJF implements SchedulingAlgorithm {

  public void run(ArrayList<Job> jobList) {
    int index = 0, wt = 0;
    minHeapify(jobList);
    for (Job job : jobList) {
      index = jobList.indexOf(job);
      for (int i = 0; i < index; i++)
        wt += jobList.get(i).getProcessingTime();
      job.setWaitingTime(wt);
    }
  }

  private void minHeapify(ArrayList<Job> jobList) {
    for (int i = 0; i < jobList.size(); i++) {
      if (2*i + 1 >= jobList.size()) break;
      else if (2*i + 2 >= jobList.size()) {
        if (jobList.get(i).getProcessingTime() > jobList.get(2*i + 1).getProcessingTime())
          swap(jobList, i, 2*i + 1);
      }else{
         if (jobList.get(i).getProcessingTime() > jobList.get(2*i + 1).getProcessingTime() 
                        || jobList.get(i).getProcessingTime() > jobList.get(2*1 + 2).getProcessingTime()) {
            if (jobList.get(2*i + 1).getProcessingTime() >= jobList.get(2*i + 2).getProcessingTime())
              swap(jobList, i, 2*i + 2);
            else
              swap(jobList, i, 2*i + 1); 
         } 
      }
    }            
  }

  private void swap(ArrayList<Job> jobList, int posA, int posB) {
    Job tempJob = jobList.get(posA);
    jobList.set(posA, jobList.get(posB));
    jobList.set(posB, tempJob);
  }
  
}