import java.util.ArrayList;

public class JobScheduler {

  private SchedulingAlgorithm algorithm;
  private ArrayList<Job> jobList;

  public JobScheduler(SchedulingAlgorithm algorithm, ArrayList<Job> jobs) {
    this.algorithm = algorithm;
    this.jobList = jobs;
  }

  public void process(ArrayList<Job> jobList) {
    algorithm.run(jobList);
  }

  public double calculateAvgTurnaroundTime() {
    int turnaroundSum = 0;
    for (Job job : jobList)
      turnaroundSum += job.getTurnaroundTime();

    return turnaroundSum / jobList.size();
  }

}