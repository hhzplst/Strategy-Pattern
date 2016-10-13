import java.util.ArrayList;

public class SJFScheduler extends JobScheduler {

  public SJFScheduler(ArrayList<Job> jobList) {
    this.jobList = jobList;
    minHeapify(jobList);
    algorithm = new SJF();
  }

  public void process() {
    for (Job job : jobList)
      algorithm.run(jobList, job);
  }

  private void minHeapify(ArrayList<Job> jobList) {
    for (int i = 0; i < jobList.size(); i++) {
      if (2*i + 1 >= jobList.size()) break;
      else if (2*i + 2 >= jobList.size()) {
        if (jobList.get(i).getProcessingTime() > jobList.get(2*i + 1).getProcessingTime())
          swap(i, 2*i + 1);
      }else{
         if (jobList.get(i).getProcessingTime() > jobList.get(2*i + 1).getProcessingTime() 
                        || jobList.get(i).getProcessingTime() > jobList.get(2*1 + 2).getProcessingTime()) {
            if (jobList.get(2*i + 1).getProcessingTime() >= jobList.get(2*i + 2).getProcessingTime())
              swap(i, 2*i + 2);
            else
              swap(i, 2*i + 1); 
         } 
      }
    }            
  }

  private void swap(int posA, int posB) {
    Job tempJob = jobList.get(posA);
    jobList.set(posA, jobList.get(posB));
    jobList.set(posB, tempJob);
  }
  
}