package br.com.usinasantafe.pvl.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.usinasantafe.pvl.PVLContext;
import br.com.usinasantafe.pvl.R;
import br.com.usinasantafe.pvl.model.bean.estaticas.ItemCheckListBean;

public class ItemCheckListActivity extends ActivityGeneric {

    private PVLContext pvlContext;
    private TextView textViewItemChecklist;
    private List itemCheckListList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_check_list);

        pvlContext = (PVLContext) getApplication();

        textViewItemChecklist = (TextView) findViewById(R.id.textViewItemChecklist);
        Button buttonConforme = (Button) findViewById(R.id.buttonConforme);
        Button buttonNaoConforme = (Button) findViewById(R.id.buttonNaoConforme);
        Button buttonReparo = (Button) findViewById(R.id.buttonReparo);
        Button buttonCancChecklist = (Button) findViewById(R.id.buttonCancChecklist);

        itemCheckListList = pvlContext.getCheckListCTR().getItemList();
        setItemCheckListTextView();

        buttonConforme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                proximaTela(1L);

            }

        });

        buttonNaoConforme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                proximaTela(2L);
            }

        });

        buttonReparo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                proximaTela(3L);
            }

        });

        buttonCancChecklist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                retornoTela();
            }

        });

    }

    public void proximaTela(Long opcao){

        ItemCheckListBean itemCheckListBean = (ItemCheckListBean) itemCheckListList.get(pvlContext.getCheckListCTR().getPosCheckList() - 1);
        pvlContext.getCheckListCTR().salvarRespCheckList(itemCheckListBean, opcao);

        if(pvlContext.getCheckListCTR().qtdeItemCheckList() == pvlContext.getCheckListCTR().getPosCheckList()){
            pvlContext.getConfigCTR().setCheckListConfig(pvlContext.getCheckListCTR().getCabecCheckListBean().getTurnoCabecCheckList());
            pvlContext.getCheckListCTR().fecharCabCheckList();
            Intent it = new Intent(ItemCheckListActivity.this, MenuInicialActivity.class);
            startActivity(it);
            finish();
        }
        else{
            pvlContext.getCheckListCTR().setPosCheckList(pvlContext.getCheckListCTR().getPosCheckList() + 1);
            setItemCheckListTextView();
        }

    }

    public void retornoTela(){
        if(pvlContext.getCheckListCTR().getPosCheckList() > 1){
            pvlContext.getCheckListCTR().setPosCheckList(pvlContext.getCheckListCTR().getPosCheckList() - 1);
            setItemCheckListTextView();
        }
    }

    public void setItemCheckListTextView(){
        ItemCheckListBean itemCheckListBean = (ItemCheckListBean) itemCheckListList.get(pvlContext.getCheckListCTR().getPosCheckList() - 1);
        textViewItemChecklist.setText(pvlContext.getCheckListCTR().getPosCheckList() + " - " + itemCheckListBean.getDescrItemCheckList());
    }

    public void onBackPressed()  {
    }

}