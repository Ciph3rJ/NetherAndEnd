package net.enderboy500.netherandend.util.icon;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.NetherAndEndCommon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.*;

public class IconUtil {
    public static boolean checkEverything(Icon icon)  {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(NetherAndEndCommon.class.getResourceAsStream("/data/icons.json"))));
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            JsonObject icons = json.getAsJsonObject("icons").get(icon.getId()).getAsJsonObject();
            int startDay = icons.get("start").getAsJsonObject().get("day").getAsInt();
            int startMonth = icons.get("start").getAsJsonObject().get("month").getAsInt();
            int endDay = icons.get("end").getAsJsonObject().get("day").getAsInt();
            int endMonth = icons.get("end").getAsJsonObject().get("month").getAsInt();
            Calendar calendar = Calendar.getInstance();boolean b = icons.get("available").getAsBoolean();

            return (calendar.get(Calendar.MONTH) >= startMonth && calendar.get(Calendar.DATE) >= startDay) && (calendar.get(Calendar.MONTH) <= endMonth && calendar.get(Calendar.DATE) <= endDay) && b;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Icon getAvailableIcon() {
        Icon current = null;
        for (Icon icon : Icon.values()) {
            if (checkEverything(icon)) current = icon;
        }
        return current != null ? current : null;
    }
}
