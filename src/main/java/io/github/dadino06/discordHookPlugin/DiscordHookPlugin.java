// (c) 2024 dadino06
// This code is licensed under the MIT license. (See LICENSE.txt for more details.)

package io.github.dadino06.discordHookPlugin;

import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

public final class DiscordHookPlugin extends JavaPlugin {

    private WebhookSender sender;

    @Override
    public void onEnable() {
        // Plugin startup logic
        URI uri = null;
        if (!(new File(getDataFolder(), "config.yml").exists())) {
            saveResource("config.yml", false);
        }
        if (!(new File(getDataFolder(), "startMessage.json").exists())) {
            saveResource("startMessage.json", false);
        }
        if (!(new File(getDataFolder(), "stopMessage.json").exists())) {
            saveResource("stopMessage.json", false);
        }
        String webhook = getConfig().getString("webhook-url");
        try {
            uri = new URI(webhook);
        } catch (URISyntaxException e) {
            getComponentLogger().error(Component.text("The provided webhook is not a valid URI!"));
        }
        if (uri != null) {
            sender = new WebhookSender(uri, getDataPath());
            getComponentLogger().info("Loaded discordHookPlugin!");
            try {
                sender.sendStartupMessage();
                getComponentLogger().info(Component.text("Sent startup message!"));
            } catch (FileNotFoundException e) {
                getComponentLogger().error(Component.text("Failed to load startMessage.json!"));
            }
        } else {
            getComponentLogger().error("Failed to load plugin!");
            getServer().getPluginManager().disablePlugin(this);
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (sender != null) {
            try {
                sender.sendShutdownMessage();
                getComponentLogger().info(Component.text("Sent shutdown message!"));
            } catch (FileNotFoundException e) {
                getComponentLogger().error(Component.text("Failed to load stopMessage.json!"));
            }
        }
    }
}
