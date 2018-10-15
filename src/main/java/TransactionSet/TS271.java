package TransactionSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TS271 {
    private Date date = new Date();
    private DateFormat ISAdateFormat = new SimpleDateFormat("yyMMdd");
    private DateFormat GSdateFormat = new SimpleDateFormat("yyyyMMdd");

    private String ISA = "ISA*00*          *00*          *ZZ*RM1P           *ZZ*NCTRACKSBAT    *" + ISAdateFormat.format(date) + "*1432*^*00501*000001333*1*P*:~";
    private String GS = "GS*HS*RM1P*NCTRACKSBAT*"+ GSdateFormat.format(date) +"*1432*13*X*005010X279A1~";

    private String ST;
    private String BHT;
    private String HL1 = "HL*1**20*1~";
    private String HL2 = "HL*2*1*21*1~";
    private String HL3 = "HL*3*2*22*0~";
    private String NM1 = "NM1*PR*2*NCTRACKS*****PI*NCTRACKS~";
    private String NM2;
    private String NM3 = "NM1*IL*1~";
    private String TRN;
    private String REF;
    private String DMG;
    private String DTP;
    private String EQ = "EQ*30~";
    private String SE;

    public String getNM3() {
        return NM3;
    }

    public void setNM3(String NM3) {
        this.NM3 = NM3;
    }

    public String getHL3() {
        return HL3;
    }

    public void setHL3(String HL3) {
        this.HL3 = HL3;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getBHT() {
        return BHT;
    }

    public void setBHT(String BHT) {
        this.BHT = BHT;
    }

    public String getHL1() {
        return HL1;
    }

    public void setHL1(String HL1) {
        this.HL1 = HL1;
    }

    public String getHL2() {
        return HL2;
    }

    public void setHL2(String HL2) {
        this.HL2 = HL2;
    }

    public String getNM1() {
        return NM1;
    }

    public void setNM1(String NM1) {
        this.NM1 = NM1;
    }

    public String getNM2() {
        return NM2;
    }

    public void setNM2(String NM2) {
        this.NM2 = NM2;
    }

    public String getTRN() {
        return TRN;
    }

    public void setTRN(String TRN) {
        this.TRN = TRN;
    }

    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getDMG() {
        return DMG;
    }

    public void setDMG(String DMG) {
        this.DMG = DMG;
    }

    public String getDTP() {
        return DTP;
    }

    public void setDTP(String DTP) {
        this.DTP = DTP;
    }

    public String getSE() {
        return SE;
    }

    public void setSE(String SE) {
        this.SE = SE;
    }

    public String getEQ() {
        return EQ;
    }

    public void setEQ(String EQ) {
        this.EQ = EQ;
    }
    public String getISA() {
        return ISA;
    }

    public String getGS() {
        return GS;
    }
}
