/*
 * This file is a component of Quartz Powered, this license makes sure any work
 * associated with Quartz Powered, must follow the conditions of the license included.
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Quartz Powered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.quartzpowered.protocol.codec.indentifier;

import org.quartzpowered.network.protocol.Protocol;
import org.quartzpowered.protocol.codec.indentifier.common.client.KickCodec;
import org.quartzpowered.protocol.codec.indentifier.handshake.server.HandshakeCodec;
import org.quartzpowered.protocol.packet.common.client.KickPacket;
import org.quartzpowered.protocol.packet.handshake.server.HandshakePacket;

import static org.quartzpowered.network.protocol.ProtocolState.HANDSHAKE;
import static org.quartzpowered.network.protocol.ProtocolState.LOGIN;

public class IdentifierProtocol extends Protocol {
    @Override
    public String getName() {
        return "identifier";
    }

    @Override
    public int getVersion() {
        return -1;
    }

    @Override
    protected void registerPackets() {
        serverBoundPacket(HANDSHAKE, 0, HandshakePacket.class, new HandshakeCodec());
        clientBoundPacket(LOGIN, 0, KickPacket.class, new KickCodec());
    }
}
