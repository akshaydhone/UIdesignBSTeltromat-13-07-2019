package com.mind.bst;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

/**

 */
public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //getting the remote input bundle from intent
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);

        //if there is some input
        if (remoteInput != null) {

            //getting the input value
            CharSequence name = remoteInput.getCharSequence(NotificationActivity.NOTIFICATION_REPLY);

            //updating the notification with the input value
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NotificationActivity.CHANNNEL_ID)
                    .setSmallIcon(android.R.drawable.ic_menu_info_details)
                    .setContentTitle("Hey Thanks, " + name);
            NotificationManager notificationManager = (NotificationManager) context.
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NotificationActivity.NOTIFICATION_ID, mBuilder.build());
        }

        //if help button is clicked
        if (intent.getIntExtra(NotificationActivity.KEY_INTENT_HELP, -1) == NotificationActivity.REQUEST_CODE_HELP) {
            Toast.makeText(context, "You accepted the visit", Toast.LENGTH_LONG).show();
        }

        //if more button is clicked
        if (intent.getIntExtra(NotificationActivity.KEY_INTENT_MORE, -1) ==NotificationActivity.REQUEST_CODE_MORE) {
            Toast.makeText(context, "You Declined the request", Toast.LENGTH_LONG).show();
        }
    }
}
