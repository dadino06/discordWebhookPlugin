// (c) 2024 dadino06
// This code is licensed under the MIT license. (See LICENSE.txt for more details.)

package io.github.dadino06.discordHookPlugin;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;


public class WebhookSender {

    private final HttpClient client;
    private final URI webhook;
    private final Path dataFolder;

    public WebhookSender(URI webhook, Path dataFolder) {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        this.webhook = webhook;
        this.dataFolder = dataFolder;
    }

    public void sendStartupMessage() throws FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder(webhook)
                .POST(HttpRequest.BodyPublishers.ofFile(dataFolder.resolve("startMessage.json")))
                .header("Content-Type", "application/json")
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public void sendShutdownMessage() throws FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder(webhook)
                .POST(HttpRequest.BodyPublishers.ofFile(dataFolder.resolve("stopMessage.json")))
                .header("Content-Type", "application/json")
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}
