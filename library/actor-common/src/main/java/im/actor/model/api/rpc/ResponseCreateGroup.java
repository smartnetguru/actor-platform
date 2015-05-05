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

public class ResponseCreateGroup extends Response {

    public static final int HEADER = 0x42;
    public static ResponseCreateGroup fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseCreateGroup(), data);
    }

    private GroupOutPeer groupPeer;
    private int seq;
    private byte[] state;
    private List<Integer> users;
    private long date;

    public ResponseCreateGroup(GroupOutPeer groupPeer, int seq, byte[] state, List<Integer> users, long date) {
        this.groupPeer = groupPeer;
        this.seq = seq;
        this.state = state;
        this.users = users;
        this.date = date;
    }

    public ResponseCreateGroup() {

    }

    public GroupOutPeer getGroupPeer() {
        return this.groupPeer;
    }

    public int getSeq() {
        return this.seq;
    }

    public byte[] getState() {
        return this.state;
    }

    public List<Integer> getUsers() {
        return this.users;
    }

    public long getDate() {
        return this.date;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.groupPeer = values.getObj(1, new GroupOutPeer());
        this.seq = values.getInt(3);
        this.state = values.getBytes(4);
        this.users = values.getRepeatedInt(5);
        this.date = values.getLong(6);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.groupPeer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.groupPeer);
        writer.writeInt(3, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(4, this.state);
        writer.writeRepeatedInt(5, this.users);
        writer.writeLong(6, this.date);
    }

    @Override
    public String toString() {
        String res = "tuple CreateGroup{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
