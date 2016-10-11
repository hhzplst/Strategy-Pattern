import java.util.Random;
import java.util.ArrayList;

public class JobSchedulerSimulator {

  final static int JOB_NUM = 100;
  final static int MAX_PROCESS_TIME = 100;
  final static int MIN_PROCESS_TIME = 0;

  public static void main(String[] args) {

    double FIFOAverageTurnaround, SJFAverageTurnaround, RRAverageTurnaround;

    FIFOScheduler myFIFOScheduler = new FIFOScheduler();
    SJFScheduler mySJFScheduler = new SJFScheduler();
    RRScheduler myRRScheduler = new RRScheduler();

    ArrayList<Job> jobList = createJobList(JOB_NUM, MAX_PROCESS_TIME, MIN_PROCESS_TIME);

    myFIFOScheduler.process(jobList);
    mySJFScheduler.process(jobList);
    myRRScheduler.process(jobList);

    FIFOAverageTurnaround = (double) myFIFOScheduler.getTurnaroundTime() / JOB_NUM;
    SJFAverageTurnaround = (double) mySJFScheduler.getTurnaroundTime() / JOB_NUM;
    RRAverageTurnaround = (double) myRRScheduler.getTurnaroundTime() / JOB_NUM;


    System.out.printf("Average Turnaround Time:\n%d\n%d\n%d", 
                          FIFOAverageTurnaround, SJFAverageTurnaround, RRAverageTurnaround);

  }

  private static ArrayList<Job> createJobList(int jobNumber, int maxProcessTime, int minProcessTime) {

    Random generator = new Random();
    int tempProcessingTime;

    ArrayList<Job> jobList = new ArrayList<Job>(jobNumber);

    for (int i = 0; i < jobNumber; i++) {
      tempProcessingTime = generator.nextInt(maxProcessTime - minProcessTime + 1) + minProcessTime;
      jobList.add(new Job(tempProcessingTime));
    }

    return jobList;
  }

}