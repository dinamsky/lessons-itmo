package hospital;

import java.util.Date;

public class Patient {
    private String patientName;
    private int patientAge;
    Doctor patientDoctor;
    Date visitDate;


    public Patient(String patientName, int patientAge) {
        this.patientName = patientName;
        this.patientAge = patientAge;
    }
    public Doctor getPatientDoctor(){
        return patientDoctor;
    }
    void setVisitDate(Doctor o, Date y){
        this.patientDoctor = o;
        this.visitDate = y;
    };

}
