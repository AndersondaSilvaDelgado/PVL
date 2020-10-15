package br.com.usinasantafe.pvl.control;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.ItemCheckListBean;
import br.com.usinasantafe.pvl.model.bean.variaveis.CabecCheckListBean;
import br.com.usinasantafe.pvl.model.dao.CabecCheckListDAO;
import br.com.usinasantafe.pvl.model.dao.FuncDAO;
import br.com.usinasantafe.pvl.model.dao.ItemCheckListDAO;
import br.com.usinasantafe.pvl.model.dao.RespCheckListDAO;
import br.com.usinasantafe.pvl.model.dao.TurnoDAO;
import br.com.usinasantafe.pvl.util.AtualDadosServ;
import br.com.usinasantafe.pvl.util.VerifDadosServ;

public class CheckListCTR {

    private CabecCheckListBean cabecCheckListBean;
    private int posCheckList;
    private String verAtualCheckList;

    ////////////////////////////////// SALVAR DADOS ///////////////////////////////////////////

    public void createCabecAberto(){
        CabecCheckListDAO cabecCheckListDAO = new CabecCheckListDAO();
        cabecCheckListDAO.createCabecAberto(cabecCheckListBean);
    }

    public void salvarRespCheckList(ItemCheckListBean itemCheckListBean, Long opcao){
        CabecCheckListDAO cabecCheckListDAO = new CabecCheckListDAO();
        RespCheckListDAO respCheckListDAO = new RespCheckListDAO();
        respCheckListDAO.salvarRespCheckList(cabecCheckListDAO.getCabecAberto().getIdCabecCheckList(), itemCheckListBean, opcao);
    }

    public void fecharCabCheckList(){
        CabecCheckListDAO cabecCheckListDAO = new CabecCheckListDAO();
        cabecCheckListDAO.fecharCabCheckList();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////// VERIFICAR DADOS //////////////////////////////////////////

    public boolean hasElemFunc(){
        FuncDAO funcDAO = new FuncDAO();
        return funcDAO.hasElements();
    }

    public boolean verFunc(Long matricFunc){
        FuncDAO funcDAO = new FuncDAO();
        return funcDAO.verFunc(matricFunc);
    }

    public boolean verAberturaCheckList(Long turno){
        CabecCheckListDAO cabecCheckListDAO = new CabecCheckListDAO();
        ConfigCTR configCTR = new ConfigCTR();
        return cabecCheckListDAO.verAberturaCheckList(turno, configCTR.getConfig(), configCTR.getEquip());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////// GET DE CAMPOS ///////////////////////////////////////////

    public CabecCheckListBean getCabecCheckListBean() {
        return cabecCheckListBean;
    }

    public List getTurnoList(){
        ConfigCTR configCTR = new ConfigCTR();
        TurnoDAO turnoDAO = new TurnoDAO();
        return turnoDAO.getTurnoList(configCTR.getEquip().getCodTurno());
    }

    public int getPosCheckList() {
        return posCheckList;
    }

    public String getVerAtualCheckList() {
        return verAtualCheckList;
    }

    public List getItemList(){
        ConfigCTR configCTR = new ConfigCTR();
        ItemCheckListDAO itemCheckListDAO = new ItemCheckListDAO();
        List itemCheckListList = itemCheckListDAO.getItemList(configCTR.getEquip().getIdCheckList());
        return itemCheckListList;
    }

    public int qtdeItemCheckList(){
        ConfigCTR configCTR = new ConfigCTR();
        ItemCheckListDAO itemCheckListDAO = new ItemCheckListDAO();
        return itemCheckListDAO.qtdeItem(configCTR.getEquip().getIdCheckList());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////// SET DE CAMPOS ///////////////////////////////////////////

    public void setCabecCheckListBean(CabecCheckListBean cabecCheckListBean) {
        this.cabecCheckListBean = cabecCheckListBean;
    }

    public void setPosCheckList(int posCheckList) {
        this.posCheckList = posCheckList;
    }

    public void setVerAtualCheckList(String verAtualCheckList) {
        this.verAtualCheckList = verAtualCheckList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////// ATUALIZAÇÃO DE DADOS POR CLASSE //////////////////////////////////

    public void atualDadosOperador(Context telaAtual, Class telaProx, ProgressDialog progressDialog){
        ArrayList operadorArrayList = new ArrayList();
        operadorArrayList.add("FuncBean");
        AtualDadosServ.getInstance().atualGenericoBD(telaAtual, telaProx, progressDialog, operadorArrayList);
    }

    public void atualDadosTurno(Context telaAtual, Class telaProx, ProgressDialog progressDialog) {
        ArrayList turnoArrayList = new ArrayList();
        turnoArrayList.add("TurnoBean");
        AtualDadosServ.getInstance().atualGenericoBD(telaAtual, telaProx, progressDialog, turnoArrayList);
    }

    public void atualCheckList(String dado, Context telaAtual, Class telaProx, ProgressDialog progressDialog){
        ItemCheckListDAO itemCheckListDAO = new ItemCheckListDAO();
        itemCheckListDAO.atualCheckList(dado, telaAtual, telaProx, progressDialog);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////// RECEBE DADOS DO SERVIDOR /////////////////////////////////////

     public void recDadosItemCheckList(String result) {

         try {

             if (!result.contains("exceeded")) {

                 int pos1 = result.indexOf("_") + 1;
                 String objPrinc = result.substring(0, (pos1 - 1));
                 String objSeg = result.substring(pos1);

                 ConfigCTR configCTR = new ConfigCTR();
                 configCTR.recDadosEquip(objPrinc);

                 ItemCheckListDAO itemCheckListDAO = new ItemCheckListDAO();
                 itemCheckListDAO.recDadosCheckList(objSeg);

             } else {
                 VerifDadosServ.getInstance().pulaTelaSemTerm();
             }

         } catch (Exception e) {
             VerifDadosServ.getInstance().pulaTelaSemTerm();
         }

     }

    ////////////////////////////////////////////////////////////////////////////////////////////

}
