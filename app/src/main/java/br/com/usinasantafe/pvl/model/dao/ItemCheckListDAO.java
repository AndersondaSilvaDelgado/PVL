package br.com.usinasantafe.pvl.model.dao;

import android.app.ProgressDialog;
import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.ItemCheckListBean;
import br.com.usinasantafe.pvl.util.VerifDadosServ;

public class ItemCheckListDAO {

    public ItemCheckListDAO() {
    }

    public void atualCheckList(String dado, Context telaAtual, Class telaProx, ProgressDialog progressDialog){
        VerifDadosServ.getInstance().setVerTerm(true);
        VerifDadosServ.getInstance().verDados(dado, "CheckList", telaAtual, telaProx, progressDialog);
    }

    public void recDadosCheckList(String result) {

        try {

                JSONObject jObj = new JSONObject(result);
                JSONArray jsonArray = jObj.getJSONArray("dados");

                ItemCheckListBean itemCheckListBean = new ItemCheckListBean();
                itemCheckListBean.deleteAll();

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject objeto = jsonArray.getJSONObject(i);
                    Gson gson = new Gson();
                    ItemCheckListBean itemCheckList = gson.fromJson(objeto.toString(), ItemCheckListBean.class);
                    itemCheckList.insert();

                }

                VerifDadosServ.getInstance().pulaTelaSemTerm();

        } catch (Exception e) {
            VerifDadosServ.getInstance().pulaTelaSemTerm();
        }

    }

    public List getItemList(Long idCheckList){
        ItemCheckListBean itemCheckListBean = new ItemCheckListBean();
        List itemCheckListList = itemCheckListBean.getAndOrderBy("idCheckList", idCheckList, "idItemCheckList", true);
        return itemCheckListList;
    }

    public int qtdeItem(Long idChecklist){
        ItemCheckListBean itemCheckListBean = new ItemCheckListBean();
        List itemCheckListList = itemCheckListBean.get("idCheckList", idChecklist);
        int qtdeItem = itemCheckListList.size();
        itemCheckListList.clear();
        return qtdeItem;
    }

}
