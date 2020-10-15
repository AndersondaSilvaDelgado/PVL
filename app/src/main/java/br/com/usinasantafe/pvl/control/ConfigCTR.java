package br.com.usinasantafe.pvl.control;

import android.app.ProgressDialog;
import android.content.Context;

import br.com.usinasantafe.pvl.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.ConfigBean;
import br.com.usinasantafe.pvl.model.dao.ConfigDAO;
import br.com.usinasantafe.pvl.model.dao.EquipDAO;
import br.com.usinasantafe.pvl.util.AtualDadosServ;

public class ConfigCTR {

    public boolean hasElements(){
        ConfigDAO configDAO = new ConfigDAO();
        return configDAO.hasElements();
    }

    public boolean verConfig(String senhaConfig){
        ConfigDAO configDAO = new ConfigDAO();
        return configDAO.verConfig(senhaConfig);
    }

    public EquipBean getEquip(){
        EquipDAO equipDAO = new EquipDAO();
        return equipDAO.getEquip();
    }

    public ConfigBean getConfig(){
        ConfigDAO configDAO = new ConfigDAO();
        return configDAO.getConfig();
    }

    public void salvarConfig(String senha){
        ConfigDAO configDAO = new ConfigDAO();
        configDAO.salvarConfig(senha);
    }

    public void setEquipConfig(EquipBean equipBean){
        ConfigDAO configDAO = new ConfigDAO();
        configDAO.setEquipConfig(equipBean);
    }

    public void verEquipConfig(String dado, Context telaAtual, Class telaProx, ProgressDialog progressDialog){
        EquipDAO equipDAO = new EquipDAO();
        equipDAO.verEquip(dado, telaAtual, telaProx, progressDialog);
    }

    public void atualTodasTabelas(Context tela, ProgressDialog progressDialog){
        AtualDadosServ.getInstance().atualTodasTabBD(tela, progressDialog);
    }

    public void setDifDthrConfig(Long status){
        ConfigDAO configDAO = new ConfigDAO();
        configDAO.setDifDthrConfig(status);
    }

    public void setDthrServConfig(String data){
        ConfigDAO configDAO = new ConfigDAO();
        configDAO.setDthrServConfig(data);
    }

    public void recDadosEquip(String result){
        EquipDAO equipDAO = new EquipDAO();
        equipDAO.recDadosEquip(result);
    }

    public void setCheckListConfig(Long idTurno){
        ConfigDAO configDAO = new ConfigDAO();
        configDAO.setCheckListConfig(idTurno);
    }

}
