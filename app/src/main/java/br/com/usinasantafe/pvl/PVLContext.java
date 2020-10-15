package br.com.usinasantafe.pvl;

import android.app.Application;

import br.com.usinasantafe.pvl.control.CheckListCTR;
import br.com.usinasantafe.pvl.control.ConfigCTR;

public class PVLContext extends Application {

    public static String versaoAplic = "1.00";
    private CheckListCTR checkListCTR;
    private ConfigCTR configCTR;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public CheckListCTR getCheckListCTR(){
        if (checkListCTR == null)
            checkListCTR = new CheckListCTR();
        return checkListCTR;
    }

    public ConfigCTR getConfigCTR() {
        if(configCTR == null)
            configCTR = new ConfigCTR();
        return configCTR;
    }

}
