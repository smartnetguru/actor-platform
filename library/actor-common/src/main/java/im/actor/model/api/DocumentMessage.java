/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.model.api;
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

public class DocumentMessage extends Message {

    private long fileId;
    private long accessHash;
    private int fileSize;
    private EncryptionType encryptionType;
    private byte[] encryptionKey;
    private Integer plainFileSize;
    private String name;
    private String mimeType;
    private FastThumb thumb;
    private DocumentEx ext;

    public DocumentMessage(long fileId, long accessHash, int fileSize, EncryptionType encryptionType, byte[] encryptionKey, Integer plainFileSize, String name, String mimeType, FastThumb thumb, DocumentEx ext) {
        this.fileId = fileId;
        this.accessHash = accessHash;
        this.fileSize = fileSize;
        this.encryptionType = encryptionType;
        this.encryptionKey = encryptionKey;
        this.plainFileSize = plainFileSize;
        this.name = name;
        this.mimeType = mimeType;
        this.thumb = thumb;
        this.ext = ext;
    }

    public DocumentMessage() {

    }

    public int getHeader() {
        return 3;
    }

    public long getFileId() {
        return this.fileId;
    }

    public long getAccessHash() {
        return this.accessHash;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public EncryptionType getEncryptionType() {
        return this.encryptionType;
    }

    public byte[] getEncryptionKey() {
        return this.encryptionKey;
    }

    public Integer getPlainFileSize() {
        return this.plainFileSize;
    }

    public String getName() {
        return this.name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public FastThumb getThumb() {
        return this.thumb;
    }

    public DocumentEx getExt() {
        return this.ext;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.fileId = values.getLong(1);
        this.accessHash = values.getLong(2);
        this.fileSize = values.getInt(3);
        int val_encryptionType = values.getInt(9, 0);
        if (val_encryptionType != 0) {
            this.encryptionType = EncryptionType.parse(val_encryptionType);
        }
        this.encryptionKey = values.optBytes(10);
        this.plainFileSize = values.optInt(11);
        this.name = values.getString(4);
        this.mimeType = values.getString(5);
        this.thumb = values.optObj(6, new FastThumb());
        if (values.optBytes(8) != null) {
            this.ext = DocumentEx.fromBytes(values.getBytes(8));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.fileId);
        writer.writeLong(2, this.accessHash);
        writer.writeInt(3, this.fileSize);
        if (this.encryptionType != null) {
            writer.writeInt(9, this.encryptionType.getValue());
        }
        if (this.encryptionKey != null) {
            writer.writeBytes(10, this.encryptionKey);
        }
        if (this.plainFileSize != null) {
            writer.writeInt(11, this.plainFileSize);
        }
        if (this.name == null) {
            throw new IOException();
        }
        writer.writeString(4, this.name);
        if (this.mimeType == null) {
            throw new IOException();
        }
        writer.writeString(5, this.mimeType);
        if (this.thumb != null) {
            writer.writeObject(6, this.thumb);
        }
        if (this.ext != null) {
            writer.writeBytes(8, this.ext.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "struct DocumentMessage{";
        res += "fileId=" + this.fileId;
        res += ", fileSize=" + this.fileSize;
        res += ", name=" + this.name;
        res += ", mimeType=" + this.mimeType;
        res += ", thumb=" + (this.thumb != null ? "set":"empty");
        res += ", ext=" + (this.ext != null ? "set":"empty");
        res += "}";
        return res;
    }

}
