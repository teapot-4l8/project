package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat localFormat = DateFormat.getDateTimeInstance(2, 2);

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return deserializeToDate(jsonReader.nextString());
    }

    private synchronized Date deserializeToDate(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.enUsFormat.parse(str);
                }
            } catch (ParseException unused2) {
                return ISO8601Utils.parse(str, new ParsePosition(0));
            }
        } catch (ParseException e2) {
            throw new JsonSyntaxException(str, e2);
        }
        return this.localFormat.parse(str);
    }

    @Override // com.google.gson.TypeAdapter
    public synchronized void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.enUsFormat.format(date));
        }
    }
}
