package br.com.usinasantafe.pvl.util.conHttp;

import br.com.usinasantafe.pvl.PVLContext;

public class UrlsConexaoHttp {

    public static String urlPrincipal = "http://www.usinasantafe.com.br/pvl/view/";
    public static String urlPrincEnvio = "http://www.usinasantafe.com.br/pvl/view/";

    public static String localPSTEstatica = "br.com.usinasantafe.pmm.model.bean.estaticas.";
    public static String localUrl = "br.com.usinasantafe.pmm.util.conHttp.UrlsConexaoHttp";

    public static String put = "?versao=" + PVLContext.versaoAplic.replace(".", "_");

    public static String EquipBean = urlPrincipal + "equip.php" + put;
    public static String FuncBean = urlPrincipal + "func.php" + put;

    public UrlsConexaoHttp() {
    }

    public String getsInserirCheckList() {
        return urlPrincEnvio + "inserirchecklist.php" + put;
    }

    public String getsInsertApontaMM() {
        return urlPrincEnvio + "inserirapontmm.php" + put;
    }

    public String getsInsertBolAbertoMM() {
        return urlPrincEnvio + "inserirbolabertomm.php" + put;
    }

    public String getsInsertBolFechadoMM() {
        return urlPrincEnvio + "inserirbolfechadomm.php" + put;
    }

    public String getsInsertApontaFert() {
        return urlPrincEnvio + "inserirapontfert.php" + put;
    }

    public String getsInsertBolAbertoFert() {
        return urlPrincEnvio + "inserirbolabertofert.php" + put;
    }

    public String getsInsertBolFechadoFert() {
        return urlPrincEnvio + "inserirbolfechadofert.php" + put;
    }

    public String urlVerifica(String classe) {
        String retorno = "";
        if (classe.equals("Equip")) {
            retorno = urlPrincipal + "equip.php" + put;
        } else if (classe.equals("Atualiza")) {
            retorno = urlPrincipal + "atualaplic.php" + put;
        }
        return retorno;
    }

}
