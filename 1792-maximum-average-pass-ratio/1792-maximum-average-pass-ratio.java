import java.util.PriorityQueue;

class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes based on the gain of adding one student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // Initialize the heap with initial gains
        for (int[] cls : classes) {
            int p = cls[0], t = cls[1];
            double initialGain = calculateGain(p, t);
            maxHeap.offer(new double[]{initialGain, p, t});
        }

        // Distribute extra students
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int p = (int) top[1];
            int t = (int) top[2];

            // Update class with one extra student
            p++;
            t++;
            extraStudents--;

            // Recalculate the gain and add back to the heap
            maxHeap.offer(new double[]{calculateGain(p, t), p, t});
        }

        // Calculate the total average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] cls = maxHeap.poll();
            int p = (int) cls[1];
            int t = (int) cls[2];
            totalPassRatio += (double) p / t;
        }

        return totalPassRatio / classes.length;
    }

    // Function to calculate the gain of adding one extra student
    private double calculateGain(int p, int t) {
        return ((double) (p + 1) / (t + 1)) - ((double) p / t);
    }
}
