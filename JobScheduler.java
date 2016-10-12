import java.util.ArrayList;

public abstract class JobScheduler {

  SchedulingAlgorithm algorithm;
  ArrayList<Job> jobList;

  abstract void process();

  public double calculateAvgTurnaroundTime() {
    int turnaroundSum = 0;
    for (Job job : jobList)
      turnaroundSum += job.getTurnaroundTime();

    return turnaroundSum / jobList.size();
  }

}