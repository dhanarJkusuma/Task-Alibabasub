package id.cerve.dhanarjkusuma.alibabasub.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by DhanarJKusuma on 6/15/2015.
 */
public class GetMessageError
{
    public void getMessage(Context context)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder
                .setMessage("Koneksi Anda Bermasalah...")
                .setCancelable(false)
                .setPositiveButton("Close",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
