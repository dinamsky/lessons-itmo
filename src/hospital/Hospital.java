package hospital;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    String hospitalName;
    List<Doctor> doctorList = new ArrayList<Doctor>();
    List<Patient> patientList = new ArrayList<Patient>();

    void addDoctor(Doctor o){
        doctorList.add(o);
    }
    void addPatient(Patient o){
        patientList.add(o);
    }
    public List<Doctor> showDoctors(){
        return doctorList;
    }
    public List<Patient> showPatients(){
        return patientList;
    }

    @Override
    public String toString() {
        return hospitalName;
    }

    public void assignDoctor()
    { for (Patient x: patientList)
    {for (Doctor y: doctorList){

    }
    }


}}
