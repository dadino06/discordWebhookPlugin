# DiscordHookPlugin
## Introduction

This Spigot plugin sends a customizable message through a 
Discord webhook on server startup and server shutdown.
This plugin is not affiliated with Discord in any way, shape or form.

## Configuration

Set the webhook URL in `config.yml` with `webhook-url`.

The messages can be set by modifying the `startMessage.json`
and `stopMessage.json`. Take a look at the relevant 
[Discord documentation](https://discord.com/developers/docs/resources/webhook#execute-webhook)
for information on how to format the files correctly.
Please note that uploading files is not (currently) supported by this plugin.

## Building

Build the project using
```
gradle build
```
This project requires JDK version 21+.

The finished build will be stored inside `build/libs`.

## License 



Copyright 2024 dadino06

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the “Software”),
to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the 
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
DEALINGS IN THE SOFTWARE.
