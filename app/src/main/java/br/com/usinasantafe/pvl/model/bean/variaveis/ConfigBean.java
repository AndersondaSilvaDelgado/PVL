package br.com.usinasantafe.pvl.model.bean.variaveis;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pvl.model.pst.Entidade;

@DatabaseTable(tableName="tbconfigvar")
public class ConfigBean extends Entidade {

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId=true)
    private Long idConfig;
    @DatabaseField
    private Long equipConfig;
    @DatabaseField
    private String senhaConfig;
    @DatabaseField
    private Long difDthrConfig;
    @DatabaseField
    private String dthrServConfig;
    @DatabaseField
    private Long ultTurnoCheckListConfig;
    @DatabaseField
    private String dtUltCheckListConfig;

    public ConfigBean() {
    }

    public Long getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(Long idConfig) {
        this.idConfig = idConfig;
    }

    public Long getEquipConfig() {
        return equipConfig;
    }

    public void setEquipConfig(Long equipConfig) {
        this.equipConfig = equipConfig;
    }

    public String getSenhaConfig() {
        return senhaConfig;
    }

    public void setSenhaConfig(String senhaConfig) {
        this.senhaConfig = senhaConfig;
    }

    public Long getDifDthrConfig() {
        return difDthrConfig;
    }

    public void setDifDthrConfig(Long difDthrConfig) {
        this.difDthrConfig = difDthrConfig;
    }

    public String getDthrServConfig() {
        return dthrServConfig;
    }

    public void setDthrServConfig(String dthrServConfig) {
        this.dthrServConfig = dthrServConfig;
    }

    public Long getUltTurnoCheckListConfig() {
        return ultTurnoCheckListConfig;
    }

    public void setUltTurnoCheckListConfig(Long ultTurnoCheckListConfig) {
        this.ultTurnoCheckListConfig = ultTurnoCheckListConfig;
    }

    public String getDtUltCheckListConfig() {
        return dtUltCheckListConfig;
    }

    public void setDtUltCheckListConfig(String dtUltCheckListConfig) {
        this.dtUltCheckListConfig = dtUltCheckListConfig;
    }
}
