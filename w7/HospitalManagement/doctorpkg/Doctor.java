package doctorpkg;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private int patientCount; // tracks how many patients assigned

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patientCount = 0;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void addPatient() {
        patientCount++;
    }

    public double getTotalFeeCollected() {
        return consultationFee * patientCount;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void displayDoctorDetails() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: Dr. " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: Rs." + consultationFee);
    }
}
