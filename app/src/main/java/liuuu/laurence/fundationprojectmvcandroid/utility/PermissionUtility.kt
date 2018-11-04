package liuuu.laurence.fundationprojectmvcandroid.utility

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.app.Activity
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class PermissionUtility {

    // Location permission
    private val MY_PERMISSIONS_REQUEST_FINE_LOCATION = 101
    // External permission
    private val READ_EXTERNAL_STORAGE_REQUEST_CODE = 102
    // User account permission
    private val GET_USER_ACCOUNT_REQUEST_CODE = 103

    // Check location permission
    fun checkLocationPermission(activity: Activity): Boolean {
        val permission = "android.permission.ACCESS_FINE_LOCATION"
        val res = activity.checkCallingOrSelfPermission(permission)
        return res == PackageManager.PERMISSION_GRANTED
    }

    // Request location permission
    fun locationPermission(activity: Activity) {
        // Check if SDK > 6.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Get permission status
            val hasPermission = activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

            // Request is not get permission yet
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                // Request permission
                //     1st param: Permission name
                //     2nd param: Request code(personal define)
                activity.requestPermissions(
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        MY_PERMISSIONS_REQUEST_FINE_LOCATION)
                return
            }
        }
    }

    // Request external storage permission
    fun externalStoragePermission(activity: Activity) {
        if (ContextCompat.checkSelfPermission(activity,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE_REQUEST_CODE)
        }
    }

    // Request user account
    fun getUserAccountPermission(activity: Activity) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val hasWriteContactsPermission = activity.checkSelfPermission(Manifest.permission.GET_ACCOUNTS)
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(arrayOf(Manifest.permission.GET_ACCOUNTS),
                        GET_USER_ACCOUNT_REQUEST_CODE)
                return
            }
        }
    }

}