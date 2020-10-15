package br.com.usinasantafe.pvl.model.dao;

import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.CabecCheckListBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.ConfigBean;
import br.com.usinasantafe.pvl.util.Tempo;

public class CabecCheckListDAO {

    public CabecCheckListDAO() {
    }

    public boolean verAberturaCheckList(Long idTurno, ConfigBean configBean, EquipBean equipBean){

        if ((equipBean.getIdCheckList() > 0) &&
                ((configBean.getUltTurnoCheckListConfig() != idTurno)
                        || ((configBean.getUltTurnoCheckListConfig() == idTurno)
                        && (!configBean.getDtUltCheckListConfig().equals(Tempo.getInstance().dataSHora()))))) {
            return true;
        }
        else{
            return false;
        }

    }

    public void createCabecAberto(CabecCheckListBean cabecCheckListBean){
        cabecCheckListBean.setStatusCabecCheckList(1L);
        cabecCheckListBean.insert();
    }

    public CabecCheckListBean getCabecAberto(){
        CabecCheckListBean cabecCheckListBean = new CabecCheckListBean();
        List cabecList = cabecCheckListBean.get("statusCabCheckList", 1L);
        cabecCheckListBean = (CabecCheckListBean) cabecList.get(0);
        cabecList.clear();
        return cabecCheckListBean;
    }

    public void fecharCabCheckList() {
        CabecCheckListBean cabecCLBean = getCabecAberto();
        cabecCLBean.setStatusCabecCheckList(2L);
        cabecCLBean.update();
    }

}
