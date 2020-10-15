package br.com.usinasantafe.pvl.model.bean.estaticas;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pvl.model.pst.Entidade;

@DatabaseTable(tableName="tbitemchecklistest")
public class ItemCheckListBean extends Entidade {

    private static final long serialVersionUID = 1L;

    @DatabaseField(id=true)
    private Long idItemCheckList;
    @DatabaseField
    private Long idCheckList;
    @DatabaseField
    private String descrItemCheckList;

    public ItemCheckListBean() {
    }

    public Long getIdItemCheckList() {
        return idItemCheckList;
    }

    public void setIdItemCheckList(Long idItemCheckList) {
        this.idItemCheckList = idItemCheckList;
    }

    public Long getIdCheckList() {
        return idCheckList;
    }

    public void setIdCheckList(Long idCheckList) {
        this.idCheckList = idCheckList;
    }

    public String getDescrItemCheckList() {
        return descrItemCheckList;
    }

    public void setDescrItemCheckList(String descrItemCheckList) {
        this.descrItemCheckList = descrItemCheckList;
    }
}