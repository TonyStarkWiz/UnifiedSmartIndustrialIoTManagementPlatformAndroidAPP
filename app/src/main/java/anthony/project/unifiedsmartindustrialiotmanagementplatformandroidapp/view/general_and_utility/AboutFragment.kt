package anthony.project.unifiedsmartindustrialiotmanagementplatformandroidapp.view.general_and_utility

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import anthony.project.unifiedsmartindustrialiotmanagementplatform.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        // Set the app version
        val versionTextView: TextView = view.findViewById(R.id.textview_version)
        versionTextView.text = getAppVersion()

        // Set legal information
        val legalTextView: TextView = view.findViewById(R.id.textview_legal)
        legalTextView.text = getString(R.string.legal_information)

        // Set help resource information
        val helpTextView: TextView = view.findViewById(R.id.textview_help)
        helpTextView.text = getString(R.string.help_resources)

        return view
    }

    // Helper method to get the current app version from the package manager
    private fun getAppVersion(): String {
        // Use the packageManager directly from the context to get package info
        val packageManager = context?.packageManager
        return try {
            // Get the package info using the package name and use 0 flag for basic package info
            val packageInfo = packageManager?.getPackageInfo(requireContext().packageName, 0)
            // Return the version name from the package info
            packageInfo?.versionName ?: "Unknown" // Use elvis operator to return "Unknown" if null
        } catch (e: PackageManager.NameNotFoundException) {
            // If there's an error, default to "Unknown"
            "Unknown"
        }
    }

}


