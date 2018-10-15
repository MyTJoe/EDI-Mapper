package Data;

import com.opencsv.bean.CsvBindByName;

public class CSV_Data {

    @CsvBindByName(column = "NPI", required = true)
    private int provider;

    @CsvBindByName(column = "SSN", required = true)
    private int patientSSN;

    @CsvBindByName(column = "PAT_DOB", required = true)
    private int dateOfBirth;

    @CsvBindByName(column = "ADM_DATE_TIME", required = true)
    private int admissionDate;

    @CsvBindByName(column = "DISCH_DATE_TIME", required = true)
    private int dischargeDate;

    public int getProvider() {
        return provider;
    }

    public int getPatientSSN() {
        return patientSSN;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAdmissionDate() {
        return admissionDate;
    }

    public int getDischargeDate() {
        return dischargeDate;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public void setPatientSSN(int patientSSN) {
        this.patientSSN = patientSSN;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdmissionDate(int admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setDischargeDate(int dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
