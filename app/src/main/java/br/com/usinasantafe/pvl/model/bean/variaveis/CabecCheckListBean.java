package br.com.usinasantafe.pvl.model.bean.variaveis;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pvl.model.pst.Entidade;

@DatabaseTable(tableName="tbcabclvar")
public class CabecCheckListBean extends Entidade {

    @DatabaseField(generatedId=true)
    private Long idCabecCheckList;
    @DatabaseField
    private Long equipCabecCheckList;
    @DatabaseField
    private String dtCabecCheckList;
    @DatabaseField
    private Long funcCabecCheckList;
    @DatabaseField
    private Long turnoCabecCheckList;
    @DatabaseField
    private Long statusCabecCheckList;  //1 - Aberto; 2 - Encerrado

    public CabecCheckListBean() {
    }

    public Long getIdCabecCheckList() {
        return idCabecCheckList;
    }

    public void setIdCabecCheckList(Long idCabecCheckList) {
        this.idCabecCheckList = idCabecCheckList;
    }

    public Long getEquipCabecCheckList() {
        return equipCabecCheckList;
    }

    public void setEquipCabecCheckList(Long equipCabecCheckList) {
        this.equipCabecCheckList = equipCabecCheckList;
    }

    public String getDtCabecCheckList() {
        return dtCabecCheckList;
    }

    public void setDtCabecCheckList(String dtCabecCheckList) {
        this.dtCabecCheckList = dtCabecCheckList;
    }

    public Long getFuncCabecCheckList() {
        return funcCabecCheckList;
    }

    public void setFuncCabecCheckList(Long funcCabecCheckList) {
        this.funcCabecCheckList = funcCabecCheckList;
    }

    public Long getTurnoCabecCheckList() {
        return turnoCabecCheckList;
    }

    public void setTurnoCabecCheckList(Long turnoCabecCheckList) {
        this.turnoCabecCheckList = turnoCabecCheckList;
    }

    public Long getStatusCabecCheckList() {
        return statusCabecCheckList;
    }

    public void setStatusCabecCheckList(Long statusCabecCheckList) {
        this.statusCabecCheckList = statusCabecCheckList;
    }
}
