package br.com.usinasantafe.pvl.model.bean.variaveis;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pvl.model.pst.Entidade;

@DatabaseTable(tableName="tbrespcheckllistvar")
public class RespCheckListBean extends Entidade {

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId=true)
    private Long idItCheckList;
    @DatabaseField
    private Long idItBDItCheckList;
    @DatabaseField
    private Long idCabItCheckList;
    @DatabaseField
    private Long opItCheckList;

    public RespCheckListBean() {
    }

    public Long getIdItCheckList() {
        return idItCheckList;
    }

    public Long getIdItBDItCheckList() {
        return idItBDItCheckList;
    }

    public void setIdItBDItCheckList(Long idItBDItCheckList) {
        this.idItBDItCheckList = idItBDItCheckList;
    }

    public Long getIdCabItCheckList() {
        return idCabItCheckList;
    }

    public void setIdCabItCheckList(Long idCabItCheckList) {
        this.idCabItCheckList = idCabItCheckList;
    }

    public Long getOpItCheckList() {
        return opItCheckList;
    }

    public void setOpItCheckList(Long opItCheckList) {
        this.opItCheckList = opItCheckList;
    }
}
