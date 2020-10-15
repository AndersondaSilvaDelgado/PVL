package br.com.usinasantafe.pvl.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.usinasantafe.pvl.PVLContext;
import br.com.usinasantafe.pvl.R;
import br.com.usinasantafe.pvl.model.bean.estaticas.TurnoBean;
import br.com.usinasantafe.pvl.util.ConexaoWeb;
import br.com.usinasantafe.pvl.util.Tempo;

public class ListaTurnoActivity extends ActivityGeneric {

    private ListView turnoListView;
    private List turnoList;
    private PVLContext pvlContext;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_turno);

        pvlContext = (PVLContext) getApplication();

        Button buttonRetTurno = (Button) findViewById(R.id.buttonRetTurno);
        Button buttonAtualTurno = (Button) findViewById(R.id.buttonAtualTurno);

        buttonAtualTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(  ListaTurnoActivity.this);
                alerta.setTitle("ATENÇÃO");
                alerta.setMessage("DESEJA REALMENTE ATUALIZAR BASE DE DADOS?");
                alerta.setNegativeButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ConexaoWeb conexaoWeb = new ConexaoWeb();

                        if (conexaoWeb.verificaConexao(ListaTurnoActivity.this)) {

                            progressBar = new ProgressDialog(ListaTurnoActivity.this);
                            progressBar.setCancelable(true);
                            progressBar.setMessage("ATUALIZANDO ...");
                            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                            progressBar.setProgress(0);
                            progressBar.setMax(100);
                            progressBar.show();

                            pvlContext.getCheckListCTR().atualDadosTurno(ListaTurnoActivity.this, ListaTurnoActivity.class, progressBar);

                        } else {

                            AlertDialog.Builder alerta = new AlertDialog.Builder( ListaTurnoActivity.this);
                            alerta.setTitle("ATENÇÃO");
                            alerta.setMessage("FALHA NA CONEXÃO DE DADOS. O CELULAR ESTA SEM SINAL. POR FAVOR, TENTE NOVAMENTE QUANDO O CELULAR ESTIVE COM SINAL.");
                            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            alerta.show();

                        }


                    }
                });

                alerta.setPositiveButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alerta.show();

            }

        });

        turnoList = pvlContext.getCheckListCTR().getTurnoList();

        ArrayList<String> itens = new ArrayList<String>();

        for(int i = 0; i < turnoList.size(); i++){
            TurnoBean turnoBean = (TurnoBean) turnoList.get(i);
            itens.add(turnoBean.getDescTurno());
        }

        AdapterList adapterList = new AdapterList(this, itens);
        turnoListView = (ListView) findViewById(R.id.listaTurno);
        turnoListView.setAdapter(adapterList);

        turnoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> l, View v, int position,
                                    long id) {

                TurnoBean turnoBean = (TurnoBean) turnoList.get(position);
                turnoList.clear();

//                if(Tempo.getInstance().verDthrServ(pvlContext.getConfigCTR().getConfig().getDthrServConfig())){
                    pvlContext.getConfigCTR().setDifDthrConfig(0L);
//                    Intent it = new Intent(ListaTurnoActivity.this, OSActivity.class);
//                    startActivity(it);
//                    finish();
//                }
//                else{
//                    if(pvlContext.getConfigCTR().getConfig().getDifDthrConfig() == 0){
//                        pmmContext.setContDataHora(1);
//                        Intent it = new Intent(ListaTurnoActivity.this, MsgDataHoraActivity.class);
//                        startActivity(it);
//                        finish();
//                    }
//                    else{
//                        Intent it = new Intent(ListaTurnoActivity.this, OSActivity.class);
//                        startActivity(it);
//                        finish();
//                    }
//                }

                if(pvlContext.getCheckListCTR().verAberturaCheckList(turnoBean.getIdTurno())){
                    pvlContext.getCheckListCTR().getCabecCheckListBean().setTurnoCabecCheckList(turnoBean.getIdTurno());
                    pvlContext.getCheckListCTR().setPosCheckList(1);
                    pvlContext.getCheckListCTR().createCabecAberto();
                    if (pvlContext.getCheckListCTR().getVerAtualCheckList().equals("N_AC")) {
                        Intent it = new Intent(ListaTurnoActivity.this, PergAtualCheckListActivity.class);
                        startActivity(it);
                        finish();
                    } else {
                        Intent it = new Intent(ListaTurnoActivity.this, ItemCheckListActivity.class);
                        startActivity(it);
                        finish();
                    }
                }
                else{

                    AlertDialog.Builder alerta = new AlertDialog.Builder(ListaTurnoActivity.this);
                    alerta.setTitle("ATENÇÃO");
                    alerta.setMessage("JÁ FOI CADASTRADO UM CHECKLIST PARA ESSE EQUIPAMENTO NESSE TURNO! POR FAVOR, AGUARDE O PRÓXIMO TURNO PARA CADASTRAR OUTRO CHECKLIST.");
                    alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent it = new Intent(ListaTurnoActivity.this, MenuInicialActivity.class);
                            startActivity(it);
                            finish();

                        }
                    });

                    alerta.show();

                }

            }

        });

        buttonRetTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListaTurnoActivity.this, EquipActivity.class);
                startActivity(it);
                finish();
            }
        });

    }

    public void onBackPressed()  {
    }

}