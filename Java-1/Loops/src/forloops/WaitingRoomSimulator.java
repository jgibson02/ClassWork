package forloops;

/**
 * A doctor decides to experiment with the idea of not scheduling patients -- she just
 * lets them show up whenever they want and wait in FCFS order.
 * 
 * We assume that each patient needs exactly 15 minutes with the doctor. The simulation
 * lasts for 180 minutes. The question to be answered is: how many people should the
 * doctor expect to be waiting after this 3-hour block of time expires?
 * 
 * @author John Gibson}
 */
public class WaitingRoomSimulator {

    public static void main(String[] args) {
        // Repeat the experiment this many times
        final int NUM_TRIALS = 100_000;
        
        // The total number of patients waiting at the end of all trials
        int total = 0;
        
        for (int i = 0; i < NUM_TRIALS; i++) {
            total += doExperiment();
        }
        
        double average = (double) total / NUM_TRIALS;
        System.out.println("Number of patients waiting on average: " + average);
    }
    
    /**
     * Simulate the waiting room for three hours.
     * @return the number of patients waiting at the end
     */
    private static int doExperiment() {
        // probability that a patient arrives in any given minute
        double arrivalProb = 0.075;
        
        int visitTime = 15; // each patient needs 15 minutes/visit
                
        // at opening time...
        boolean doctorBusy = false;
        int numberPatientsWaiting = 0;
        
        // Each iteration of loop represents 1 minute
        final int TOTAL_MINUTES = 180;
        
        int timePatientArrived = -1; // Initial value not used
        
        for (int currentMin = 0; currentMin < TOTAL_MINUTES; currentMin++) {
            
            // Is a new patient arriving?
            if (Math.random() < arrivalProb) {
                numberPatientsWaiting++;
            }
            
            // If doctor is not busy and has patient(s) waiting...
            if (!doctorBusy && numberPatientsWaiting > 0) {
                numberPatientsWaiting--;
                timePatientArrived = currentMin;
                doctorBusy = true;
            }
            // If doctor is busy and current patient is done...
            if (doctorBusy && currentMin == timePatientArrived + visitTime) {
                doctorBusy = false;
            }
        }
        return numberPatientsWaiting;
    }
}