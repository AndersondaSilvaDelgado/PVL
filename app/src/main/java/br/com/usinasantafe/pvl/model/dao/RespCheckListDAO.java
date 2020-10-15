package br.com.usinasantafe.pvl.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.ItemCheckListBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.RespCheckListBean;
import br.com.usinasantafe.pvl.model.pst.EspecificaPesquisa;

public class RespCheckListDAO {

    public RespCheckListDAO() {
    }

    public void salvarRespCheckList(Long idCabCheckList, ItemCheckListBean itemCheckListBean, Long opcao){

        ArrayList pesqArrayList = new ArrayList();
        EspecificaPesquisa pesquisa1 = new EspecificaPesquisa();
        pesquisa1.setCampo("idCabItCheckList");
        pesquisa1.setValor(idCabCheckList);
        pesquisa1.setTipo(1);
        pesqArrayList.add(pesquisa1);

        EspecificaPesquisa pesquisa2 = new EspecificaPesquisa();
        pesquisa2.setCampo("idItBDItCheckList");
        pesquisa2.setValor(itemCheckListBean.getIdItemCheckList());
        pesquisa2.setTipo(1);
        pesqArrayList.add(pesquisa2);

        RespCheckListBean respCheckListBean = new RespCheckListBean();
        List respCheckListList = respCheckListBean.get(pesqArrayList);

        if(respCheckListList.size() > 0) {
            respCheckListBean = (RespCheckListBean) respCheckListList.get(0);
            respCheckListBean.setOpItCheckList(opcao);
            respCheckListBean.update();
        }
        else{
            respCheckListBean.setIdCabItCheckList(idCabCheckList);
            respCheckListBean.insert();
        }
        respCheckListList.clear();

    }

}
