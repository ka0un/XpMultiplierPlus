package org.kasun.xpmultiplierplus.Utils;

import org.bukkit.plugin.java.JavaPlugin;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.XMLFormatter;

public class UpdateChecker {
    private final XpMultiplierPlus plugin;
    private final String textFileURL;
    private final String currentVersion;
    private OutdatedReminder outdatedReminder;

    public UpdateChecker(XpMultiplierPlus plugin, String textFileURL, String currentVersion, OutdatedReminder outdatedReminder) {
        this.plugin = plugin;
        this.textFileURL = textFileURL;
        this.currentVersion = currentVersion;
        this.outdatedReminder = outdatedReminder;
        checkForUpdates();
    }

    public void checkForUpdates() {
        try {
            URL url = new URL(textFileURL);
            URLConnection connection = url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the line contains version information
                    if (line.startsWith("Version: ")) {
                        String latestVersion = line.substring("Version: ".length()).trim();

                        if (!latestVersion.equals(currentVersion)) {
                            plugin.getLogger().warning("=========================================================");
                            plugin.getLogger().warning("A new version of the plugin is available: " + latestVersion);
                            plugin.getLogger().warning("Please update from BuiltByBit");
                            plugin.getLogger().warning("=========================================================");
                            outdatedReminder.setOutdated(true);
                        } else {
                            plugin.getLogger().info("Your plugin is up to date! : " + latestVersion);
                        }

                        return; // Exit the loop after finding version information
                    }
                }
            }
        } catch (IOException e) {
            plugin.getLogger().warning("Failed to check for updates !");
        }
    }
}
