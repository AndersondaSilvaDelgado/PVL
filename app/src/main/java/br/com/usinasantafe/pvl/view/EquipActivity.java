package br.com.usinasantafe.pvl.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.usinasantafe.pvl.PVLContext;
import br.com.usinasantafe.pvl.R;

public class EquipActivity extends ActivityGeneric {

    private TextView textViewCodEquip;
    private TextView textViewDescEquip;
    private PVLContext pvlContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);

        pvlContext = (PVLContext) getApplication();

        textViewCodEquip = (TextView) findViewById(R.id.textViewCodEquip);
        textViewDescEquip = (TextView) findViewById(R.id.textViewDescEquip);
        Button buttonOkEquip = (Button) findViewById(R.id.buttonOkEquip);
        Button buttonCancEquip = (Button) findViewById(R.id.buttonCancEquip);

        textViewCodEquip.setText(String.valueOf(pvlContext.getConfigCTR().getEquip().getNroEquip()));
        textViewDescEquip.setText(String.valueOf(pvlContext.getConfigCTR().getEquip().getDescrClasseEquip()));

        buttonOkEquip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pvlContext.getCheckListCTR().getCabecCheckListBean().setEquipCabecCheckList(pvlContext.getConfigCTR().getEquip().getNroEquip());
                Intent it = new Intent(EquipActivity.this, ListaTurnoActivity.class);
                startActivity(it);
                finish();

            }
        });

        buttonCancEquip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(EquipActivity.this, OperadorActivity.class);
                startActivity(it);
                finish();
            }

        });

    }

    public void onBackPressed()  {
    }

}