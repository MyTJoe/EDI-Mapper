import com.opencsv.bean.CsvBindByName;

public class Data {

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

    private int serviceDate;

    public Data() {
    }

    public Data(int provider, int patientSSN, int dateOfBirth, int admissionDate, int dischargeDate, int serviceDate) {
        this.provider = provider;
        this.patientSSN = patientSSN;
        this.dateOfBirth = dateOfBirth;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.serviceDate = serviceDate;
    }

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

    public int getServiceDate() {
        return serviceDate;
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

    public void setServiceDate(int serviceDate) {
        this.serviceDate = serviceDate;
    }
}
