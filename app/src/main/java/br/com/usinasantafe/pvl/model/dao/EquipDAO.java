package br.com.usinasantafe.pvl.model.dao;

import android.app.ProgressDialog;
import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import br.com.usinasantafe.pvl.control.ConfigCTR;
import br.com.usinasantafe.pvl.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pvl.util.VerifDadosServ;

public class EquipDAO {

    public EquipBean getEquip(){
        EquipBean equipBean = new EquipBean();
        List equipList = equipBean.all();
        equipBean = (EquipBean) equipList.get(0);
        equipList.clear();
        return equipBean;
    }

    public void verEquip(String dado, Context telaAtual, Class telaProx, ProgressDialog progressDialog){
        VerifDadosServ.getInstance().setVerTerm(true);
        VerifDadosServ.getInstance().verDados(dado, "Equip", telaAtual, telaProx, progressDialog);
    }

    public void recDadosEquip(String result){
        try {

            JSONObject jObj = new JSONObject(result);
            JSONArray jsonArray = jObj.getJSONArray("dados");

            if (jsonArray.length() > 0) {

                EquipBean equipBean = new EquipBean();
                equipBean.deleteAll();

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject objeto = jsonArray.getJSONObject(i);
                    Gson gson = new Gson();
                    equipBean = gson.fromJson(objeto.toString(), EquipBean.class);
                    equipBean.insert();

                }

                ConfigCTR configCTR = new ConfigCTR();
                configCTR.setEquipConfig(equipBean);

                VerifDadosServ.getInstance().pulaTelaSemTerm();

            } else {
                VerifDadosServ.getInstance().msgSemTerm("EQUIPAMENTO INEXISTENTE NA BASE DE DADOS! FAVOR VERIFICA A NUMERAÇÃO.");
            }

        } catch (Exception e) {
            VerifDadosServ.getInstance().msgSemTerm("FALHA DE PESQUISA DE EQUIPAMENTO! POR FAVOR, TENTAR NOVAMENTE COM UM SINAL MELHOR.");
        }
    }


}
