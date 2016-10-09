public class FIFOScheduler extends JobScheduler {

  public FIFOScheduler() {
    algorithm = new FIFO();
  }

  public void process(Job job) {
    turnaroundTime = algorithm.run(job);
  }

}