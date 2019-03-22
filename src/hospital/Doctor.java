package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor {
    private String doctorName;
    private String doctorSpeciality;
    List<Patient> doctorPatientlist = new ArrayList<Patient>();
    Date doctorDate;

    public Doctor(String doctorName, String doctorSpeciality) {
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
    }
    public String getDoctorName(){
        return doctorName;
    }
    public List<Patient> getDoctorPatientlist(){
        return doctorPatientlist;
    }
    public void addPatientsToDoctor(Patient o){
        doctorPatientlist.add(o);
    }
    String getDoctorSpeciality(){
        return doctorSpeciality;
    }
    void showDoctorPatientList(){};

    public Date getDoctorDate(Doctor o){
      return doctorDate;
    };

    @Override
    public String toString(){
        return(doctorName+" "+doctorSpeciality+" "+ doctorPatientlist);
    }
}
