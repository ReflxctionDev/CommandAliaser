/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.commandaliaser.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.reflxction.commandaliaser.commons.ChatColor;

/**
 * Class which simplifies the {@link net.minecraft.entity.player.EntityPlayer#addChatMessage(IChatComponent)} method and shortens it
 */
public class SimpleSender {

    /**
     * Sends a simple message to the client
     *
     * @param text Text to send, chat-formatted
     */
    public static void send(String text) {
        if (Minecraft.getMinecraft().thePlayer == null) return; // <- For safety
        StringBuilder messageBuilder = new StringBuilder();
        for (String word : text.split(" ")) {
            word = ChatColor.format(ChatColor.getLastColors(text) + word);
            messageBuilder.append(word).append(" ");
        }
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Reference.PREFIX + ChatColor.format(messageBuilder.toString().trim())));
    }

    /**
     * Executes the given command (or sends the text)
     *
     * @param text Text to send
     */
    public static void execute(String text) {
        if (Minecraft.getMinecraft().thePlayer == null) return; // <- For safety
        Minecraft.getMinecraft().thePlayer.sendChatMessage(text);
    }

}
