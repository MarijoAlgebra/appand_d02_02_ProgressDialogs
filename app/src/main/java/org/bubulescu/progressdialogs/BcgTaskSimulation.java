package org.bubulescu.progressdialogs;

import android.app.ProgressDialog;

public class BcgTaskSimulation extends Thread {

    private ProgressDialog progressDialog;
    private Boolean hasProgress;

    public BcgTaskSimulation(ProgressDialog progressDialog, Boolean hasProgress) {
        this.progressDialog = progressDialog;
        this.hasProgress = hasProgress;
    }

    @Override
    public void run() {

        if (hasProgress) {
            sleepWithProgress();
        } else {
            sleepWithNoProgress();
        }

        progressDialog.dismiss();
    }

    private void sleepWithProgress() {
        while (progressDialog.getProgress() < 100) {
            try {
                Thread.sleep(1000);
                progressDialog.incrementProgressBy(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sleepWithNoProgress() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
