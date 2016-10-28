import java.util.Random;
import java.util.ArrayList;

public class JobSchedulerSimulator {

  final static int JOB_NUM = 500;
  final static int MAX_PROCESS_TIME = 100;
  final static int MIN_PROCESS_TIME = 0;

  public static void main(String[] args) {

    double FIFOAverageTurnaround = 0, SJFAverageTurnaround = 0, RRAverageTurnaround = 0;

    ArrayList<Job> jobList = createJobList(JOB_NUM, MAX_PROCESS_TIME, MIN_PROCESS_TIME);

    JobScheduler myFIFOScheduler = new JobScheduler(new FIFO(), jobList);
    myFIFOScheduler.process();
    FIFOAverageTurnaround = myFIFOScheduler.calculateAvgTurnaroundTime();

    JobScheduler mySJFScheduler = new JobScheduler(new SJF(), jobList);
    mySJFScheduler.process();
    SJFAverageTurnaround = mySJFScheduler.calculateAvgTurnaroundTime();

    JobScheduler myRRScheduler = new JobScheduler(new RR(), jobList);
    myRRScheduler.process();
    RRAverageTurnaround =  myRRScheduler.calculateAvgTurnaroundTime();    


    System.out.printf("Average Turnaround Time:\n" +
                       "FIFO: %.2f units\n" +
                       "SJF: %.2f  units\n" +
                       "RR: %.2f units\n", 
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