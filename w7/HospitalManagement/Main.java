import doctorpkg.Doctor;
import patientpkg.Patient;

public class Main {

    // Maps a disease to the required specialization
    public static String getRequiredSpecialization(String disease) {
        switch (disease.toLowerCase()) {
            case "heart pain":
            case "hypertension":
                return "Cardiology";
            case "fracture":
            case "joint pain":
                return "Orthopedics";
            case "fever":
            case "cold":
                return "General Medicine";
            default:
                return "General Medicine";
        }
    }

    public static void main(String[] args) {
        // Create doctors
        Doctor[] doctors = new Doctor[2];
        doctors[0] = new Doctor(1, "Suresh", "Cardiology", 800);
        doctors[1] = new Doctor(2, "Meena", "Orthopedics", 600);

        // Create patients
        Patient[] patients = new Patient[3];
        patients[0] = new Patient(101, "Ravi", "Heart Pain", 45);
        patients[1] = new Patient(102, "Priya", "Fracture", 30);
        patients[2] = new Patient(103, "Kiran", "Hypertension", 50);

        System.out.println("===== Patient Assignment =====\n");

        for (Patient p : patients) {
            String requiredSpec = getRequiredSpecialization(p.getDisease());
            Doctor assignedDoctor = null;

            // Find a doctor matching the required specialization
            for (Doctor d : doctors) {
                if (d.getSpecialization().equalsIgnoreCase(requiredSpec)) {
                    assignedDoctor = d;
                    break;
                }
            }

            if (assignedDoctor != null) {
                assignedDoctor.addPatient();
                p.displayPatientDetails();
                System.out.println("--- Treated By ---");
                assignedDoctor.displayDoctorDetails();
            } else {
                p.displayPatientDetails();
                System.out.println("No matching doctor found.");
            }
            System.out.println("--------------------------------");
        }

        System.out.println("\n===== Total Consultation Fee Collected =====");
        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getName() + " (" + d.getSpecialization() + "): "
                    + d.getPatientCount() + " patients, Total Fee: Rs." + d.getTotalFeeCollected());
        }
    }
}
