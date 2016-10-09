import java.util.Random;

public class JobSchedulerSimulator {

  final static int JOB_NUM = 100;
  final static int MAX_PROCESS_TIME = 100;
  final static int MIN_PROCESS_TIME = 0;

  public static void main(String[] args) {

    double FIFOAverageTurnaround, SJFAverageTurnaround, RRAverageTurnaround;
    int FIFOTurnaroundSum = 0, SJFTurnaroundSum = 0, RRTurnaroundSum = 0;

    Job[] jobList = createJobList(JOB_NUM, MAX_PROCESS_TIME, MIN_PROCESS_TIME);

    FIFOScheduler myFIFOScheduler = new FIFOScheduler();
    SJFScheduler mySJFScheduler = new SJFScheduler();
    RRScheduler myRRScheduler = new RRScheduler();

    for (int i = 0; i < JOB_NUM; i++) {
      myFIFOScheduler.process(jobList[i]);
      FIFOTurnaroundSum += myFIFOScheduler.getTurnaroundTime();

      mySJFScheduler.process(jobList[i]);
      SJFTurnaroundSum += mySJFScheduler.getTurnaroundTime();

      myRRScheduler.process(jobList[i]);
      RRTurnaroundSum += myRRScheduler.getTurnaroundTime();
    }

    FIFOAverageTurnaround= FIFOTurnaroundSum / JOB_NUM;
    SJFAverageTurnaround = SJFTurnaroundSum / JOB_NUM;
    RRAverageTurnaround = RRTurnaroundSum / JOB_NUM;

    System.out.printf("Average Turnaround Time:\n%d\n%d\n%d", 
                          FIFOAverageTurnaround, SJFAverageTurnaround, RRAverageTurnaround);

  }

  private static Job[] createJobList(int jobNumber, int maxProcessTime, int minProcessTime) {

    Random generator = new Random();
    int tempProcessingTime;

    Job[] jobList = new Job[jobNumber];

    for (int i = 0; i < jobNumber; i++) {
      tempProcessingTime = generator.nextInt(maxProcessTime - minProcessTime + 1) + minProcessTime;
      jobList[i] = new Job(tempProcessingTime);
    }

    return jobList;
  }

}