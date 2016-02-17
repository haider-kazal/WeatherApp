package Library;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

/**
 * Created by haideralikazal on 2/18/16.
 */
public class Permission {
    public static boolean hasInternetPermission(@NotNull final Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED;
    }
}
