package br.com.usinasantafe.pvl.model.dao;

import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.ConfigBean;
import br.com.usinasantafe.pvl.util.Tempo;

public class ConfigDAO {

    public boolean hasElements(){
        ConfigBean configBean = new ConfigBean();
        return configBean.hasElements();
    }

    public boolean verConfig(String senhaConfig){
        ConfigBean configBean = new ConfigBean();
        List<ConfigBean> configList = configBean.get("senhaConfig", senhaConfig);
        boolean ret = (configList.size() > 0);
        configList.clear();
        return ret;
    }

    public ConfigBean getConfig(){
        ConfigBean configBean = new ConfigBean();
        List listConfigTO = configBean.all();
        configBean = (ConfigBean) listConfigTO.get(0);
        listConfigTO.clear();
        return configBean;
    }

    public void salvarConfig(String senha){
        ConfigBean configBean = new ConfigBean();
        configBean.deleteAll();
        configBean.setDifDthrConfig(0L);
        configBean.setSenhaConfig(senha);
        configBean.insert();
        configBean.commit();
    }

    public void setEquipConfig(EquipBean equipBean){
        ConfigBean configBean = getConfig();
        configBean.setEquipConfig(equipBean.getIdEquip());
        configBean.update();
    }

    public void setDifDthrConfig(Long difDthrConfig){
        ConfigBean configBean = getConfig();
        configBean.setDifDthrConfig(difDthrConfig);
        configBean.update();
    }

    public void setCheckListConfig(Long idTurno){
        ConfigBean configBean = getConfig();
        configBean.setUltTurnoCheckListConfig(idTurno);
        configBean.setDtUltCheckListConfig(Tempo.getInstance().dataSHora());
        configBean.update();
    }

    public void setDthrServConfig(String data){
        ConfigBean configBean = getConfig();
        configBean.setDthrServConfig(data);
        configBean.update();
    }

}
