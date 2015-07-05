package com.example.michael.dialogcomm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private ExitListerner listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof ExitListerner)){
            throw new RuntimeException("A activity precisa implementar a interface ExitDialog.ExitListener");
        }

        listener = (ExitListerner) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Deseja sair?")
                .setPositiveButton(getActivity().getString(R.string.yes), this)
                .setNegativeButton(getActivity().getString(R.string.no), this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE && listener != null) {
            listener.onExit();
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {

        }
    }

    public interface ExitListerner {
        public void onExit();
    }
}
