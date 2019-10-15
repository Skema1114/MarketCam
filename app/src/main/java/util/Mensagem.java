package util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Rafael Martins on 07/12/2016.
 */

public class Mensagem {
    public static void Msg (Activity activity , String mensagem){
        Toast.makeText(activity , mensagem , Toast.LENGTH_LONG).show();
    }

    public static void MsgOk(Activity activity, String titulo, String mensagem, int icone){
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity);
        dlg.setTitle(titulo);
        dlg.setMessage(mensagem);
        dlg.setNeutralButton("OK", null);
        dlg.setIcon(icone);
        dlg.show();
    }

    public static AlertDialog criarAlertDialog(Activity activity){
        final CharSequence[] items = {
                "Editar",
                "Excluir"
        };
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity);
        dlg.setTitle("Opções");
        dlg.setItems(items, (DialogInterface.OnClickListener) activity);

        return dlg.create();
    }

    public static AlertDialog CriarDialogConfirmacao (Activity activity, String sair, String s, int i, DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity);
        dlg.setMessage("Deseja Realmente Excluir?");
        dlg.setNegativeButton("Não", (DialogInterface.OnClickListener) activity);
        dlg.setPositiveButton("Sim", (DialogInterface.OnClickListener) activity);

        return dlg.create();
    }

    public static void MsgConfirmar (Activity activity, String titulo, String mensagem, int icone, DialogInterface.OnClickListener listener){
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity);
        dlg.setTitle(titulo);
        dlg.setMessage(mensagem);
        dlg.setIcon(icone);
        dlg.setNegativeButton("Não", null);
        dlg.setPositiveButton("Sim", listener);
        dlg.show();
    }
}

