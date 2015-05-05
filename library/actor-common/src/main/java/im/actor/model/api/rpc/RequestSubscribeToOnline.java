/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.model.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserParser;
import im.actor.model.droidkit.bser.BserObject;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import im.actor.model.droidkit.bser.DataInput;
import im.actor.model.droidkit.bser.DataOutput;
import static im.actor.model.droidkit.bser.Utils.*;
import java.io.IOException;
import im.actor.model.network.parser.*;
import java.util.List;
import java.util.ArrayList;
import im.actor.model.api.*;

public class RequestSubscribeToOnline extends Request<ResponseVoid> {

    public static final int HEADER = 0x20;
    public static RequestSubscribeToOnline fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSubscribeToOnline(), data);
    }

    private List<UserOutPeer> users;

    public RequestSubscribeToOnline(List<UserOutPeer> users) {
        this.users = users;
    }

    public RequestSubscribeToOnline() {

    }

    public List<UserOutPeer> getUsers() {
        return this.users;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<UserOutPeer> _users = new ArrayList<UserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _users.add(new UserOutPeer());
        }
        this.users = values.getRepeatedObj(1, _users);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.users);
    }

    @Override
    public String toString() {
        String res = "rpc SubscribeToOnline{";
        res += "users=" + this.users.size();
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
