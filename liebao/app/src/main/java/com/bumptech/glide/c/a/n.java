package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class n extends l<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f4665a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f4665a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4665a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4665a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4665a.addURI("com.android.contacts", "contacts/#", 3);
        f4665a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f4665a.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.l
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) {
        InputStream c2 = c(uri, contentResolver);
        if (c2 != null) {
            return c2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) {
        int match = f4665a.match(uri);
        if (match != 1) {
            if (match == 3) {
                return a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return a(contentResolver, lookupContact);
    }

    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.l
    public void a(InputStream inputStream) {
        inputStream.close();
    }

    @Override // com.bumptech.glide.c.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
