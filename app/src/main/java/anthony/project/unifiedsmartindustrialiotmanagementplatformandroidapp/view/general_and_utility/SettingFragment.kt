package anthony.project.unifiedsmartindustrialiotmanagementplatformandroidapp.view.general_and_utility

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

class SettingsFragment : PreferenceFragmentCompat() {

    // Define keys for preference values. These should match what's in the preferences XML.
    companion object {
        const val KEY_PREF_BLE = "pref_ble"
        const val KEY_PREF_NOTIFICATIONS = "pref_notifications"
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // Load the preferences from an XML resource
        setPreferencesFromResource(R.xml.preferences, rootKey)

        // Example of accessing a SwitchPreferenceCompat for BLE setting
        val blePreference: SwitchPreferenceCompat? = findPreference(KEY_PREF_BLE)
        blePreference?.setOnPreferenceChangeListener { preference, newValue ->
            // Handle BLE preference change
            // newValue will be a boolean representing the new state of the switch
            true // Return true to update the state of the preference with the new value
        }

        // Similar setup for notification preference
        val notificationPreference: SwitchPreferenceCompat? = findPreference(KEY_PREF_NOTIFICATIONS)
        notificationPreference?.setOnPreferenceChangeListener { preference, newValue ->
            // Handle notifications preference change
            true
        }

        // Add more settings as needed for your application
    }

    // TODO: Define methods to handle each setting as required for your app's functionality
}


