import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    class WorkingThread {
        private int number;
        private long workTakes = 0;

        WorkingThread(int number) {
            this.number = number;
        }

        void setWorkTakes(long workTakes) {
            this.workTakes = workTakes;
        }

        long getWorkTakes() {
            return workTakes;
        }

        int getNumber() {
            return number;
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        PriorityQueue<WorkingThread> priorityQueue =
                new PriorityQueue<>(numWorkers,
                        Comparator.comparing(WorkingThread::getWorkTakes)
                                .thenComparing(WorkingThread::getNumber));

        for (int i = 0; i < numWorkers; ++i) {
            priorityQueue.add(new WorkingThread(i));
        }
        for (int j = 0; j < jobs.length; j++) {
            WorkingThread workingThread = priorityQueue.poll();

            if (workingThread != null) {
                assignedWorker[j] = workingThread.number;
                startTime[j] = workingThread.workTakes;
                workingThread.setWorkTakes(startTime[j] + jobs[j]);
                priorityQueue.add(workingThread);
            }
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
