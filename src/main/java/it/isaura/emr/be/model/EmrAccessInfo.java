package it.isaura.emr.be.model;

import java.util.Date;

/**
 * Created by pasquale on 03/07/2016.
 */
public class EmrAccessInfo {


    private Date accessDate = null;
    private String comune = null;
    private String codice = null;
    private String asl = null;
    private Integer bianchi=null;
    private Integer trattamentoBianchi=null;
    private Integer trattamentoGialli=null;
    private Integer trattamentoVerdi=null;
    private Integer trattamentoRossi=null;
    private Integer attesaBianchi=null;
    private Integer attesaGialli=null;
    private Integer attesaVerdi=null;
    private Integer attesaRossi=null;
    private Integer obiBianchi=null;
    private Integer obiGialli=null;
    private Integer obiVerdi=null;
    private Integer obiRossi=null;
    private Integer nonEseguiti=null;


    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getAsl() {
        return asl;
    }

    public void setAsl(String asl) {
        this.asl = asl;
    }

    public Integer getBianchi() {
        return bianchi;
    }

    public void setBianchi(Integer bianchi) {
        this.bianchi = bianchi;
    }

    public Integer getTrattamentoBianchi() {
        return trattamentoBianchi;
    }

    public void setTrattamentoBianchi(Integer trattamentoBianchi) {
        this.trattamentoBianchi = trattamentoBianchi;
    }

    public Integer getTrattamentoGialli() {
        return trattamentoGialli;
    }

    public void setTrattamentoGialli(Integer trattamentoGialli) {
        this.trattamentoGialli = trattamentoGialli;
    }

    public Integer getTrattamentoVerdi() {
        return trattamentoVerdi;
    }

    public void setTrattamentoVerdi(Integer trattamentoVerdi) {
        this.trattamentoVerdi = trattamentoVerdi;
    }

    public Integer getTrattamentoRossi() {
        return trattamentoRossi;
    }

    public void setTrattamentoRossi(Integer trattamentoRossi) {
        this.trattamentoRossi = trattamentoRossi;
    }

    public Integer getAttesaBianchi() {
        return attesaBianchi;
    }

    public void setAttesaBianchi(Integer attesaBianchi) {
        this.attesaBianchi = attesaBianchi;
    }

    public Integer getAttesaGialli() {
        return attesaGialli;
    }

    public void setAttesaGialli(Integer attesaGialli) {
        this.attesaGialli = attesaGialli;
    }

    public Integer getAttesaVerdi() {
        return attesaVerdi;
    }

    public void setAttesaVerdi(Integer attesaVerdi) {
        this.attesaVerdi = attesaVerdi;
    }

    public Integer getAttesaRossi() {
        return attesaRossi;
    }

    public void setAttesaRossi(Integer attesaRossi) {
        this.attesaRossi = attesaRossi;
    }

    public Integer getObiBianchi() {
        return obiBianchi;
    }

    public void setObiBianchi(Integer obiBianchi) {
        this.obiBianchi = obiBianchi;
    }

    public Integer getObiGialli() {
        return obiGialli;
    }

    public void setObiGialli(Integer obiGialli) {
        this.obiGialli = obiGialli;
    }

    public Integer getObiVerdi() {
        return obiVerdi;
    }

    public void setObiVerdi(Integer obiVerdi) {
        this.obiVerdi = obiVerdi;
    }

    public Integer getObiRossi() {
        return obiRossi;
    }

    public void setObiRossi(Integer obiRossi) {
        this.obiRossi = obiRossi;
    }

    public Integer getNonEseguiti() {
        return nonEseguiti;
    }

    public void setNonEseguiti(Integer nonEseguiti) {
        this.nonEseguiti = nonEseguiti;
    }

    @Override
    public String toString() {
        return "EmrAccessInfo{" +
                "accessDate=" + accessDate +
                ", comune='" + comune + '\'' +
                ", codice='" + codice + '\'' +
                ", asl='" + asl + '\'' +
                ", bianchi=" + bianchi +
                ", trattamentoBianchi=" + trattamentoBianchi +
                ", trattamentoGialli=" + trattamentoGialli +
                ", trattamentoVerdi=" + trattamentoVerdi +
                ", trattamentoRossi=" + trattamentoRossi +
                ", attesaBianchi=" + attesaBianchi +
                ", attesaGialli=" + attesaGialli +
                ", attesaVerdi=" + attesaVerdi +
                ", attesaRossi=" + attesaRossi +
                ", obiBianchi=" + obiBianchi +
                ", obiGialli=" + obiGialli +
                ", obiVerdi=" + obiVerdi +
                ", obiRossi=" + obiRossi +
                ", nonEseguiti=" + nonEseguiti +
                '}';
    }
}
