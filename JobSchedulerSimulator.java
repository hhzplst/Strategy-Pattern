import java.util.Random;
import java.util.ArrayList;

public class JobSchedulerSimulator {

  final static int JOB_NUM = 100;
  final static int MAX_PROCESS_TIME = 100;
  final static int MIN_PROCESS_TIME = 0;

  public static void main(String[] args) {

    double FIFOAverageTurnaround, SJFAverageTurnaround, RRAverageTurnaround;

    ArrayList<Job> jobList = createJobList(JOB_NUM, MAX_PROCESS_TIME, MIN_PROCESS_TIME);

    FIFOScheduler myFIFOScheduler = new FIFOScheduler(jobList);
    myFIFOScheduler.process();
    FIFOAverageTurnaround = myFIFOScheduler.calculateAvgTurnaroundTime();

    SJFScheduler mySJFScheduler = new SJFScheduler(jobList);
    mySJFScheduler.process();
    SJFAverageTurnaround = mySJFScheduler.calculateAvgTurnaroundTime();

    RRScheduler myRRScheduler = new RRScheduler(jobList);
    myRRScheduler.process();
    RRAverageTurnaround =  myRRScheduler.calculateAvgTurnaroundTime();    


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