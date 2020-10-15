package br.com.usinasantafe.pvl.model.dao;

import java.util.List;

import br.com.usinasantafe.pvl.model.bean.estaticas.FuncBean;

public class FuncDAO {

    public boolean hasElements(){
        FuncBean funcBean = new FuncBean();
        return funcBean.hasElements();
    }

    public boolean verFunc(Long matricFunc){
        FuncBean funcBean = new FuncBean();
        List<FuncBean> funcList = funcBean.get("matricFunc", matricFunc);
        boolean ret = (funcList.size() > 0);
        funcList.clear();
        return ret;
    }

}
